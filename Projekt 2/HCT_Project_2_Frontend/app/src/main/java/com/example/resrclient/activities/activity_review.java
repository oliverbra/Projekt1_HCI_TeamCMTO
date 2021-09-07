package com.example.resrclient.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import com.example.resrclient.R;
import com.example.resrclient.asyncTasks.ReviewTask;

public class activity_review extends AppCompatActivity {

    private RatingBar localCriteria, shelterCriteria, naturalCriteria, dangerCriteria;
    private EditText comment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        localCriteria = findViewById(R.id.localRatingBar);
        shelterCriteria = findViewById(R.id.shelterRatingBar);
        naturalCriteria = findViewById(R.id.naturalRatingBarr);
        dangerCriteria = findViewById(R.id.dangerRatingBar);
        comment = findViewById(R.id.commentField);
    }


    public void chanceActivity(View view) {
        Intent intent = new Intent(this, activity_startseite.class);
        startActivity(intent);
    }

     public void createReviewAction(View view){
         new ReviewTask(this).execute(Float.toString(localCriteria.getRating()), Float.toString(shelterCriteria.getRating()),
                 Float.toString(naturalCriteria.getRating()), Float.toString(dangerCriteria.getRating()), comment.toString());
     }

}