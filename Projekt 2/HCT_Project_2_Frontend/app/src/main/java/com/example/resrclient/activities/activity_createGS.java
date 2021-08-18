package com.example.resrclient.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.resrclient.R;
import com.example.resrclient.asyncTasks.CreateGSTask;

public class activity_createGS extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private EditText name, goal, size, location, problems;
    private String category;
    // TO DO: Pflanzen mit einbinden, Bilder hochladen / entfernen, Owner übermitteln
    // plants, images, owner

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_gs);

        Spinner spinner = (Spinner) findViewById(R.id.createGS_categories_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.gs_categories, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        name = findViewById(R.id.createGS_name_editTextTextName);
        goal = findViewById(R.id.createGS_goal_editTextTextGoal);
        size = findViewById(R.id.createGS_size_editTextTextSize);
        location = findViewById(R.id.createGS_location_editTextTextLocation);
        problems = findViewById(R.id.createGS_problems_editTextTextProblems);
    }

    boolean validateInput(String name, String category) {

        if (name.equals("") || category.equals("")) {
            return false;
        } else { return true;}
    }

    public void createGSAction(View view){
        final String url = "http://10.0.2.2:8080/growspaces";
        try {
            if ( validateInput(name.getText().toString(), category)) {
                new CreateGSTask(this).execute(url, name.getText().toString(), category, goal.getText().toString(), size.getText().toString(), location.getText().toString(), problems.getText().toString());
            } else {
                Toast.makeText(this, "Fill out required fields", Toast.LENGTH_SHORT).show();}
        } catch (Exception e) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(position == 0) {
            category = "";
        } else {
        category = parent.getItemAtPosition(position).toString(); }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        category = "";
    }
}
