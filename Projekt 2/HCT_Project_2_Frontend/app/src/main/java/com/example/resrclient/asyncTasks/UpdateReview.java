package com.example.resrclient.asyncTasks;

import android.os.AsyncTask;

import com.example.resrclient.objectClasses.Review;
import com.example.resrclient.objectClasses.User;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class UpdateReview extends AsyncTask<String, Void, Review> {

    @Override
    protected Review doInBackground(String... params) {
        final int id = Integer.parseInt(params[0]);

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        Review reviewToUpdate = restTemplate.getForObject("http://10.0.2.2:8080/reviews/" + id,Review.class);

        reviewToUpdate.open();

        restTemplate.put("http://10.0.2.2:8080/reviews", reviewToUpdate, Review.class);

        return reviewToUpdate;
    }
}
