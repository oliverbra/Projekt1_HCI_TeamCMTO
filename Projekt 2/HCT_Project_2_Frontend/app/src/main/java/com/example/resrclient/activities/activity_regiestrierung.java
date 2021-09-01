package com.example.resrclient.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.resrclient.R;
import com.example.resrclient.asyncTasks.RegiesterTask;

public class activity_regiestrierung extends AppCompatActivity {
    private EditText vornameText ;
    private EditText nachnameText ;
    private EditText emailAdress ;
    private EditText passwort ;
    private EditText geburstag ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regiestrierung);
    }

    public void checkInfo(View v){

        vornameText = findViewById(R.id.regiestrierung_Vorname_editTextTextPersonName);
        nachnameText = findViewById(R.id.regiestrierung_Vorname_editTextTextPersonNachname);
         emailAdress = findViewById(R.id.regiestrierung_email_editTextTextEmailAddress);
         passwort = findViewById(R.id.regiestrierung_passwort_editTextTextPassword);
         geburstag = findViewById(R.id.regiestrierung_geburstag_editTextDate);
        boolean isEmpty = vornameText.getText().toString().equals("") || nachnameText.getText().toString().equals("") || emailAdress.getText().toString().equals("") || passwort.getText().toString().equals("") || geburstag.getText().toString().equals("");
        if (!isEmpty){
           Toast win = Toast.makeText(this, "Erfolg",Toast.LENGTH_SHORT);
           win.show();
           createUser();
        } else {Toast lose = Toast.makeText(this, "Fehlende Infos",Toast.LENGTH_SHORT);
        lose.show();}

        }

        public void createUser(){
        final String url = "http://192.168.0.242:8081/users";
        new RegiesterTask(this).execute(url,vornameText.getText().toString(),emailAdress.getText().toString(),passwort.getText().toString(),geburstag.getText().toString());
        }
    public void chanceActivity() {
        Intent intent = new Intent(this, activity_startseite.class);
        startActivity(intent); }


}