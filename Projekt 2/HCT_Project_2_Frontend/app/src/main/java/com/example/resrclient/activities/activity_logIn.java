package com.example.resrclient.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.example.resrclient.asyncTasks.LoginTask;
import com.example.resrclient.R;


public class activity_logIn extends AppCompatActivity {

    private EditText email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        email = findViewById(R.id.logIN_email_editTextTextEmailAddress);
        password = findViewById(R.id.logIN_pw_editTextTextPassword);
    }

    public void chanceActivity(View view) {
        Intent intent = new Intent(this, activity_startseite.class);
        startActivity(intent);
    }

    public void changeToregiestrierung(View view) {
        Intent intent = new Intent(this, activity_regiestrierung.class);
        startActivity(intent);
    }

    public void loginAction(View view){
        final String url = "http://192.168.2.101:8080/login";
        new LoginTask(this).execute(url, email.getText().toString(), password.getText().toString());
    }
}