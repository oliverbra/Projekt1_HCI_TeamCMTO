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
import android.widget.EditText;
import android.widget.TextView;

import com.example.resrclient.R;

import org.jetbrains.annotations.NotNull;

public class fragment_createGS_3 extends Fragment {

    private EditText goal, problems;

    public fragment_createGS_3() {
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
        View v = inflater.inflate(R.layout.fragment_create_g_s_3, container, false);

        goal = v.findViewById(R.id.createGS_goal_editTextTextGoal);
        problems = v.findViewById(R.id.createGS_problems_editTextTextProblems);

        return v;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        NavController navController = Navigation.findNavController(view);
        Bundle bundle = this.getArguments();

        //Hier der Button der zum 4. Fragment führt
        Button toFrag3btn = view.findViewById(R.id.frag3tofrag4);
        toFrag3btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putString("goal", goal.getText().toString());
                bundle.putString("problems", problems.getText().toString());
                bundle.putAll(bundle);

                navController.navigate(R.id.action_fragment_createGS_3_to_fragment_createGS_4, bundle);
            }
        });

    }
}