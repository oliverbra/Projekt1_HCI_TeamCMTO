package com.example.resrclient.asyncTasks;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;

import com.example.resrclient.objectClasses.User;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class TaskGetUser extends AsyncTask<String,Void, User> {

    Context ctx;

    public TaskGetUser(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    protected User doInBackground(String... params) {
        //final String url = params[0];

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(ctx);
        Integer userId = preferences.getInt("userId", 0);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        try {
            User user = restTemplate.getForObject("http://10.0.2.2:8080/users/" + userId, User.class);
            return user;
        }catch (Exception e){
            return null;
        }



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
