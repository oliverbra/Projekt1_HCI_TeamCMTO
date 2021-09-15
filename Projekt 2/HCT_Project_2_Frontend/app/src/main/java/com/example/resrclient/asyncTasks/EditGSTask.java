package com.example.resrclient.asyncTasks;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;

import com.example.resrclient.activities.activity_growspace;
import com.example.resrclient.activities.activity_startseite;
import com.example.resrclient.objectClasses.GrowSpace;
import com.example.resrclient.objectClasses.Plants;
import com.example.resrclient.objectClasses.User;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

public class EditGSTask extends AsyncTask<String, Void, GrowSpace> {
    Context ctx;
    private String name;
    private String goal;
    private String category;
    private double size;
    private String location;
    private String problems;
    private ArrayList<Plants> plants;

    public EditGSTask(Context ctx, String name, String goal, String category, double size, String location, String problems, ArrayList<Plants> plants) {
        this.ctx = ctx;
        this.name = name;
        this.goal = goal;
        this.category = category;
        this.size = size;
        this.location = location;
        this.problems = problems;
        this.plants = plants;
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

        // apply changes to the GrowSpace
        GrowSpace updatedGS = currentUser.getGrowSpace();
        updatedGS.setName(name);
        updatedGS.setGoal(goal);
        updatedGS.setCategory(category);
        updatedGS.setSize(size);
        updatedGS.setLocation(location);
        updatedGS.setPlants(plants);


        try{
            restTemplate.put(url, updatedGS, GrowSpace.class);
            System.out.println("Done. ");
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("Failed. ");
        }
        return updatedGS;
    }

    @Override
    protected void onPostExecute(GrowSpace growSpace) {
        super.onPostExecute(growSpace);
        if(growSpace != null) {
            Intent i = new Intent(ctx, activity_growspace.class);
            ctx.startActivity(i);
        }
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

}
