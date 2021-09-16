package com.example.resrclient.asyncTasks;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;

import com.example.resrclient.MainActivity;
import com.example.resrclient.activities.activity_sentReview;
import com.example.resrclient.objectClasses.GrowSpace;
import com.example.resrclient.objectClasses.Review;
import com.example.resrclient.objectClasses.User;
import com.example.resrclient.restClasses.RestTaskReview;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;


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
        final String comment = params[4];

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");


        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(ctx);
        Integer userId = preferences.getInt("userId", 0);

        // get currentUser based on preferenced userId after LoginActivity
        User newUser = new User(userId);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        User currentUser = restTemplate.getForObject("http://10.0.2.2:8080/users/" + newUser.getId(), User.class);
        GrowSpace randomGrowspace = restTemplate.getForObject("http://10.0.2.2:8080/growspaces/random" , GrowSpace.class);

        Review newReview = new Review(localCriteria, shelterCriteria, naturalCriteria, dangerCriteria, formatter.format(date) , comment, currentUser, randomGrowspace);
        randomGrowspace.setReviews(new ArrayList<>());
        randomGrowspace.addReview(newReview);

        double sumRating = 0;
        for (Review review : randomGrowspace.getReviews())
        {
            sumRating += review.getRating();
        }
        double averageRating = sumRating / randomGrowspace.getReviews().size();
        randomGrowspace.setAverageRating(averageRating);

        restTemplate.put("http://10.0.2.2:8080/growspaces/" + randomGrowspace.getId(), randomGrowspace, GrowSpace.class);
        System.out.println("Updated.");

        //Review result = restTemplate.postForObject("http://10.0.2.2:8080/growspaces/" + randomGrowspace.getId() + "/reviews", newReview, Review.class);
        //Log.v("Result","Review erstellt.");

        return randomGrowspace;
    }

    @Override
    protected void onPostExecute(GrowSpace growSpace) {
        super.onPostExecute(growSpace);
        Intent i = new Intent(ctx,activity_sentReview.class);
        ctx.startActivity(i);
    }
}
