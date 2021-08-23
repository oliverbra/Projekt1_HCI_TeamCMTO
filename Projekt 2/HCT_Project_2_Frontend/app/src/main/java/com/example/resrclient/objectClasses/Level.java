package com.example.resrclient.objectClasses;

import android.media.Image;

public class Level {

    private String levelName;
    private int level;
    private Image levelIcon;
    private int levelThreshold;

    public Level(String pLevelName, int pLevel, Image pLevelIcon, int pLevelRequirement){
        levelName = pLevelName;
        level = pLevel;
        levelIcon = pLevelIcon;
        levelThreshold = pLevelRequirement;
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

    public int getLevelThreshold() {
        return levelThreshold;
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

    public void setLevelThreshold(int levelThreshold) {
        this.levelThreshold = levelThreshold;
    }

}
