package com.example.resrclient.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.resrclient.R;
import com.example.resrclient.asyncTasks.ReviewTask;

public class activity_review extends AppCompatActivity {

    private RatingBar localCriteria, shelterCriteria, naturalCriteria, dangerCriteria, ratingBar;
    private TextView textView;
    private EditText comment;
    int rndGSId;
    double rating;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            rndGSId = extras.getInt("rndGSID");
            rating = extras.getDouble("rndGsRating");
            name = extras.getString("rndGsName");
        }

        localCriteria = findViewById(R.id.localRatingBar);
        shelterCriteria = findViewById(R.id.shelterRatingBar);
        naturalCriteria = findViewById(R.id.naturalRatingBarr);
        dangerCriteria = findViewById(R.id.dangerRatingBar);
        comment = findViewById(R.id.commentField);

        textView = findViewById(R.id.rnd_gs_growSpace_name_textView);
        textView.setText(name);

        ratingBar = findViewById(R.id.rnd_gs_rating);
        ratingBar.setRating((float) rating);

    }


    public void chanceActivity(View view) {
        Intent intent = new Intent(this, activity_randomGS.class);
        intent.putExtra("rndGSID", rndGSId);
        startActivity(intent);
    }

     public void createReviewAction(View view){
         new ReviewTask(this).execute(Float.toString(localCriteria.getRating()), Float.toString(shelterCriteria.getRating()),
                 Float.toString(naturalCriteria.getRating()), Float.toString(dangerCriteria.getRating()),Integer.toString(rndGSId) ,comment.getText().toString());
     }

}