package com.example.resrclient.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import com.example.resrclient.asyncTasks.LoginTask;
import com.example.resrclient.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class activity_logIn extends AppCompatActivity {
    BottomNavigationView bottomNavigationView; //Navigation
    private EditText email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        email = findViewById(R.id.logIN_email_editTextTextEmailAddress);
        password = findViewById(R.id.logIN_pw_editTextTextPassword);
    }

    public void chanceActivity(View view) {
        Intent intent = new Intent(this, activity_editGS.class);
        startActivity(intent);
    }

    public void changeToregiestrierung(View view) {
        Intent intent = new Intent(this, activity_regiestrierung.class);
        startActivity(intent);
    }

    public void loginAction(View view){
        final String url = "http://10.0.2.2:8080/login";
        new LoginTask(this).execute(url, email.getText().toString(), password.getText().toString());
    }
}