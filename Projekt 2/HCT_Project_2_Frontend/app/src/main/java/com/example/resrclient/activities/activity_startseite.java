package com.example.resrclient.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.resrclient.R;

public class activity_startseite extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startseite);
    }

    public void chanceProgress(View view) {
        Intent intent = new Intent(this, activity_progress.class);
        startActivity(intent); }

    public void chanceGS(View view) {
        Intent intent = new Intent(this, activity_growspace.class);
        startActivity(intent); }
}