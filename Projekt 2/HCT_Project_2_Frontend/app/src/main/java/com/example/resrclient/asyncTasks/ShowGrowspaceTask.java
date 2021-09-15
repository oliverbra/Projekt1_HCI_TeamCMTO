package com.example.resrclient.asyncTasks;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;

import com.example.resrclient.objectClasses.GrowSpace;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class ShowGrowspaceTask extends AsyncTask<String, Void, GrowSpace> {



    Context ctx;
    public ShowGrowspaceTask(Context ctx)
    {
        this.ctx = ctx;
    }

    @Override
    protected GrowSpace doInBackground(String... strings) {

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(ctx);
        Integer userId = preferences.getInt("userId", 0);

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());




        GrowSpace ownGrowspace = restTemplate.getForObject("/growspaces/" + userId + "/growspace", GrowSpace.class);


        return ownGrowspace;

    }

    @Override
    protected void onPostExecute(GrowSpace growspace) {
        super.onPostExecute(growspace);
    }


}
