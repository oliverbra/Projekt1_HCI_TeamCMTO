package com.example.resrclient.asyncTasks;

import android.os.AsyncTask;

import com.example.resrclient.objectClasses.GrowSpace;
import com.example.resrclient.objectClasses.PlantList;
import com.example.resrclient.objectClasses.Plants;
import com.example.resrclient.objectClasses.Review;
import com.example.resrclient.objectClasses.User;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class AllAddedPlantsTask extends AsyncTask<String, Void, List<Plants>> {

    @Override
    protected List<Plants> doInBackground(String... params) {

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        PlantList response = restTemplate.getForObject("http://10.0.2.2:8080/plants", PlantList.class);
        List<Plants> allPlants = response.getPlantsList();

        //get currentGS
        final int gsId = Integer.parseInt(params[0]);

        List<Plants> myPlants = new ArrayList<>();
        for (Plants plant : allPlants)
        {
            if(plant.getGrowSpace() != null) {
                if(plant.getGrowSpace().getId() == gsId) {
                    myPlants.add(plant);
                }
            }
        }

        return myPlants;


    }
}
