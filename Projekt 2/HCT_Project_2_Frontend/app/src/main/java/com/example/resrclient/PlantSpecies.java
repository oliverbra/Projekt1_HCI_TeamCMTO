package com.example.resrclient;

import java.util.ArrayList;

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

    private ArrayList<Mark> marks;

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

        marks = new ArrayList<Mark>();
    }

    //Getter
    public String getCommonName() {
        return commonName;
    }

    public String getBotanicalName() {
        return botanicalName;
    }

    public String getDescriptionText() {
        return descriptionText;
    }

    public String getPlantCategory() {
        return plantCategory;
    }

    public String getGrowthCharacteristics() {
        return growthCharacteristics;
    }

    public String getBlossomingTime() {
        return blossomingTime;
    }

    public String getBlossomColour() {
        return blossomColour;
    }

    public String getPoisonousness() {
        return poisonousness;
    }

    public boolean isNectar() {
        return nectar;
    }

    public boolean isLocal() {
        return local;
    }

    public String getOrnamentalValue() {
        return ornamentalValue;
    }

    public String getUtilityValue() {
        return utilityValue;
    }

    public String getLight() {
        return light;
    }

    public String getSoil() {
        return soil;
    }

    public String getSoilMoisture() {
        return soilMoisture;
    }

    public String getpHValue() {
        return pHValue;
    }

    public String getNutrientRequirements() {
        return nutrientRequirements;
    }

    public String getCareText() {
        return careText;
    }

    public String getUrl() {
        return url;
    }

    //Setter
    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public void setBotanicalName(String botanicalName) {
        this.botanicalName = botanicalName;
    }

    public void setDescriptionText(String descriptionText) {
        this.descriptionText = descriptionText;
    }

    public void setPlantCategory(String plantCategory) {
        this.plantCategory = plantCategory;
    }

    public void setGrowthCharacteristics(String growthCharacteristics) {
        this.growthCharacteristics = growthCharacteristics;
    }

    public void setBlossomingTime(String blossomingTime) {
        this.blossomingTime = blossomingTime;
    }

    public void setBlossomColour(String blossomColour) {
        this.blossomColour = blossomColour;
    }

    public void setPoisonousness(String poisonousness) {
        this.poisonousness = poisonousness;
    }

    public void setNectar(boolean nectar) {
        this.nectar = nectar;
    }

    public void setLocal(boolean local) {
        this.local = local;
    }

    public void setOrnamentalValue(String ornamentalValue) {
        this.ornamentalValue = ornamentalValue;
    }

    public void setUtilityValue(String utilityValue) {
        this.utilityValue = utilityValue;
    }

    public void setLight(String light) {
        this.light = light;
    }

    public void setSoil(String soil) {
        this.soil = soil;
    }

    public void setSoilMoisture(String soilMoisture) {
        this.soilMoisture = soilMoisture;
    }

    public void setpHValue(String pHValue) {
        this.pHValue = pHValue;
    }

    public void setNutrientRequirements(String nutrientRequirements) {
        this.nutrientRequirements = nutrientRequirements;
    }

    public void setCareText(String careText) {
        this.careText = careText;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
