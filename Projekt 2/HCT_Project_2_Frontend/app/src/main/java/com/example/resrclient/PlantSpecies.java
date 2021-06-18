package com.example.resrclient;

import android.widget.GridLayout;

public class PlantSpecies {

    private String commonName;
    private String botanicalName;
    private String descriptionText;
    private String plantCategory;
    private String growthCharacteristics;
    private String blossomingTime;
    private String blossomColour;
    private String poisonousness;
    private boolean nectar;
    private boolean local;
    private String ornamentalValue;
    private String utilityValue;
    private String light;
    private String soil;
    private String soilMoisture;
    private String pHValue;
    private String nutrientRequirements;
    private String careText;
    private String url;

    public PlantSpecies(String pCommonName, String pBotanicalName, String pDescriptionText, String pPlantCategory, String pGrowthCharacteristics, String pBlossomingTime, String pBlossomColour, String pPoisonousness, boolean pNectar, boolean pLocal, String pOrnamentalValue, String pUtilityValue, String pLight, String pSoil, String pSoilMoisture, String pPHValue, String pNutrientRequirements, String pCareText, String pUrl) {
        pCommonName = commonName;
        pBotanicalName = botanicalName;
        pDescriptionText = descriptionText;
        pPlantCategory = plantCategory;
        pGrowthCharacteristics = growthCharacteristics;
        pBlossomingTime = blossomingTime;
        pBlossomColour = blossomColour;
        pPoisonousness = poisonousness;
        pNectar = nectar;
        pLocal = local;
        pOrnamentalValue = ornamentalValue;
        pUtilityValue = utilityValue;
        pLight = light;
        pSoil = soil;
        pSoilMoisture = soilMoisture;
        pPHValue = pHValue;
        pNutrientRequirements = nutrientRequirements;
        pCareText = careText;
        pUrl = url;
    }
}
