package com.example.resrclient;

import android.media.Image;

public class Progress {

    private String levelName;
    private int level;
    private Image levelIcon;
    private int growpoints;
    private int levelRequirement;

    public Progress(String pLevelName, int pLevel, Image pLevelIcon, int pGrowPoints, int pLevelRequirement){
        levelName = pLevelName;
        level = pLevel;
        levelIcon = pLevelIcon;
        growpoints = pGrowPoints;
        levelRequirement = pLevelRequirement;
    }

    public void levelUp(){
        //level up when enough growpoints have been achieved according to the levelrequirement
    }

    public void increaseGS(int amount){
        //achieves an specific amount of GrowPoints
        //adds amount to attribute growpoints
    }

    //Getter
    public String getLevelName() {
        return levelName;
    }

    public int getLevel() {
        return level;
    }

    public Image getLevelIcon() {
        return levelIcon;
    }

    public int getGrowpoints() {
        return growpoints;
    }

    public int getLevelRequirement() {
        return levelRequirement;
    }

    //Setter
    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setLevelIcon(Image levelIcon) {
        this.levelIcon = levelIcon;
    }

    public void setGrowpoints(int growpoints) {
        this.growpoints = growpoints;
    }

    public void setLevelRequirement(int levelRequirement) {
        this.levelRequirement = levelRequirement;
    }

}
