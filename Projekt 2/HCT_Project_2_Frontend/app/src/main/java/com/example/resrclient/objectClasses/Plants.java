package com.example.resrclient.objectClasses;

import java.io.File;
import java.util.List;

public class Plants {

    private Integer id;
    private String commonName;
    private String botanicalName;
    private String descriptionText;
    private String plantCategory;
    private String growthCharacteristics;
    private String blossomingTime;
    private String blossomColour;
    private String poisonous;
    private String nectarPollen;
    private String nativty;
    private String ornamentalValue;
    private String utilityValue;
    private String light;
    private String soil;
    private String soilMoisture;
    private String phValue;
    private String nutrientRequirements;
    private String careText;
    private String url;
    private GrowSpace growSpace;
    private File file;


    public Plants() {
    }

    public Plants(String pCommonName, String pBotanicalName, String pDescriptionText, String pPlantCategory, String pGrowthCharacteristics, String pBlossomingTime, String pBlossomColour, String pPoisonousness, String pNectar, String pLocal, String pOrnamentalValue, String pUtilityValue, String pLight, String pSoil, String pSoilMoisture, String pPHValue, String pNutrientRequirements, String pCareText, String pUrl) {
        pCommonName = commonName;
        pBotanicalName = botanicalName;
        pDescriptionText = descriptionText;
        pPlantCategory = plantCategory;
        pGrowthCharacteristics = growthCharacteristics;
        pBlossomingTime = blossomingTime;
        pBlossomColour = blossomColour;
        pPoisonousness = poisonous;
        pNectar = nectarPollen;
        pLocal = nativty;
        pOrnamentalValue = ornamentalValue;
        pUtilityValue = utilityValue;
        pLight = light;
        pSoil = soil;
        pSoilMoisture = soilMoisture;
        pPHValue = phValue;
        pNutrientRequirements = nutrientRequirements;
        pCareText = careText;
        pUrl = url;
    }

    public Plants(Integer plantId) {
        this.id = plantId;
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

    public String getPoisonous() {
        return poisonous;
    }

    public String getNectarPollen() {
        return nectarPollen;
    }

    public String getNativty() {
        return nativty;
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

    public String getphValue() {
        return phValue;
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

    public void setPoisonous(String poisonous) {
        this.poisonous = poisonous;
    }

    public void setNectarPollen(String nectarPollen) {
        this.nectarPollen = nectarPollen;
    }

    public void setNativty(String nativty) {
        this.nativty = nativty;
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

    public void setphValue(String pHValue) {
        this.phValue = pHValue;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer plantId) {
        this.id = plantId;
    }

    public GrowSpace getGrowSpace() {
        return growSpace;
    }

    public void setGrowSpace(GrowSpace growSpace) {
        this.growSpace = growSpace;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
