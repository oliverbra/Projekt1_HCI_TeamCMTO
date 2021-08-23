package com.example.resrclient.asyncTasks;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import com.example.resrclient.activities.activity_startseite;
import com.example.resrclient.objectClasses.User;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

public class RegiesterTask extends AsyncTask<String,Void, User> {
    Context ctx;

    public RegiesterTask(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    protected User doInBackground(String... params) {

        final String url = params[0];
        final String userName = params[1];
        final String userEmail = params[2];
        final String userPassword = params[3];
        final String userAge = params[4];
        try {

            User newUser = new User(userName, userEmail, userPassword, userAge);

            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            Log.v("Resultbsdsd", "nicht Regiestriert");
            User result = restTemplate.postForObject(url, newUser, User.class);
            Log.v("Resulta", "Erstellt" + result.getEmail() + result.getAge() + result.getUserName() + result.getPassword());
        } catch (HttpServerErrorException e) {
            Log.v("Resultb", "nicht Regiestriert");
        }
        return null;
    }

    @Override
    protected void onPostExecute(User user) {
        super.onPostExecute(user);
        if (user != null) {
            Intent i = new Intent(ctx, activity_startseite.class);
            ctx.startActivity(i);
        }
    }

}