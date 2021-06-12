package com.example.resrclient;

import java.util.ArrayList;

public class User {

    private String id;
    private String name;
    private Progress progress;
    private ArrayList<GrowSpace> ownGS;
    private ArrayList<GrowSpace> favouriteGS;
    private ArrayList<Review> sentReviews;


    public User(String pId, String pName){
            id = pId;
            name = pName;
            //progress = new Progress("Beginner", 1,...);
    }

    //adds GD to ownGS
    //public GrowSpace createGS(){}

    //deletes GS from ownGS
    //public void deleteGS(){}

    //edits a GS in ownGS
    //public void editGS(){}

    //favors a GS
    //public void favorGS(){}

    //reviews a GS
    //public Review reviewGS(){}

    //generate getter and setter automatically?
}
