package com.example.resrclient.activities;

import android.content.ClipData;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.resrclient.R;
import com.example.resrclient.activities.plantView.PlantAdapter;
import com.example.resrclient.asyncTasks.AllPlantsTask;
import com.example.resrclient.objectClasses.Plants;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class fragment_createGS_5plants extends Fragment {

    private List<Plants> allPlants;
    private int[] selectedPlants;

    public fragment_createGS_5plants() {
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
        View v = inflater.inflate(R.layout.fragment_create_g_s_plants, container, false);

        String url = "http://10.0.2.2:8080/plants";
       try {
           allPlants = new AllPlantsTask().execute(url).get();
       } catch (ExecutionException e) {
          e.printStackTrace();
       } catch (InterruptedException e) {
            e.printStackTrace();
       }

       return v;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        NavController navController = Navigation.findNavController(view);
        Bundle bundle = this.getArguments();

        ListView lv = view.findViewById(R.id.plantsListView);
        PlantAdapter plantAdapter = new PlantAdapter(this.getContext(), allPlants);
        lv.setAdapter(plantAdapter);

        //Hier der Button der zum 6. Fragment führt
        Button toFrag3btn = view.findViewById(R.id.frag5tofrag6);
        toFrag3btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_fragment_createGS_5plants_to_fragment_createGS_6, bundle);
            }
        });
    }

    public static int addPlant(int id) {
        return id;
    }

    public static void removePlant(int id) {

    }
}