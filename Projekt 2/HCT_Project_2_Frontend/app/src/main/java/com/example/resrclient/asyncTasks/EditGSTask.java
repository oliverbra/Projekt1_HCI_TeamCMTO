package com.example.resrclient.asyncTasks;

import android.content.Context;
import android.os.AsyncTask;

import com.example.resrclient.objectClasses.GrowSpace;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class EditGSTask extends AsyncTask<String, Void, GrowSpace> {
    Context ctx;
    Double size, averageRating;

    public EditGSTask(Context ctx)
    {
        this.ctx = ctx;
    }

    protected GrowSpace doInBackground(String... params) {
        final String url = params[0];
        final String name = params[1];
        final String category = params[2];
        final String goal = params[3];
        final String nSize = params[4];
        size = Double.parseDouble(nSize);
        final String location = params[5];
        final String problems = params[6];
        final String nAverageRating = params[7];
        averageRating = Double.parseDouble(nAverageRating);

        GrowSpace updatedGS = new GrowSpace(name, goal, category, size, location, problems, averageRating);

        try{
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            restTemplate.put(url, updatedGS, GrowSpace.class);
            System.out.println("Done. ");
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("Failed. ");
        }
        return updatedGS;
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
