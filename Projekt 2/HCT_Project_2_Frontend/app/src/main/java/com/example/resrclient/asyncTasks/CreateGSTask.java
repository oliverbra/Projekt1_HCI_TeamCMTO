package com.example.resrclient.asyncTasks;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.widget.Toast;

import com.example.resrclient.MainActivity;
import com.example.resrclient.activities.activity_startseite;
import com.example.resrclient.objectClasses.GrowSpace;
import com.example.resrclient.objectClasses.Plants;
import com.example.resrclient.objectClasses.Review;
import com.example.resrclient.objectClasses.User;
import com.example.resrclient.restClasses.RestTaskPlant;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class CreateGSTask extends AsyncTask<String, Void, GrowSpace> {

    Context ctx;
    private String name;
    private String goal;
    private String category;
    private double size;
    private String location;
    private String problems;
    private ArrayList<Plants> plants;
    private ArrayList<Review> reviews;

    public CreateGSTask(Context ctx, String name, String goal, String category, double size, String location, String problems, ArrayList<Plants> plants, ArrayList<Review> reviews) {
        this.ctx = ctx;
        this.name = name;
        this.goal = goal;
        this.category = category;
        this.size = size;
        this.location = location;
        this.problems = problems;
        this.plants = plants;
        this.reviews = reviews;
    }

    protected GrowSpace doInBackground(String... params) {
        final String url = params[0];

        // get currentUser based on preferenced userId after LoginActivity
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(ctx);
        Integer userId = preferences.getInt("userId", 0);
        User newUser = new User(userId);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        User currentUser = restTemplate.getForObject("http://10.0.2.2:8080/users/" + newUser.getId(), User.class);

        GrowSpace newGS = new GrowSpace(currentUser, name, goal, category, size, location, problems, 0.0, false, plants, reviews);

        GrowSpace result = null;
        try{
            result = restTemplate.postForObject(url, newGS, GrowSpace.class);
            System.out.println("Done. " + result.toString());

        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("Failed. " + newGS.toString());
        }

        if(newGS.getPlants().size() != 0) {
            for (Plants plant : newGS.getPlants())
            {
                String plantUrl = "http://10.0.2.2:8080/plants/";
                Plants updatedPlant = plant;
                updatedPlant.setGrowSpace(result);
                restTemplate.put(plantUrl, updatedPlant, Plants.class);
            }
        }

        return result;
    }

    @Override
    protected void onPostExecute(GrowSpace growSpace) {
        super.onPostExecute(growSpace);
        if(growSpace != null) {
            Intent i = new Intent(ctx, activity_startseite.class);
            ctx.startActivity(i);
        }
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

}
