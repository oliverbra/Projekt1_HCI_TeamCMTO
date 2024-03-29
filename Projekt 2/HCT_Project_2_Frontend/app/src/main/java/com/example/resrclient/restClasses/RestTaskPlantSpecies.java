package com.example.resrclient.restClasses;

import android.os.AsyncTask;

import com.example.resrclient.objectClasses.Plants;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class RestTaskPlantSpecies extends AsyncTask<String, Void, Plants> {

    protected Plants doInBackground(String... params) {
        final String url = params[0];
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        Plants result = restTemplate.getForObject(url, Plants.class);

        return result;
    }

    @Override
    protected void onPostExecute(Plants plants) {
        super.onPostExecute(plants);
        Plants plantsReturned = plants;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }
}
