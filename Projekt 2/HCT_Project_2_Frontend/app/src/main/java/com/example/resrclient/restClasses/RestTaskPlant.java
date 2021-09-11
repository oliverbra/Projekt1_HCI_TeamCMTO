package com.example.resrclient.restClasses;

import android.os.AsyncTask;

import com.example.resrclient.objectClasses.Plants;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class RestTaskPlant extends AsyncTask<String, Void, List<Plants>> {



    protected List<Plants> doInBackground(String... params) {
        final String url = params[0];
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        List<Plants> result = (List<Plants>) restTemplate.getForObject(url, Plants.class);

        return result;
    }

    @Override
    protected void onPostExecute(List<Plants> plants) {
        super.onPostExecute(plants);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }
}
