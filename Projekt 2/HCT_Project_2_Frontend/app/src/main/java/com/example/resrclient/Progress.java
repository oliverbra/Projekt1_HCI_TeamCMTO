package com.example.resrclient;

public class Progress {

    private String levelName;
    private int level;
    //private Image levelIcon;
    private int growpoints;
    private int levelRequirement;

    public Progress(String pLevelName, int pLevel, int pGrowPoints, int pLevelRequirement){
        levelName = pLevelName;
        level = pLevel;
        growpoints = pGrowPoints;
        levelRequirement = pLevelRequirement;
    }

    public void levelUp(){
        //level up when enough growpoints have been achieved according to the levelrequirement
    }

    public void increaseGS(int amount){
        //achieve an specific amount of GrowPoints
        //add amount to attribute growpoints
    }

}
