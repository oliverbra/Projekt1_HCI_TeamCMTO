package com.example.resrclient;

public class User {

    private String id;
    private String name;
    private Progress progress;
    //private ArrayList<GrowSpace> ownGS;
    //private ArrayList<GrowSpace> favouriteGS;
    //private ArrayList<Review> sentReviews;


    public User(String pId, String pName, Progress pProgress){
            id = pId;
            name = pName;
            progress = pProgress; //how to implement a composition?
    }

    //add GD to ownGS
    //public GrowSpace createGS(){}

    //delete GS from ownGS
    //public void deleteGS(){}

    //edit a GS in ownGS
    //public void editGS(){}

    //favor a GS
    //public void favorGS(){}

    //review a GS
    //public Review reviewGS(){}

    //generate getter and setter automatically?
}
