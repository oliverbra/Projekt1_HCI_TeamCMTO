package com.example.resrclient;

import android.widget.GridLayout;

public class Species {

    private String name;
    private String descriptionText;
    private String poisonousness;

    public Species(String pName, String pDescriptionText, String pPoisonousness){
        name = pName;
        descriptionText = pDescriptionText;
        poisonousness = pPoisonousness;
    }
}
