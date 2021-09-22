package com.example.resrclient.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.resrclient.MainActivity;
import com.example.resrclient.R;
import com.example.resrclient.asyncTasks.RandomGSTask;
import com.example.resrclient.objectClasses.GrowSpace;
import com.example.resrclient.objectClasses.User;
import com.example.resrclient.restClasses.RestTaskUser;

import java.util.concurrent.ExecutionException;

public class activity_randomGS extends AppCompatActivity {

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


    }

    public void changeActivity(View view) {
        Intent intent = new Intent(this, activity_review.class);
        intent.putExtra("rndGSID", rndGSId);
        startActivity(intent);
    }


}


