package com.example.resrclient.objectClasses;

import android.media.Image;

import com.example.resrclient.restClasses.RestTaskLevel;

import java.util.concurrent.ExecutionException;

public class Level {

    private int id;
    private int level;
    private String levelName;
    //private Image levelIcon;
    private int levelThreshold;
    private User user;

    public Level(String pLevelName, int pLevel, Image pLevelIcon, int pLevelRequirement){
        levelName = pLevelName;
        level = pLevel;
        //levelIcon = pLevelIcon;
        levelThreshold = pLevelRequirement;
    }

    // Initialize with Level 1
    public Level () {
        this.id = 1;
        this.level = 1;
        this.levelName = "Level 1";
        this.levelThreshold = 20;

    }

    public Level(int pLevel){
        level = pLevel;
    }

    //Getter
    public String getLevelName() {
        return levelName;
    }

    public int getLevel() {
        return level;
    }

    /*public Image getLevelIcon() {
        return levelIcon;
    }*/

    public int getLevelThreshold() {
        return levelThreshold;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    //Setter
    public void setUser(User user) {
        this.user = user;
    }

    public void setId(int id) {
        this.id = id;
    }


    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    /*public void setLevelIcon(Image levelIcon) {
        this.levelIcon = levelIcon;
    }*/

    public void setLevelThreshold(int levelThreshold) {
        this.levelThreshold = levelThreshold;
    }

    public int getNextId() {
        return id++;
    }

}
