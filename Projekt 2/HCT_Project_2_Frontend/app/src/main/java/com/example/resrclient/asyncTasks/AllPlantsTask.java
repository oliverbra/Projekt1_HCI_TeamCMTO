package com.example.resrclient.asyncTasks;

import android.os.AsyncTask;

import com.example.resrclient.objectClasses.PlantList;
import com.example.resrclient.objectClasses.Plants;
import com.example.resrclient.objectClasses.Review;
import com.example.resrclient.objectClasses.ReviewList;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class AllPlantsTask extends AsyncTask<String, Void, List<Plants>> {


    @Override
    protected List<Plants> doInBackground(String... strings) {

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        PlantList response = restTemplate.getForObject("http://10.0.2.2:8080/plants", PlantList.class);
        List<Plants> allPlants = response.getPlantsList();

        return allPlants;


    }
}
