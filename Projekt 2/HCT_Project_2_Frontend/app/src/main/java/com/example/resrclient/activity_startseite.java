package com.example.resrclient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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