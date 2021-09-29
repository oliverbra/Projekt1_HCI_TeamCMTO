package com.example.resrclient.activities.plantView;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.resrclient.R;

public class PlantViewHolder {

    ImageView file;
    TextView plantName;
    Button button;

    public PlantViewHolder(View v) {
        this.file = v.findViewById(R.id.singlePlant_ImageView);
        this.plantName = v.findViewById(R.id.singlePlant_TextView_Name);
        this.button = v.findViewById(R.id.singlePlant_Button_Add);
    }

}
