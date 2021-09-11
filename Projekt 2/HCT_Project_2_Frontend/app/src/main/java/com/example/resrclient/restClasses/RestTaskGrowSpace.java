package com.example.resrclient.restClasses;
import android.os.AsyncTask;

import com.example.resrclient.objectClasses.GrowSpace;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class RestTaskGrowSpace extends AsyncTask<String, Void, GrowSpace> {

    protected GrowSpace doInBackground(String... params) {
        final String url = params[0];
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        GrowSpace result = restTemplate.getForObject(url,GrowSpace.class);

        return result;
    }

    @Override
    protected void onPostExecute(GrowSpace growSpace) {
        super.onPostExecute(growSpace);
        GrowSpace growSpaceReturned = growSpace;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }
}