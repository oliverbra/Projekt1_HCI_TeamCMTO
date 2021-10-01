package com.example.resrclient.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.resrclient.R;
import com.example.resrclient.objectClasses.Review;
import com.example.resrclient.objectClasses.User;
import com.example.resrclient.restClasses.RestTaskReview;
import com.example.resrclient.restClasses.RestTaskUser;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.concurrent.ExecutionException;

public class activity_openReview extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    int reviewId, receivedGP;
    Review thisReview;
    User currentUser;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_openreview);

        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            reviewId = extras.getInt("reviewID");
        }
        String url = "http://10.0.2.2:8080/reviews/" + reviewId;
        try {
            thisReview = new RestTaskReview().execute(url).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Get currentUser based on preferenced userId after LoginActivity
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        int userId = preferences.getInt("userId", 0);
        url = "http://10.0.2.2:8080/users/" + userId;
        try {
            currentUser = new RestTaskUser().execute(url).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(!thisReview.getOpen()) {
            Toast.makeText(this, "Du hast eine neue Review erhalten! Basierend auf dem Rating wurden dir " + currentUser.getReviewPoints(thisReview) + " gutgeschrieben!", Toast.LENGTH_SHORT).show();
            try {
                receivedGP = currentUser.openReview(thisReview, this);
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //Display review here
        TextView gsName = findViewById(R.id.rnd_gs_growSpace_name_textView);
        gsName.setText(currentUser.getGrowSpace().getName());

        RatingBar localrating = findViewById(R.id.review_localRatingBar);
        localrating.setRating((float)thisReview.getLocalCriteria());

        RatingBar shelterrating = findViewById(R.id.review_shelterRatingBar);
        shelterrating.setRating((float)thisReview.getShelterCriteria());

        RatingBar naturalrating = findViewById(R.id.review_naturalRatingBar);
        naturalrating.setRating((float)thisReview.getNaturalCriteria());

        RatingBar dangerrating = findViewById(R.id.review_dangerRatingBar);
        dangerrating.setRating((float)thisReview.getDangerCriteria());


        RatingBar averagerating = findViewById(R.id.review_average);
        averagerating.setRating((float)thisReview.getRating());

        TextView comment = findViewById(R.id.comment_textView);
        if(thisReview.getComment().isEmpty()){
            comment.setVisibility(View.INVISIBLE);
            findViewById(R.id.review_Comment_textView4).setVisibility(View.INVISIBLE);
        }
        comment.setText(thisReview.getComment());

    }

    public void changeActivity(View view) {
        Intent intent = new Intent(this, activity_openAllReviews.class);
        startActivity(intent);
    }

}
