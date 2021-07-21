package com.example.resrclient.restClasses;

import android.os.AsyncTask;
import android.util.Log;

import com.example.resrclient.objectClasses.Person;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class RestTaskExample  extends AsyncTask<String, Void, Person> {

    protected Person doInBackground(String... params) {
        //  String apiUrl = "http://localhost:8080/personAli";
        final String url = params[0];
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        Person result = restTemplate.getForObject(url,Person.class);

        Log.v("Result","Gefunden: " + result.getName());
        return result;
    }

    @Override
    protected void onPostExecute(Person person) {
        super.onPostExecute(person);
        Person personReturned = person;

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }
}
