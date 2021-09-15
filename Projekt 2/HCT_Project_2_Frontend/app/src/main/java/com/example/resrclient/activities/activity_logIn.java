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
        //Navigation
        bottomNavigationView=findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setSelectedItemId(R.id.nav_to_login);

        //Perform ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_to_growSpace:
                        startActivity(new Intent(getApplicationContext(),activity_growspace.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_to_login:
                        startActivity(new Intent(getApplicationContext(),activity_logIn.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_to_startseite:
                        startActivity(new Intent(getApplicationContext(),activity_startseite.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
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
        final String url = "http://10.0.2.2:8080/login";
        new LoginTask(this).execute(url, email.getText().toString(), password.getText().toString());
    }
}