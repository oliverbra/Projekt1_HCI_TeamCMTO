package com.example.resrclient;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;

import com.fasterxml.jackson.databind.MappingIterator;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Html;
import android.util.Log;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import com.example.resrclient.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String URL = "http://localhost:8080";

    private Button button;
    private ViewPager2 carousel;
    private LinearLayout dotsLayout;
    private ImageView[] dots;


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


    // OBA  192.168.0.135 - (Oli: url set to local host; not vm)
    public void sendMessage(View view) {
        final String url = "http://10.0.2.2:8080/personAli";
        new RESTTask().execute(url);
    }
    // Ende

    // Oli - Dots Indicator Bar
    public void addDotsIndicator(List<CarouselItem> carouselItems) {
        dots = new ImageView[carouselItems.size()];
        dotsLayout.removeAllViews();

        for(int i = 0; i < carouselItems.size(); i++) {

            dots[i] = new ImageView(this);
            dots[i].setImageResource(R.drawable.dot_inactive);
            dots[i].setPadding(3,0,3,0);

            dotsLayout.addView(dots[i]);
            Log.v("dots", "Dot " + i + " added");
        }
    }

    ViewPager2.OnPageChangeCallback carouselListener = new ViewPager2.OnPageChangeCallback() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            super.onPageScrolled(position, positionOffset, positionOffsetPixels);
        }

        @Override
        public void onPageSelected(int position) {
            super.onPageSelected(position);
            for(int i = 0; i < dots.length; i++) {
                if(i == position) {
                    dots[i].setImageResource(R.drawable.dot_active);
                } else dots[i].setImageResource(R.drawable.dot_inactive);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {
            super.onPageScrollStateChanged(state);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.buttonREST_GET); // PoC Server Communication

        carousel = (ViewPager2) findViewById(R.id.carousel); // Carousel
        dotsLayout = (LinearLayout) findViewById(R.id.dotsLayout); // Carousel

        // Carousel
        List<CarouselItem> carouselItems = new ArrayList<>();
        carouselItems.add(new CarouselItem(R.drawable.one));
        carouselItems.add(new CarouselItem(R.drawable.two));
        carouselItems.add(new CarouselItem(R.drawable.three));
        carouselItems.add(new CarouselItem(R.drawable.four));
        carouselItems.add(new CarouselItem(R.drawable.five));

        carousel.setAdapter(new CarouselAdapter(carouselItems, carousel));

            /*/ Extra: Nachbar-Images am Rand erkennbar
            carousel.setClipToPadding(false);
            carousel.setClipChildren(false);
            carousel.setOffscreenPageLimit(3);
            carousel.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

            CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
            compositePageTransformer.addTransformer(new MarginPageTransformer(40));
            compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
                @Override
                public void transformPage(@NonNull View page, float position) {
                    float r = 1 - Math.abs(position);
                    page.setScaleY(0.85f + r * 0.15f);
                }
            });

            carousel.setPageTransformer(compositePageTransformer); */

        // Dots Indicator hinzufügen
        addDotsIndicator(carouselItems);
        carousel.registerOnPageChangeCallback(carouselListener);
    }

    public void chanceActivity(View view) {
        Intent intent = new Intent(this, activity_logIn.class);
        startActivity(intent);
    }

}