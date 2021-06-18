package com.example.resrclient;

import android.os.AsyncTask;
import android.os.Bundle;

import com.fasterxml.jackson.databind.MappingIterator;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.resrclient.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

import android.widget.EditText;

import android.content.Intent;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class MainActivity extends AppCompatActivity {



    private AppBarConfiguration appBarConfiguration;
  //  private ActivityMainBinding binding;
    private static final String URL = "http://192.168.0.135:8080";

    // OBA
    class RESTTask extends AsyncTask<String, Void, Person> {
        protected Person doInBackground(String... params) {
          //  String apiUrl = "http://localhost:8080/personAli";
            final String url = params[0];
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            Person result = restTemplate.getForObject(url,Person.class);

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
        // Ende


    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

/*
    @Override
        protected void onCreate(Bundle savedInstanceState) {


            super.onCreate(savedInstanceState);

            binding = ActivityMainBinding.inflate(getLayoutInflater());
            setContentView(binding.getRoot());


        }
*/
    // OBA  192.168.0.135
    public void chanceActivity(View view) {
        Intent intent = new Intent(this, activity_logIn.class);
        startActivity(intent);
    }
    // Ende
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.action_settings) {
                return true;
            }

            return super.onOptionsItemSelected(item);
        }



}