package com.example.resrclient.restClasses;

import android.os.AsyncTask;

import com.example.resrclient.objectClasses.Mark;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class RestTaskMark extends AsyncTask<String, Void, Mark> {

    protected Mark doInBackground(String... params) {
        final String url = params[0];
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        Mark result = restTemplate.getForObject(url,Mark.class);

        return result;
    }

    @Override
    protected void onPostExecute(Mark mark) {
        super.onPostExecute(mark);
        Mark markReturned = mark;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }
}