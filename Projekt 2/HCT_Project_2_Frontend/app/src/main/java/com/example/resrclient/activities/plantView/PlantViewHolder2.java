package com.example.resrclient.activities.plantView;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.resrclient.R;

public class PlantViewHolder2 {

    ImageView file;
    TextView plantName;

    public PlantViewHolder2(View v) {
        this.file = v.findViewById(R.id.singlePlant_ImageView2);
        this.plantName = v.findViewById(R.id.singlePlant_TextView_Name2);
    }

}
