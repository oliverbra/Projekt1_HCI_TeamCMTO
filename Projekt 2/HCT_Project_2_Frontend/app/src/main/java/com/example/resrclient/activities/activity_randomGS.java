package com.example.resrclient.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.resrclient.activities.ui.main.SectionsPagerAdapter_MyGrowSpace;
import com.example.resrclient.activities.ui.main.SectionsPagerAdapter_RndGrowSpace;
import com.example.resrclient.databinding.ActivityRandomGsBinding;

import com.example.resrclient.R;
import com.example.resrclient.asyncTasks.RandomGSTask;
import com.example.resrclient.objectClasses.GrowSpace;
import com.example.resrclient.restClasses.RestTaskGrowSpace;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.concurrent.ExecutionException;

public class activity_randomGS extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;//Navigation
    private ActivityRandomGsBinding binding;

    int rndGSId;
    GrowSpace rndGS;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_gs);

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = pref.edit();
        editor.remove("rndGS");
        editor.apply();

        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            rndGSId = extras.getInt("rndGSID");
            String url = "http://10.0.2.2:8080/growspaces/" + rndGSId;
            try {
                rndGS = new RestTaskGrowSpace().execute(url).get();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            editor.putInt("rndGS", rndGSId);
            editor.commit();

        } else {
            try {
                rndGS = new RandomGSTask(this).execute().get();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            rndGSId = rndGS.getId();
            editor.putInt("rndGS", rndGSId);
            editor.commit();
        }

        // Display rndGS information here.
        binding = ActivityRandomGsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        SectionsPagerAdapter_RndGrowSpace sectionsPagerAdapterRndGrowSpace = new SectionsPagerAdapter_RndGrowSpace(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapterRndGrowSpace);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);

    }

    public void changeActivity(View view) {
        Intent intent = new Intent(this, activity_review.class);
        intent.putExtra("rndGSID", rndGSId);
        intent.putExtra("rndGsName", rndGS.getName());
        intent.putExtra("rndGsRating", rndGS.getAverageRating());
        startActivity(intent);
    }

    public void back(View view) {
        Intent intent = new Intent(this, activity_startseite.class);
        startActivity(intent);
    }

    public GrowSpace getRndGS() {
        return rndGS;
    }

}


