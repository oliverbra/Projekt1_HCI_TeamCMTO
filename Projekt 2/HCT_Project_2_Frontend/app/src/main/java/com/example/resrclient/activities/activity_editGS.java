package com.example.resrclient.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.resrclient.R;
import com.example.resrclient.asyncTasks.EditGSTask;
import com.example.resrclient.objectClasses.GrowSpace;
import com.example.resrclient.objectClasses.Plants;
import com.example.resrclient.objectClasses.User;
import com.example.resrclient.restClasses.RestTaskUser;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class activity_editGS extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private static final int PICK_IMAGE = 1;
    private GrowSpace growSpace;
    private EditText name, goal, size, location, problems;
    private String category;
    private List<Plants> allPlants;
    private ArrayList<Plants> selectedPlants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_gs);

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
        growSpace = currentUser.getGrowSpace();

        /*/ Get all plants to let users select from them
        url = "http://10.0.2.2:8080/plants";
        try {
            allPlants = new RestTaskPlant().execute(url).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } */

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

        //Prefill textfields / spinner with given data from selected GS
        name.setText(growSpace.getName());
        goal.setText(growSpace.getGoal());
        size.setText("" + growSpace.getSize());
        location.setText(growSpace.getLocation());
        problems.setText(growSpace.getProblems());

        Log.v("Spinner", growSpace.getName());
        Log.v("Spinner", growSpace.getCategory());
        if(growSpace.getCategory().equals("Category 1")) {
            spinner.setSelection(1);
        } else if(growSpace.getCategory().equals("Category 2")) {
            spinner.setSelection(2);
        } else {spinner.setSelection(3);}

        // TO DO: Add selected plants into ArrayList selectedPlants + remove deselected plants
        // --> warten auf Design-Entscheidung
        // TO DO: Upload image + remove image
    }

    public void editGSAction(View view){
        final String url = "http://10.0.2.2:8080/growspaces";
        try {
            if ( validateInput(name.getText().toString(), category)) {
                new EditGSTask(this, name.getText().toString(), goal.getText().toString(), category, Double.parseDouble(size.getText().toString()) , location.getText().toString(), problems.getText().toString(), selectedPlants).execute(url);
            } else {
                Toast.makeText(this, "Fill out required fields", Toast.LENGTH_SHORT).show();}
        } catch (Exception e) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    public void selectPicture(View view){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ImageView teaserBild = findViewById(R.id.editGS_previewBild_imageView);
        if (resultCode == RESULT_OK) {

            // compare the resultCode with the
            // SELECT_PICTURE constant
            if (requestCode == PICK_IMAGE) {
                // Get the url of the image from data
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                    // update the preview image in the layout
                    teaserBild.setImageURI(selectedImageUri);
                }
            }
        }
    }

    boolean validateInput(String name, String category) {

        if (name.equals("") || category.equals("")) {
            return false;
        } else { return true;}
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