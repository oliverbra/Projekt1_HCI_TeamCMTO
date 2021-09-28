package com.example.resrclient.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.resrclient.R;
import com.example.resrclient.asyncTasks.AllReviewsTask;
import com.example.resrclient.objectClasses.Review;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class activity_startseite extends AppCompatActivity{

    BottomNavigationView bottomNavigationView;

    List<Review> allReviews;
    ImageView unopenedReviewIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startseite);

        bottomNavigationView=findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.nav_to_favourites);

        unopenedReviewIcon = findViewById(R.id.unopenedReviewIcon);

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
                 case R.id.nav_to_favourites:
                     startActivity(new Intent(getApplicationContext(),activity_favourites.class)); // Code hübschen effiezent machen
                     overridePendingTransition(0,0);
                     return true;
             }
             return false;

         }
     });

        //Display notification icon if unopened reviews are available
        try {
            allReviews = new AllReviewsTask(this).execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int reviewCounter = 0;
        for (Review review : allReviews)
        {
            if(!review.getOpen()) {
               reviewCounter++;
            }
        }
        if(reviewCounter != 0) {
            unopenedReviewIcon.setVisibility(View.VISIBLE);
        } else {
            unopenedReviewIcon.setVisibility(View.GONE);
        }

    }

    public void chanceProgress(View view) {
        Intent intent = new Intent(this, activity_progress.class);
        startActivity(intent); }

    public void chanceGS(View view) {
        Intent intent = new Intent(this, activity_growspace.class);
        startActivity(intent); }

    public void changeReviews(View view) {
        Intent intent = new Intent(this, activity_openAllReviews.class);
        startActivity(intent); }

    public void changeRandomGS(View view) {
        Intent intent = new Intent(this, activity_randomGS.class);
        startActivity(intent); }

    public void changeCreateGS(View view) {
        Intent intent = new Intent(this, activity_createGS.class);
        startActivity(intent); }


/* altes Navigation
 private  BottomNavigationView.OnNavigationItemSelectedListener bottomNavMethod=new
                BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        return false;
                    }

                          }; */
}