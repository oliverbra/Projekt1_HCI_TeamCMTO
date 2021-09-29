package com.example.resrclient.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.resrclient.R;
import com.example.resrclient.asyncTasks.TaskGetUser;
import com.example.resrclient.objectClasses.User;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.concurrent.ExecutionException;

public class activity_progress extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        bottomNavigationView=findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.nav_to_profile);

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
        User userObjekt = new User();
        try {
             userObjekt = new TaskGetUser(this).execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        TextView username = findViewById(R.id.username_Textview);
        TextView levelText = findViewById(R.id.progress_Level_textView);
        ProgressBar bar = findViewById(R.id.progress_level_progressBar);
        TextView unlockedText = findViewById(R.id.progress_unlocked_editTextTextMultiLine);
        TextView lockedText = findViewById(R.id.progress_locked_editTextTextMultiLine2);

        username.setText(userObjekt.getUserName());
        bar.setProgress(userObjekt.getGrowpoints());
        levelText.setText(userObjekt.getLevel().getLevelName());

        switch (userObjekt.getLevel().getLevel()){
            case 1:
                unlockedText.setText("Du kannst nun Bewertungen schreiben!");
                lockedText.setText("Kommentieren");
                break;
            case 2:
                unlockedText.setText("Zweiter Grow Space wurde freigeschaltet");
                lockedText.setText("Coole Sachen");
                break;
            case 3:
                unlockedText.setText("Bewerbung Experte möglich");
                lockedText.setText("Maximales Level erreicht");
                break;
            default:
                unlockedText.setText("Noch bist im Onboarding");
                lockedText.setText("kommentieren freischalten");
        }



    }

    public void chanceActivity(View view) {
        Intent intent = new Intent(this, activity_startseite.class);
        startActivity(intent); }
}