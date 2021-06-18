package com.example.resrclient;

import java.lang.reflect.Array;
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
        favouriteGS = new ArrayList<>();
        sentReviews = new ArrayList<>();
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

    //generate getter and setter automatically?

}
