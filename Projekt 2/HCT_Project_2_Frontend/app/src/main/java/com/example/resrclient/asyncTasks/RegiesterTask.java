package com.example.resrclient.asyncTasks;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.resrclient.MainActivity;
import com.example.resrclient.activities.activity_startseite;
import android.widget.Toast;
import com.example.resrclient.activities.activity_logIn;
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
        final String userEmail = params[1];
        final String userPassword = params[2];
        final String userName = params[3];
        try {

            User newUser = new User(userName, userEmail, userPassword);

            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            User result = restTemplate.postForObject(url, newUser, User.class);
            Log.v("Result", "Erstellt" + result.getEmail() + result.getUserName() + result.getPassword());
            return result;
        } catch (HttpServerErrorException e) {
            Log.v("Resultb", "nicht Regiestriert");
        }
        return null;
    }

    @Override
    protected void onPostExecute(User user) {
        super.onPostExecute(user);
        if (user != null) {
            Intent i = new Intent(ctx, activity_logIn.class);
            ctx.startActivity(i);
        } else {
            Toast lose = Toast.makeText(ctx, "Der angegebene Nutzername oder Email existiert bereits", Toast.LENGTH_SHORT);
            lose.show();
        }
    }


}

