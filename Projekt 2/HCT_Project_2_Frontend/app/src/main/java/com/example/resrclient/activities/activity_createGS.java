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
import com.example.resrclient.asyncTasks.AllPlantsTask;
import com.example.resrclient.asyncTasks.CreateGSTask;
import com.example.resrclient.objectClasses.Plants;
import com.example.resrclient.objectClasses.Review;
import com.example.resrclient.restClasses.RestTaskPlant;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

//public class activity_createGS extends AppCompatActivity implements AdapterView.OnItemSelectedListener
public class activity_createGS extends AppCompatActivity {

    private EditText name, goal, size, location, problems;
    private String category;
    private ArrayList<Review> reviews;
    private List<Plants> allPlants;
    private ArrayList<Plants> selectedPlants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_gs);

//        String url = "http://10.0.2.2:8080/plants";
//        try {
//            allPlants = new AllPlantsTask().execute(url).get();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        Spinner spinner = findViewById(R.id.createGS_categories_spinner);
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.gs_categories, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(adapter);
//        spinner.setOnItemSelectedListener(this);
//
//        name = findViewById(R.id.createGS_name_editTextTextName);
//        goal = findViewById(R.id.createGS_goal_editTextTextGoal);
//        size = findViewById(R.id.createGS_size_editTextTextSize);
//        location = findViewById(R.id.createGS_location_editTextTextLocation);
//        problems = findViewById(R.id.createGS_problems_editTextTextProblems);


        // TO DO: Add selected plants into ArrayList selectedPlants + remove deselected plants
        // --> warten auf Design-Entscheidung
        // TO DO: Upload image + remove image

    }

//    boolean validateInput(String name, String category) {
//
//        if (name.equals("") || category.equals("")) {
//            return false;
//        } else { return true;}
//    }
//
//    public void createGSAction(View view){
//        final String url = "http://10.0.2.2:8080/growspaces";
//        try {
//            if ( validateInput(name.getText().toString(), category)) {
//                new CreateGSTask(this, name.getText().toString(), goal.getText().toString(), category, Double.parseDouble(size.getText().toString()), location.getText().toString(), problems.getText().toString(), selectedPlants, reviews).execute(url);
//            } else {
//                Toast.makeText(this, "Fill out required fields", Toast.LENGTH_SHORT).show();}
//        } catch (Exception e) {
//            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
//            Log.v("Create", e.toString());
//        }
//    }

//    @Override
//    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        if(position == 0) {
//            category = "";
//        } else {
//        category = parent.getItemAtPosition(position).toString(); }
//    }
//
//    @Override
//    public void onNothingSelected(AdapterView<?> parent) {
//        category = "";
//    }
}
