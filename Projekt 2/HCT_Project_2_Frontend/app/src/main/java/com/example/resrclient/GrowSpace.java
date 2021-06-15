package com.example.resrclient;

import android.media.Image;

import java.util.ArrayList;

public class GrowSpace {

    private User owner;
    private String name;
    private String goal;
    private String category; //as list?
    private double size;
    private String location;
    private ArrayList<String> problems;
    private double averageRating;
    private ArrayList<Image> picture;

    //private ArrayList<PlantSpecies> plants;

    //private ArrayList<Review> receivedReviews;
    //private ArrayList<Comment> comments;
    private ArrayList<User> adorers;

    //private ArrayList<Mark> marks;


    public GrowSpace(User pOwner, String pName, String pGoal, String pCategory, double pSize, String pLocation, double pAverageRating{
        owner = pOwner;
        name = pName;
        goal = pGoal;
        category = pCategory;
        size = pSize;
        location = pLocation;
        averageRating = pAverageRating; //must be calculated
    }

    public double calculateAverageRating(){
        //initializes attribute averageRating acording to the list receivedReviews
    }

    public void sendUpdateNotice(){
        //...
    }


}
