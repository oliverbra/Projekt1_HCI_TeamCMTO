package com.example.resrclient.asyncTasks;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;

import com.example.resrclient.objectClasses.GrowSpace;
import com.example.resrclient.objectClasses.User;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class RandomGSTask extends AsyncTask<String, Void, GrowSpace> {

    Context ctx;

    public RandomGSTask(Context ctx)
    {
        this.ctx = ctx;
    }

    @Override
    protected GrowSpace doInBackground(String... strings) {

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(ctx);
        Integer userId = preferences.getInt("userId", 0);

        // get currentUser based on preferenced userId after LoginActivity
        User newUser = new User(userId);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        User currentUser = restTemplate.getForObject("http://10.0.2.2:8080/users/" + newUser.getId(), User.class);
        GrowSpace randomGrowspace = restTemplate.getForObject("http://10.0.2.2:8080/growspaces/random/" + currentUser.getGrowSpace().getId() , GrowSpace.class);

        return randomGrowspace;
    }
}
