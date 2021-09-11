package com.example.resrclient.asyncTasks;

import android.os.AsyncTask;

import com.example.resrclient.objectClasses.User;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutionException;

public class UpdateUserGP extends AsyncTask<String, Void, User> {

    protected User doInBackground(String... params) {
        final String url = params[0];
        final String nGp = params[1];
        final int gp = Integer.parseInt(nGp);

        User updatedUser = new User();
        updatedUser.setGrowpoints(gp);

        try{
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            restTemplate.put(url, updatedUser, User.class);
            System.out.println("Done.");
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("Failed.");
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
