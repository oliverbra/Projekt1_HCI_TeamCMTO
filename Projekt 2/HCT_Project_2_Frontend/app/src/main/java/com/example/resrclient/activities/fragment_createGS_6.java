package com.example.resrclient.activities;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.resrclient.R;
import com.example.resrclient.asyncTasks.CreateGSTask;
import com.example.resrclient.objectClasses.Plants;
import com.example.resrclient.objectClasses.Review;
import com.example.resrclient.restClasses.RestTaskPlant;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutionException;

public class fragment_createGS_6 extends Fragment {

    private String name;
    private String category;
    private double size;
    private String location;
    private String goal;
    private String problems;
    private ArrayList<Review> reviews;
    private ArrayList<Plants> selectedPlants = new ArrayList<>();

    public fragment_createGS_6() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_create_g_s_6, container, false);
        Bundle bundle = this.getArguments();

        name = bundle.getString("name");
        category = bundle.getString("category");
        size = bundle.getDouble("size");
        location = bundle.getString("location");
        goal = bundle.getString("goal");
        problems = bundle.getString("problems");

        Set<String> set = new HashSet<String>();
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this.getContext());
        set = pref.getStringSet("selectedPlants", null);

        if(set != null) {
            for (String entry : set)
            {
                String url = "http://10.0.2.2:8080/plants/" + entry;
                Plants selectedPlant = null;
                try {
                    selectedPlant = new RestTaskPlant().execute(url).get();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                selectedPlants.add(selectedPlant);
            }
        }


        return v;
    }


    public void createGSAction(View view){
        final String url = "http://10.0.2.2:8080/growspaces";
        try {
            new CreateGSTask(view.getContext(), name, goal, category, size, location, problems, selectedPlants, reviews).execute(url);
        } catch (Exception e) {
            Toast.makeText(view.getContext(), e.toString(), Toast.LENGTH_SHORT).show();
            Log.v("Create", e.toString());
        }
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        NavController navController = Navigation.findNavController(view);

        Button createGSbtn = view.findViewById(R.id.createGS_submit_button);
        createGSbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createGSAction(v);
            }
        });
    }
}