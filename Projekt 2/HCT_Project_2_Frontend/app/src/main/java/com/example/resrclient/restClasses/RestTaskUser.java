package com.example.resrclient.restClasses;

import com.example.resrclient.objectClasses.User;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class RestTaskUser extends AsyncTask<String, Void, User> {

    protected User doInBackground(String... params) {
        final String url = params[0];
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        User result = restTemplate.getForObject(url,User.class);

        Log.v("Result","Gefunden: " + result.getUserName());
        return result;
    }

    @Override
    protected void onPostExecute(User user) {
        super.onPostExecute(user);
        User userReturned = user;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }
}
