package com.example.resrclient.activities;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.adapters.AdapterViewBindingAdapter;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.resrclient.R;
import com.example.resrclient.asyncTasks.AllPlantsTask;
import com.example.resrclient.asyncTasks.CreateGSTask;
import com.example.resrclient.objectClasses.Plants;
import com.example.resrclient.objectClasses.Review;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;


public class fragment_createGS_1 extends Fragment {

    private EditText name, goal, size, location, problems;
    private String category;
    private ArrayList<Review> reviews;
    private List<Plants> allPlants;
    private ArrayList<Plants> selectedPlants;

    private Button createGSbtn;


    public fragment_createGS_1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_create_g_s_1, container, false);

        String url = "http://10.0.2.2:8080/plants";
        try {
            allPlants = new AllPlantsTask().execute(url).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Spinner spinner = v.findViewById(R.id.createGS_categories_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(v.getContext(), R.array.gs_categories, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        //Todo: Hier müssen wir prüfen ob das so richtig ist, habe den Code von der acitvity_createGS() übernommen
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Called when item is selected, use position of item to find it from the list
                String item = parent.getItemAtPosition(position).toString();

                System.out.println("Value was:" + item);

                if(position == 0) {
                    category = "";
                } else {
                    category = parent.getItemAtPosition(position).toString(); }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Called when no item is selected
                category = "";
            }
        });


        name = v.findViewById(R.id.createGS_name_editTextTextName);
        goal = v.findViewById(R.id.createGS_goal_editTextTextGoal);
        size = v.findViewById(R.id.createGS_size_editTextTextSize);
        location = v.findViewById(R.id.createGS_location_editTextTextLocation);
        problems = v.findViewById(R.id.createGS_problems_editTextTextProblems);

        createGSbtn = (Button)v.findViewById(R.id.createGS_submit_button);
        createGSbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createGSAction(v);
            }
        });


        // TO DO: Add selected plants into ArrayList selectedPlants + remove deselected plants
        // --> warten auf Design-Entscheidung
        // TO DO: Upload image + remove image

        return v;
    }

    boolean validateInput(String name, String category) {

        if (name.equals("") || category.equals("")) {
            return false;
        } else { return true;}
    }

    //Todo: Hier müssen wir prüfen ob das so richtig ist, habe den Code von der acitvity_createGS() übernommen und von this zu view.getContext geändert
    public void createGSAction(View view){
        final String url = "http://10.0.2.2:8080/growspaces";
        try {
            if ( validateInput(name.getText().toString(), category)) {
                new CreateGSTask(view.getContext(), name.getText().toString(), goal.getText().toString(), category, Double.parseDouble(size.getText().toString()), location.getText().toString(), problems.getText().toString(), selectedPlants, reviews).execute(url);
            } else {
                Toast.makeText(view.getContext(), "Fill out required fields", Toast.LENGTH_SHORT).show();}
        } catch (Exception e) {
            Toast.makeText(view.getContext(), e.toString(), Toast.LENGTH_SHORT).show();
            Log.v("Create", e.toString());
        }
    }



    //Im onViewCreated wird dem Button eine Aktion zugeordnet
    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        NavController navController = Navigation.findNavController(view);

        Button button = view.findViewById(R.id.testbtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Hier wird die Navigation von Frag1 und Frag2 definiert
                //Die Action ID wird aus dem navgraph übernommen
                navController.navigate(R.id.action_fragment_createGS_1_to_fragment_createGS_2);
            }
        });

    }


}