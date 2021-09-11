package com.example.resrclient.asyncTasks;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.widget.Toast;

import com.example.resrclient.objectClasses.GrowSpace;
import com.example.resrclient.objectClasses.Plants;
import com.example.resrclient.objectClasses.Review;
import com.example.resrclient.objectClasses.User;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class CreateGSTask extends AsyncTask<String, Void, GrowSpace> {

    Context ctx;
    private String name;
    private String goal;
    private String category;
    private double size;
    private String location;
    private String problems;
    private ArrayList<Plants> plants;
    private List<Review> reviews;

    public CreateGSTask(Context ctx, String name, String goal, String category, double size, String location, String problems, ArrayList<Plants> plants, List<Review> reviews) {
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
        User currentUser = restTemplate.getForObject("http://192.168.2.101:8080/users/" + newUser.getId(), User.class);

        GrowSpace newGS = new GrowSpace(currentUser, name, goal, category, size, location, problems, 0.0, false, plants, reviews);

        try{
            GrowSpace result = restTemplate.postForObject(url, newGS, GrowSpace.class);
            System.out.println("Done. " + result.toString());
            return result;
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("Failed. " + newGS.toString());
        }
        return null;
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
