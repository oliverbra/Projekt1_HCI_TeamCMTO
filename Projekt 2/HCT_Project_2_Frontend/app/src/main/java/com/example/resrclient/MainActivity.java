package com.example.resrclient;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import com.example.resrclient.activities.activity_editGS;
import com.example.resrclient.activities.activity_logIn;
import com.example.resrclient.activities.activity_createGS;
import com.example.resrclient.carousel.CarouselAdapter;
import com.example.resrclient.carousel.CarouselItem;
import com.example.resrclient.objectClasses.Person;
import com.example.resrclient.restClasses.RestTaskExample;
import com.example.resrclient.restClasses.RestTaskUser;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import androidx.viewpager2.widget.ViewPager2;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

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


    // OBA  192.168.0.135 - (Oli: url set to local host; not vm)
    public void sendMessage(View view) {
        //final String url = "http://10.0.2.2:8080/personAli";
        //new RestTaskExample().execute(url);
        final String url = "http://10.0.2.2:8080/userTest";
        new RestTaskUser().execute(url);
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
    // Ende

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
        // Ende
    }

    public void chanceActivity(View view) {
        Intent intent = new Intent(this, activity_logIn.class);
        startActivity(intent);
    }

    public void chanceActivity2(View view) {
        Intent intent = new Intent(this, activity_createGS.class);
        startActivity(intent);
    }

    public void chanceActivity3(View view) {
        Intent intent = new Intent(this, activity_editGS.class);
        startActivity(intent);
    }

}