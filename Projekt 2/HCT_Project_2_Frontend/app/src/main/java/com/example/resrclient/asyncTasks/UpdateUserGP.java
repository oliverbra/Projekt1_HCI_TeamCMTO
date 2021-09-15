package com.example.resrclient.asyncTasks;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;

import com.example.resrclient.objectClasses.Plants;
import com.example.resrclient.objectClasses.Review;
import com.example.resrclient.objectClasses.User;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class UpdateUserGP extends AsyncTask<String, Void, User> {

    Context ctx;

    public UpdateUserGP(Context ctx) {
        this.ctx = ctx;
    }

    protected User doInBackground(String... params) {
        final String url = params[0];
        final int gp = Integer.parseInt(params[1]);
        final int level = Integer.parseInt(params[2]);


        // get currentUser based on preferenced userId after LoginActivity
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(ctx);
        Integer userId = preferences.getInt("userId", 0);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        User updatedUser = restTemplate.getForObject("http://10.0.2.2:8080/users/" + userId, User.class);

        updatedUser.setGrowpoints(gp);
        updatedUser.getLevel().setId(level);

        try{
            restTemplate.put(url, updatedUser, User.class);
            System.out.println("Done 2.");
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("Failed. User ID: " + updatedUser.getId());
        }
        return updatedUser;
    }

    @Override
    protected void onPostExecute(User user) {
        super.onPostExecute(user);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }
}
