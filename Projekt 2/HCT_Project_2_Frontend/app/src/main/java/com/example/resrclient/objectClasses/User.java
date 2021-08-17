package com.example.resrclient.objectClasses;

import java.util.Set;

public class User {

    private Integer id;
    private String email;
    private String name;
    private String age;
    private String progress;
    private int growpoints;
    private Integer level;
    private String password;
    private Set<GrowSpace> growSpace;


    public User() {
    }

    // Dieser constructor existiert für LoginTask
    public User(String email, String password){
      //
        this.email  = email ;
        this.password = password;
    }
    //Dieser Constructor existiert für RegiesterTask
    public User (String name,String email,String password,String age){
        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
