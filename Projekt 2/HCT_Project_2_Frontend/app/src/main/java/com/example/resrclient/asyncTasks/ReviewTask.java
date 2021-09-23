package com.example.resrclient.asyncTasks;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.util.Log;

import com.example.resrclient.activities.activity_sentReview;
import com.example.resrclient.objectClasses.GrowSpace;
import com.example.resrclient.objectClasses.Review;
import com.example.resrclient.objectClasses.ReviewList;
import com.example.resrclient.objectClasses.User;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.ParameterizedType;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


public class ReviewTask extends AsyncTask<String, Void, GrowSpace> {


    Context ctx;

    public ReviewTask(Context ctx)
    {
        this.ctx = ctx;
    }


    @Override
    protected GrowSpace doInBackground(String... params) {
        final double localCriteria = Double.parseDouble(params[0]);
        final double shelterCriteria = Double.parseDouble(params[1]);
        final double naturalCriteria = Double.parseDouble(params[2]);
        final double dangerCriteria = Double.parseDouble(params[3]);
        final int rndGSID = Integer.parseInt(params[4]);
        final String comment = params[5];

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");


        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(ctx);
        Integer userId = preferences.getInt("userId", 0);

        // get currentUser based on preferenced userId after LoginActivity
        User newUser = new User(userId);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        User currentUser = restTemplate.getForObject("http://10.0.2.2:8080/users/" + newUser.getId(), User.class);
        GrowSpace randomGrowspace = restTemplate.getForObject("http://10.0.2.2:8080/growspaces/" + rndGSID , GrowSpace.class);

        ReviewList response = restTemplate.getForObject("http://10.0.2.2:8080/reviews", ReviewList.class);
        List<Review> allReviews = response.getReviewList();

        Review newReview = new Review(localCriteria, shelterCriteria, naturalCriteria, dangerCriteria, formatter.format(date) , comment, currentUser, randomGrowspace);


        if(randomGrowspace.getAverageRating() != 0) {
            double sumRating = newReview.getRating();
            int counter = 0;
            for (Review review : allReviews)
            {
                if(review.getGrowSpace().getId() == randomGrowspace.getId()) {
                    sumRating += review.getRating();
                    counter++;
                }
            }
            double averageRating = sumRating / (counter + 1);
            randomGrowspace.setAverageRating(averageRating);
        } else {
            randomGrowspace.setAverageRating(newReview.getRating());
        }



        restTemplate.put("http://10.0.2.2:8080/growspaces/", randomGrowspace, GrowSpace.class);
        System.out.println("Updated.");

        Review result = restTemplate.postForObject("http://10.0.2.2:8080/growspaces/" + randomGrowspace.getId() + "/reviews", newReview, Review.class);
        Log.v("Result","Review erstellt.");

        return randomGrowspace;
    }

    @Override
    protected void onPostExecute(GrowSpace growSpace) {
        super.onPostExecute(growSpace);
        Intent i = new Intent(ctx,activity_sentReview.class);
        ctx.startActivity(i);
    }
}
