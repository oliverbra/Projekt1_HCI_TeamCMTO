package com.example.resrclient.objectClasses;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GrowSpace {

    private Integer id;
    private User user;
    private String name;
    private String goal;
    private String category;
    private double size;
    private String location;
    private String problems;
    private double averageRating;
    private boolean highlighted;
    private ArrayList<Plants> plants;
    private List<Review> reviews;
    private File file;

    public GrowSpace(User user, String name, String goal, String category, double size, String location, String problems, double averageRating, boolean highlighted, ArrayList<Plants> plants, List<Review> reviews) {
        this.user = user;
        this.name = name;
        this.goal = goal;
        this.category = category;
        this.size = size;
        this.location = location;
        this.problems = problems;
        this.averageRating = averageRating;
        this.highlighted = highlighted;
        this.plants = plants;
        this.reviews = reviews;
    }
    public GrowSpace() {
    }


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
    public User getUser() {
        return user;
    }

    public List<Review> getReviews() {return reviews;}

    public ArrayList<Plants> getPlants() {return plants;}

    public Integer getId() {return id;}

    public String getName() {
        return name;
    }

    public String getGoal() {
        return goal;
    }

    public File getFile() {
        return file;
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

    public void setPlants(ArrayList<Plants> plants) {this.plants = plants;}

    public void setReviews(List<Review> reviews) {this.reviews = reviews;}

    public void setId(Integer id) {this.id = id;}

    public void setUser(User user) {
        this.user = user;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFile(File file){
        this.file = file;
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

    public boolean isHighlighted() {return highlighted;}

    public void setHighlighted(boolean highlighted) {this.highlighted = highlighted;}


}
