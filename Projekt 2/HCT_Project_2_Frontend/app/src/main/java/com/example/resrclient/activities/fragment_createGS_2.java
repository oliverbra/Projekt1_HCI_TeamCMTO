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
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.resrclient.R;

import org.jetbrains.annotations.NotNull;

public class fragment_createGS_2 extends Fragment {

    private EditText size, location;

    public fragment_createGS_2() {
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
        View v = inflater.inflate(R.layout.fragment_create_g_s_2, container, false);

        size = v.findViewById(R.id.createGS_size_editTextTextSize);
        location = v.findViewById(R.id.createGS_location_editTextTextLocation);

        return v;
    }


    //Im onViewCreated wird dem Button eine Aktion zugeordnet
    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        NavController navController = Navigation.findNavController(view);
        Bundle bundle = this.getArguments();




        //Hier der Button der zum 3. Fragment führt
        ImageButton toFrag3btn = view.findViewById(R.id.frag2tofrag3);
        toFrag3btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(size.getText().toString().isEmpty()){
                    size.setText("0");
                }
                bundle.putDouble("size", Double.parseDouble(size.getText().toString()));
                bundle.putString("location", location.getText().toString());
                bundle.putAll(bundle);

                navController.navigate(R.id.action_fragment_createGS_2_to_fragment_createGS_3, bundle);
            }
        });


    }

}