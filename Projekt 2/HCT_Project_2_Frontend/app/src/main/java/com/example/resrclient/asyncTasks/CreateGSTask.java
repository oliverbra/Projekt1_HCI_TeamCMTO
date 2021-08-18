package com.example.resrclient.asyncTasks;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.resrclient.objectClasses.GrowSpace;
import com.example.resrclient.objectClasses.User;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public class CreateGSTask extends AsyncTask<String, Void, GrowSpace> {

    Context ctx;
    Double size;

    public CreateGSTask(Context ctx)
    {
        this.ctx = ctx;
    }

    protected GrowSpace doInBackground(String... params) {
        final String url = params[0];
        final String name = params[1];
        final String category = params[2];
        final String goal = params[3];
        final String nsize = params[4];
        size = Double.parseDouble(nsize);
        final String location = params[5];
        final String problems = params[6];

        GrowSpace newGS = new GrowSpace(name, goal, category, size, location, problems, 5.0);

        try{
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            GrowSpace result = restTemplate.postForObject(url, newGS, GrowSpace.class);
            System.out.println("Done. " + result.toString());
            return result;
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("Failed. " + newGS.toString());
        }
        return null;
    }

    @Override
    protected void onPostExecute(GrowSpace growSpace) {
        super.onPostExecute(growSpace);
        GrowSpace growSpaceReturned = growSpace;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

}
