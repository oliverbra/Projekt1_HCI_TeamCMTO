package com.thkoeln.hct.backend.application.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class GrowSpaceController {

    @JsonProperty("owner")
    private User owner;
    @JsonProperty("name")
    private String name;
    @JsonProperty("goal")
    private String goal;
    @JsonProperty("category")
    private String category; //as list?
    @JsonProperty("size")
    private double size;
    @JsonProperty("location")
    private String location;

    //JsonProperty bei Arrays??
    private ArrayList<String> problems;
    private double averageRating;
    private ArrayList<Image> picture;

    //private ArrayList<PlantSpecies> plants;

    private ArrayList<Review> receivedReviews;
    private ArrayList<User> adorers;

    private ArrayList<Mark> marks;


    public GrowSpaceController(User pOwner, String pName, String pGoal, String pCategory, double pSize, String pLocation) {
        owner = pOwner;
        name = pName;
        goal = pGoal;
        category = pCategory;
        size = pSize;
        location = pLocation;

        problems = new ArrayList<String>(); //how to add problems while creating the GrowSpace?

        receivedReviews = new ArrayList<Review>();
        adorers = new ArrayList<User>();

        marks = new ArrayList<Mark>();
    }

    /*public double calculateAverageRating(){
        //initializes attribute averageRating according to the list receivedReviews
    }*/

    /*public void sendUpdateNotice(){
        //...
    }*/

    //Getter
    @RequestMapping(method = RequestMethod.GET,
            path="getOwner",produces = MediaType.APPLICATION_JSON_VALUE)
    public User getOwner() {
        return owner;
    }

    @RequestMapping(method = RequestMethod.GET,
            path="getName",produces = MediaType.APPLICATION_JSON_VALUE)
    public String getName() {
        return name;
    }

    @RequestMapping(method = RequestMethod.GET,
            path="getGoal",produces = MediaType.APPLICATION_JSON_VALUE)
    public String getGoal() {
        return goal;
    }

    @RequestMapping(method = RequestMethod.GET,
            path="getCategory",produces = MediaType.APPLICATION_JSON_VALUE)
    public String getCategory() {
        return category;
    }

    @RequestMapping(method = RequestMethod.GET,
            path="getSize",produces = MediaType.APPLICATION_JSON_VALUE)
    public double getSize() {
        return size;
    }

    @RequestMapping(method = RequestMethod.GET,
            path="getLocation",produces = MediaType.APPLICATION_JSON_VALUE)
    public String getLocation() {
        return location;
    }

    //Setter
    @RequestMapping(method = RequestMethod.PUT,
            path="setOwner",produces = MediaType.APPLICATION_JSON_VALUE)
    public void setOwner(User owner) {
        this.owner = owner;
    }

    @RequestMapping(method = RequestMethod.PUT,
            path="setName",produces = MediaType.APPLICATION_JSON_VALUE)
    public void setName(String name) {
        this.name = name;
    }

    @RequestMapping(method = RequestMethod.PUT,
            path="setGoal",produces = MediaType.APPLICATION_JSON_VALUE)
    public void setGoal(String goal) {
        this.goal = goal;
    }

    @RequestMapping(method = RequestMethod.PUT,
            path="setCategory",produces = MediaType.APPLICATION_JSON_VALUE)
    public void setCategory(String category) {
        this.category = category;
    }

    @RequestMapping(method = RequestMethod.PUT,
            path="setSize",produces = MediaType.APPLICATION_JSON_VALUE)
    public void setSize(double size) {
        this.size = size;
    }

    @RequestMapping(method = RequestMethod.PUT,
            path="setLocation",produces = MediaType.APPLICATION_JSON_VALUE)
    public void setLocation(String location) {
        this.location = location;
    }

}
