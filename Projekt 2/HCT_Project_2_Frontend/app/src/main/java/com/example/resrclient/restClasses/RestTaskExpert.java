package com.example.resrclient.restClasses;
import android.os.AsyncTask;

import com.example.resrclient.objectClasses.Expert;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class RestTaskExpert extends AsyncTask<String, Void, Expert> {

    protected Expert doInBackground(String... params) {
        final String url = params[0];
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        Expert result = restTemplate.getForObject(url,Expert.class);

        return result;
    }

    @Override
    protected void onPostExecute(Expert expert) {
        super.onPostExecute(expert);
        Expert expertReturned = expert;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }
}
