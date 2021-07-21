package com.example.resrclient.restClasses;

import android.os.AsyncTask;

import com.example.resrclient.objectClasses.PlantSpecies;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class RestTaskPlantSpecies extends AsyncTask<String, Void, PlantSpecies> {

    protected PlantSpecies doInBackground(String... params) {
        final String url = params[0];
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        PlantSpecies result = restTemplate.getForObject(url,PlantSpecies.class);

        return result;
    }

    @Override
    protected void onPostExecute(PlantSpecies plantSpecies) {
        super.onPostExecute(plantSpecies);
        PlantSpecies plantSpeciesReturned = plantSpecies;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }
}
