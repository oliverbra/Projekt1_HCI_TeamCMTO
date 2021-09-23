package com.example.resrclient.restClasses;

import android.os.AsyncTask;

import com.example.resrclient.objectClasses.Review;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class RestTaskReview extends AsyncTask<String, Void, Review> {

    protected Review doInBackground(String... params) {
        final String url = params[0];
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        Review result = restTemplate.getForObject(url,Review.class);

        return result;
    }

    @Override
    protected void onPostExecute(Review review) {
        super.onPostExecute(review);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }
}