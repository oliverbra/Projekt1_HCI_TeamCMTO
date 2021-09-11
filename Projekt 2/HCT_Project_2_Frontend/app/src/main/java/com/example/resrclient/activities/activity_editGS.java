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
import com.example.resrclient.asyncTasks.EditGSTask;
import com.example.resrclient.asyncTasks.LoginTask;
import com.example.resrclient.objectClasses.GrowSpace;
import com.example.resrclient.restClasses.RestTaskGrowSpace;

public class activity_editGS extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private GrowSpace growSpace;
    private EditText name, goal, size, location, problems;
    private String category;
    // TO DO: Pflanzen mit einbinden, Bilder hochladen / entfernen, Owner übermitteln
    // plants, images, owner
    private String sAverageRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_gs);

        Spinner spinner = (Spinner) findViewById(R.id.editGS_categories_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.gs_categories, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        name = findViewById(R.id.editGS_name_editTextTextName);
        goal = findViewById(R.id.editGS_goal_editTextTextGoal);
        size = findViewById(R.id.editGS_size_editTextTextSize);
        location = findViewById(R.id.editGS_location_editTextTextLocation);
        problems = findViewById(R.id.editGS_problems_editTextTextProblems);

        // TO DO: GS an Acitivity vermitteln
        growSpace = new GrowSpace("Test GS", "Bunte Blumen","Category 2", 50.0, "Köln", "Keine Insekten schauen vorbei", 0.0);
        sAverageRating = "" + growSpace.getAverageRating();

        //Prefill textfields / spinner with given data from selected GS
        name.setText(growSpace.getName());
        goal.setText(growSpace.getGoal());
        size.setText("" + growSpace.getSize());
        location.setText(growSpace.getLocation());
        problems.setText(growSpace.getProblems());

        if(growSpace.getCategory() == "Category 1") {
            spinner.setSelection(1);
        } else if(growSpace.getCategory() == "Category 2") {
            spinner.setSelection(2);
        } else {spinner.setSelection(3);}
    }

    boolean validateInput(String name, String category) {

        if (name.equals("") || category.equals("")) {
            return false;
        } else { return true;}
    }

    public void editGSAction(View view){
        final String url = "http://10.0.2.2:8080/growspaces";
        try {
            if ( validateInput(name.getText().toString(), category)) {
                new EditGSTask(this).execute(url, name.getText().toString(), category, goal.getText().toString(), size.getText().toString(), location.getText().toString(), problems.getText().toString(), sAverageRating );
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