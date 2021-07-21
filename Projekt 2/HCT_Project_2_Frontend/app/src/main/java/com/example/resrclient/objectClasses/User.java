package com.example.resrclient.objectClasses;

import java.util.ArrayList;

public class User {

    /*
    private int id;
    private String name;
    private Progress progress;
    private GrowSpace[] ownGS;
    private ArrayList<GrowSpace> favouriteGS;
    private ArrayList<Review> sentReviews; */

    private Integer userId;
    private String email;
    private String name;
    private String age;
    private String progress;
    private Integer level;
    private JPasswordField password;


    public User() {

    }

   /* public User(int pId, String pName){
        id = pId;
        name = pName;
        //progress = new Progress("Beginner", 1,...);
        ownGS = new GrowSpace[3];
        favouriteGS = new ArrayList<GrowSpace>();
        sentReviews = new ArrayList<Review>();
    }

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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public JPasswordField getPassword() {
        return password;
    }

    public void setPassword(JPasswordField password) {
        this.password = password;
    }
}
