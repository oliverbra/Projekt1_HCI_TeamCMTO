package com.example.resrclient.objectClasses;

import java.util.List;
import java.util.Set;

public class User {

    private Integer id;
    private String email;
    private String userName;
    private String progress;
    private int growpoints;
    private Level level;
    private String password;
    private Set<GrowSpace> growSpace;
    private List<Review> reviews;
    private List<GrowSpace> bookmarkedGrowspaces;


    public User() {
    }

    // Dieser constructor existiert für LoginTask
    public User(String email, String password){
      //
        this.email  = email ;
        this.password = password;
    }
    //Dieser Constructor existiert für RegiesterTask
    public User (String userName, String email, String password){
        this.userName = userName;
        this.email = email;
        this.password = password;
    }
/*
    //adds GD to ownGS
    //public GrowSpace createGS(){}

    //deletes GS from ownGS
    //public void deleteGS(){}

    //edits a GS in ownGS
    //public void editGS(){}

    //favors a GS
    //add User in GrowSpace.adorers
    //public void favorGS(){}

    //reviews a GS
    //Composition: new Review...
    //public Review reviewGS(){}

    //Getter
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Progress getProgress() {
        return progress;
    }

    //Setter
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProgress(Progress progress) {
        this.progress = progress;
    } */

    public int getGrowpoints() {
        return growpoints;
    }

    public void setGrowpoints(int growpoints) {
        this.growpoints = growpoints;
    }

    public Set<GrowSpace> getGrowSpace() {
        return growSpace;
    }

    public void setGrowSpace(Set<GrowSpace> growSpace) {
        this.growSpace = growSpace;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
