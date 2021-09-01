package com.example.resrclient.restClasses;

import android.os.AsyncTask;

import com.example.resrclient.objectClasses.Level;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class RestTaskProgress extends AsyncTask<String, Void, Level> {

    protected Level doInBackground(String... params) {
        final String url = params[0];
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        Level result = restTemplate.getForObject(url, Level.class);

        return result;
    }

    @Override
    protected void onPostExecute(Level level) {
        super.onPostExecute(level);
        Level levelReturned = level;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }
}