package com.example.resrclient.asyncTasks;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;

import com.example.resrclient.objectClasses.Review;
import com.example.resrclient.objectClasses.ReviewList;
import com.example.resrclient.objectClasses.User;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class TaskGetAllReviewsGrowSpace extends AsyncTask<String, Void, List<Review>> {

    Context ctx;

    public TaskGetAllReviewsGrowSpace(Context ctx)
    {
        this.ctx = ctx;
    }

    @Override
    protected List<Review> doInBackground(String... strings) {


        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(ctx);
        Integer userId = preferences.getInt("userId", 0);

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        ReviewList response = restTemplate.getForObject("http://10.0.2.2:8080/reviews", ReviewList.class);
        List<Review> allReviews = response.getReviewList();


        //get currentUser based on preferenced userId after LoginActivity
        User newUser = new User(userId);
        User currentUser = restTemplate.getForObject("http://10.0.2.2:8080/users/" + newUser.getId(), User.class);



        return allReviews;
    }
}
