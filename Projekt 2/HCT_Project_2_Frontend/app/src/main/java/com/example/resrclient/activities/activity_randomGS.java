package com.example.resrclient.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.resrclient.activities.ui.main.SectionsPagerAdapter;
import com.example.resrclient.databinding.ActivityRandomgsBinding;

import com.example.resrclient.MainActivity;
import com.example.resrclient.R;
import com.example.resrclient.activities.ui.main.SectionsPagerAdapter;
import com.example.resrclient.asyncTasks.RandomGSTask;
import com.example.resrclient.objectClasses.GrowSpace;
import com.example.resrclient.objectClasses.User;
import com.example.resrclient.restClasses.RestTaskUser;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.concurrent.ExecutionException;

public class activity_randomGS extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;//Navigation
    private ActivityRandomgsBinding binding;

    int rndGSId;
    GrowSpace rndGS;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_randomgs);

        try {
            rndGS = new RandomGSTask(this).execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        rndGSId = rndGS.getId();

        // Display rndGS information here.


        //Navigation
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setSelectedItemId(R.id.nav_to_home);

        //Perform ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_to_home:
                        startActivity(new Intent(getApplicationContext(), activity_startseite.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.nav_to_profile:
                        startActivity(new Intent(getApplicationContext(), activity_progress.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.nav_to_favourites:
                        startActivity(new Intent(getApplicationContext(), activity_favourites.class)); // Code hübschen effiezent machen
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;

            }
        });

        binding = ActivityRandomgsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);

    }

    public void changeActivity(View view) {
        Intent intent = new Intent(this, activity_review.class);
        intent.putExtra("rndGSID", rndGSId);
        startActivity(intent);
    }


}


