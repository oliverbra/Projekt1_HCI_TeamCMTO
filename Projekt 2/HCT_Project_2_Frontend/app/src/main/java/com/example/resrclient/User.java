package com.example.resrclient;

import java.util.ArrayList;

public class User {

    private int id;
    private String name;
    private Progress progress;
    private GrowSpace[] ownGS;
    private ArrayList<GrowSpace> favouriteGS;
    private ArrayList<Review> sentReviews;


    public User(int pId, String pName){
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
    }

}
