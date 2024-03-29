package com.example.resrclient.asyncTasks;


import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.util.Patterns;

import com.example.resrclient.activities.activity_startseite;

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

            try {
                if (validateInput(userEmail, userPassword)) {

                    User newUser = new User(userEmail,userPassword);

                    RestTemplate restTemplate = new RestTemplate();
                    restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                    User result = restTemplate.postForObject(url, newUser, User.class);
                    Log.v("Result","Gefunden: " + result.getEmail() + result.getPassword());


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
            Intent i = new Intent(ctx,activity_startseite.class);
            ctx.startActivity(i);
        }
    }


    //TODO: weiterleiten auf registrieren page
    /*
    public void goToSignup(View v) {
        Intent intent = new Intent(this, SignupActivity.class);
        startActivity(intent);
    }

     */

}