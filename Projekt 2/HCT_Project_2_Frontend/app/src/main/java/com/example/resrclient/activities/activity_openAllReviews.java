package com.example.resrclient.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.example.resrclient.R;
import com.example.resrclient.asyncTasks.AllReviewsTask;
import com.example.resrclient.objectClasses.Review;

import com.example.resrclient.Adapter.CustomAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
public class activity_openAllReviews extends AppCompatActivity {

    int reviewId;
    List<Review> allReviews;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_openallreviews);
        ListView listReviews = findViewById(R.id.simpleListView);
        try {
            allReviews = new AllReviewsTask(this).execute().get();

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Display all reviews and make selection possible here

//        Log.v("REVIEW", "REVIEWS" +  allReviews.get(0).getId());
        CustomAdapter adapter = new CustomAdapter(getApplicationContext(),R.layout.list_item_style,allReviews);
        List<String> justRating = new ArrayList<String>();
        for (int i = 0; i<allReviews.size();i++){

            justRating.add(String.valueOf("Review "+i+": "+allReviews.get(i).getRating()));
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,justRating);
        listReviews.setAdapter(arrayAdapter);

        listReviews.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            public void onItemClick(AdapterView<?> adapter, View view, int i, long l) {
                String selItem = (String) listReviews.getItemAtPosition(i);
                Log.v("REVIEW", "Selected Review" + String.valueOf(i)+" + " +allReviews.get(i).getId());
                //Ruft die OpenRevie Task auf damit das Revie im Detail angezeigt wird
                Intent intent = new Intent(getApplicationContext(), activity_openReview.class);
                intent.putExtra("reviewID",allReviews.get(i).getId() );
                startActivity(intent);
            }
        });
        //For testing:
        reviewId = 17;

    }

    public void changeActivity(View view) {
        Intent intent = new Intent(this, activity_openReview.class);
       intent.putExtra("reviewID", reviewId);
        startActivity(intent);
    }

    public void backActivity(View view) {
        Intent intent = new Intent(this, activity_startseite.class);
        startActivity(intent);
    }

}
