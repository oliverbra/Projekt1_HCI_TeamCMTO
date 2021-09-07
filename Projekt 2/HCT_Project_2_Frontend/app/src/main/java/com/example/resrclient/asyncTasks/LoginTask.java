package com.example.resrclient.asyncTasks;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.util.Log;
import android.util.Patterns;
import com.example.resrclient.MainActivity;
import com.example.resrclient.objectClasses.User;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

public class LoginTask extends AsyncTask<String, Void, User> {


    Context ctx;
    public LoginTask(Context ctx)
    {
        this.ctx = ctx;
    }

    @Override
    protected User doInBackground(String ... params) {
        final String url = params[0];
        final String userEmail = params[1];
        final String userPassword = params[2];
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(ctx);
        SharedPreferences.Editor edit = pref.edit();

            try {
                if (validateInput(userEmail, userPassword)) {

                    User newUser = new User(userEmail,userPassword);

                    RestTemplate restTemplate = new RestTemplate();
                    restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                    User result = restTemplate.postForObject(url, newUser, User.class);
                    Log.v("Result","Gefunden: " + result.getEmail() + result.getPassword());

                    edit.putInt("userId", result.getId());
                    edit.apply();

                    return result;
                }
            } catch (HttpServerErrorException e) {
               System.out.println("User not found");
            }
            return null;
    }


    // Checking if the input in form is valid
    boolean validateInput(String email, String password) {

        if (email.equals("")) {
            return false;
        }
        if (password.equals("")) {
            return false;
        }

        // checking the proper email format
        if (!isEmailValid(email)) {
            return false;
        }

        return true;
    }

    boolean isEmailValid(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    @Override
    protected void onPostExecute(User user) {
        super.onPostExecute(user);
        if(user != null) {
            Intent i = new Intent(ctx,MainActivity.class);
            ctx.startActivity(i);
        }
    }


}