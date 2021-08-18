package com.example.resrclient.objectClasses;

import android.media.Image;

import java.util.ArrayList;

public class GrowSpace {

    private User owner;
    private String name;
    private String goal;
    private String category; //as list?
    private double size;
    private String location;
    //private ArrayList<String> problems;
    private String problems;
    private double averageRating;
   // private ArrayList<Image> picture;

    //private ArrayList<PlantSpecies> plants;

   // private ArrayList<Review> receivedReviews;
  //  private ArrayList<User> adorers;

 //   private ArrayList<Mark> marks;


   /* public GrowSpace(User pOwner, String pName, String pGoal, String pCategory, double pSize, String pLocation) {
        owner = pOwner;
        name = pName;
        goal = pGoal;
        category = pCategory;
        size = pSize;
        location = pLocation;

       // problems = new ArrayList<String>(); //how to add problems while creating the GrowSpace?

        receivedReviews = new ArrayList<Review>();
        adorers = new ArrayList<User>();

        marks = new ArrayList<Mark>();
    } */

    public GrowSpace(String pName, String pGoal, String pCategory, double pSize, String pLocation, String pProblems, Double pAverageRating) {
        name = pName;
        goal = pGoal;
        category = pCategory;
        size = pSize;
        location = pLocation;
        problems = pProblems;
        averageRating = pAverageRating;

        //receivedReviews = new ArrayList<Review>();
       // adorers = new ArrayList<User>();
        //marks = new ArrayList<Mark>();
    }

    /*public double calculateAverageRating(){
        //initializes attribute averageRating according to the list receivedReviews
    }*/

    /*public void sendUpdateNotice(){
        //...
    }*/

    public String toString() {
        return name + " " + goal + " " + category + " " + size + " " + location + " " + problems + ".";
    };

    //Getter
    public User getOwner() {
        return owner;
    }

    public String getName() {
        return name;
    }

    public String getGoal() {
        return goal;
    }

    public String getCategory() {
        return category;
    }

    public double getSize() {
        return size;
    }

    public String getLocation() {
        return location;
    }

    public String getProblems() {return problems;}

    public double getAverageRating() {return averageRating;}

    //Setter
    public void setOwner(User owner) {
        this.owner = owner;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
