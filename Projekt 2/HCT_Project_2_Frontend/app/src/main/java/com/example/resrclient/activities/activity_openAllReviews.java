package com.example.resrclient.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;


import com.example.resrclient.R;
import com.example.resrclient.asyncTasks.AllReviewsTask;
import com.example.resrclient.objectClasses.Review;

import com.example.resrclient.allReviewsView.AllReviewsAdapter;

import java.util.List;
import java.util.concurrent.ExecutionException;
public class activity_openAllReviews extends AppCompatActivity {

    int reviewId;
    List<Review> allReviews;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_openallreviews);

        try {
            allReviews = new AllReviewsTask(this).execute().get();

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Display all reviews and make selection possible here
        if(allReviews != null) {
            ListView lv = findViewById(R.id.reviewListView);
            AllReviewsAdapter allReviewsAdapter = new AllReviewsAdapter(this, allReviews);
            lv.setAdapter(allReviewsAdapter);
        }

    }

    public void backActivity(View view) {
        Intent intent = new Intent(this, activity_startseite.class);
        startActivity(intent);
    }
}
