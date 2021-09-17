package com.example.resrclient.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.resrclient.R;
import com.example.resrclient.activities.ui.main.SectionsPagerAdapter;
import com.example.resrclient.asyncTasks.ShowGrowspaceTask;
import com.example.resrclient.databinding.ActivityGrowspaceBinding;

import com.example.resrclient.objectClasses.GrowSpace;
import com.example.resrclient.objectClasses.User;
import com.example.resrclient.restClasses.RestTaskUser;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.concurrent.ExecutionException;

public class activity_growspace extends AppCompatActivity {

    BottomNavigationView bottomNavigationView; //Navigation
    private TextView name, goal, category;
    private GrowSpace growSpace;

    private ActivityGrowspaceBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_growspace);



        name = findViewById(R.id.growSpace_name_textView);
        goal = findViewById(R.id.growSpace_Ziel_textView);
        category = findViewById(R.id.growSpace_Kategorie_textView);

/*
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        Integer userId = preferences.getInt("userId", 0);
        String url = "http://10.0.2.2:8080/users/" + userId;
        User currentUser = null;
        try {
            currentUser = new RestTaskUser().execute(url).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        growSpace = currentUser.getGrowSpace();

        name.setText(growSpace.getName());
        goal.setText(growSpace.getGoal());
        category.setText(growSpace.getCategory());

*/

        //Navigation
        bottomNavigationView=findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setSelectedItemId(R.id.nav_to_home);

        //Perform ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_to_home:
                        startActivity(new Intent(getApplicationContext(),activity_startseite.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_to_profile:
                        startActivity(new Intent(getApplicationContext(),activity_progress.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_to_startseite:
                        startActivity(new Intent(getApplicationContext(),activity_favourites.class)); // Code hübschen effiezent machen
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;

            }
        });

        binding = ActivityGrowspaceBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);

    }

    public void chanceActivity(View view) {
        Intent intent = new Intent(this, activity_startseite.class);
        startActivity(intent); }
}