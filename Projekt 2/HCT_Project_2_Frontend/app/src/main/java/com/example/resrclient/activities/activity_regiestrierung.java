package com.example.resrclient.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.resrclient.R;
import com.example.resrclient.asyncTasks.RegiesterTask;

public class activity_regiestrierung extends AppCompatActivity {
    private EditText username;
    private EditText emailAdress ;
    private EditText passwort ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regiestrierung);
    }

    public void checkInfo(View v){

        username = findViewById(R.id.regiestrierung_Vorname_editTextTextPersonUsername);
         emailAdress = findViewById(R.id.regiestrierung_email_editTextTextEmailAddress);
         passwort = findViewById(R.id.regiestrierung_passwort_editTextTextPassword);

        boolean isEmpty =  username.getText().toString().equals("") || emailAdress.getText().toString().equals("") || passwort.getText().toString().equals("") ;
        if (!isEmpty){
           createUser();
        } else {
                Toast lose = Toast.makeText(this, "Fehlende Infos",Toast.LENGTH_SHORT);
                lose.show();}
                }

        public void createUser(){
        final String url = "http://10.0.2.2:8080/users";
        new RegiesterTask(this).execute(url,emailAdress.getText().toString(),passwort.getText().toString(), username.getText().toString());
        }
    public void chanceActivity() {
        Intent intent = new Intent(this, activity_startseite.class);
        startActivity(intent); }

    public void changeToLogin(View view) {
        Intent intent = new Intent(this, activity_logIn.class);
        startActivity(intent);
    }
}