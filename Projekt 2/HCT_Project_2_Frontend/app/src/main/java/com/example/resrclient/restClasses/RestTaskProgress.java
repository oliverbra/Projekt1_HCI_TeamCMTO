package com.example.resrclient.restClasses;

import android.os.AsyncTask;

import com.example.resrclient.objectClasses.Progress;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class RestTaskProgress extends AsyncTask<String, Void, Progress> {

    protected Progress doInBackground(String... params) {
        final String url = params[0];
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        Progress result = restTemplate.getForObject(url,Progress.class);

        return result;
    }

    @Override
    protected void onPostExecute(Progress progress) {
        super.onPostExecute(progress);
        Progress progressReturned = progress;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }
}