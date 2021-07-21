package com.example.resrclient.restClasses;

import android.os.AsyncTask;

import com.example.resrclient.objectClasses.ReviewCriteria;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class RestTaskReviewCriteria extends AsyncTask<String, Void, ReviewCriteria> {

    protected ReviewCriteria doInBackground(String... params) {
        final String url = params[0];
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        ReviewCriteria result = restTemplate.getForObject(url,ReviewCriteria.class);

        return result;
    }

    @Override
    protected void onPostExecute(ReviewCriteria reviewCriteria) {
        super.onPostExecute(reviewCriteria);
        ReviewCriteria reviewCriteriaReturned = reviewCriteria;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }
}
