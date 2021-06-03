package com.example.resrclient;

import android.os.AsyncTask;
import android.os.Bundle;

import com.fasterxml.jackson.databind.MappingIterator;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.resrclient.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class MainActivity extends AppCompatActivity {



    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private static final String URL = "http://localhost:8080";

    // OBA
    class RESTTask extends AsyncTask<String, Void, Person> {
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
        // Ende


        // OBA  192.168.0.135
        public void sendMessage(View view) {
            //final String url = URL+"/personAli";
            final String url = "http://10.0.2.2:8080/personAli";
             new RESTTask().execute(url);
        }
        // Ende

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            binding = ActivityMainBinding.inflate(getLayoutInflater());
            setContentView(binding.getRoot());

            setSupportActionBar(binding.toolbar);

            NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
            appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
            NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

            binding.fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            });
        }

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

        @Override
        public boolean onSupportNavigateUp() {
            NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
            return NavigationUI.navigateUp(navController, appBarConfiguration)
                    || super.onSupportNavigateUp();
        }

}