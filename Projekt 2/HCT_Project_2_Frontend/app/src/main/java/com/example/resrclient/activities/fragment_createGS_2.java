package com.example.resrclient.activities;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.resrclient.R;

import org.jetbrains.annotations.NotNull;

public class fragment_createGS_2 extends Fragment {

    public fragment_createGS_2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_g_s_2, container, false);
    }


    //Im onViewCreated wird dem Button eine Aktion zugeordnet
    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        NavController navController = Navigation.findNavController(view);

        Button button = view.findViewById(R.id.tofrag1btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Hier wird die Navigation von Frag1 und Frag2 definiert
                //Die Action ID wird aus dem navgraph übernommen
                navController.navigate(R.id.action_fragment_createGS_2_to_fragment_createGS_1);
            }
        });

    }

}