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
import com.example.resrclient.objectClasses.User;
import com.example.resrclient.restClasses.RestTaskUser;
import java.util.concurrent.ExecutionException;

public class activity_sentReview extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sent_review);

        //TO DO: Display Sent Review

        // Get current Growspace by get currentUser based on preferenced userId after LoginActivity
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        int userId = preferences.getInt("userId", 0);
        String url = "http://10.0.2.2:8080/users/" + userId;
        User currentUser = null;
        try {
            currentUser = new RestTaskUser().execute(url).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Toast.makeText(this, "Review gesendet. 10GP herhalten. Weiter so!", Toast.LENGTH_SHORT).show();

        try {
            currentUser.increaseGP(10, this);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void chanceActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}
