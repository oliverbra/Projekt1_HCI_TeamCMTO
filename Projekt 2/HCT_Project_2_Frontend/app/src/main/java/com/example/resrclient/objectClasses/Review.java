package com.example.resrclient.objectClasses;

import java.util.ArrayList;
import java.util.Date;

public class Review {

    private double rating;
    private Date date;
    private String comment;
    private User author;
    private GrowSpace gs;
    private ArrayList<ReviewCriteria> criteria;

    public Review(double pRating, Date pDate, String pComment, User pAuthor, GrowSpace pGs){
        rating = pRating;
        date = pDate;
        comment = pComment;
        // how to initialize author and gs automatically?
        author = pAuthor;
        gs = pGs;
        // criteria are initialized according to the level of the user; maybe multiple constructors?
    }

    //Getter
    public double getRating() {
        return rating;
    }

    public Date getDate() {
        return date;
    }

    public String getComment() {
        return comment;
    }

    public User getAuthor() {
        return author;
    }

    public GrowSpace getGs() {
        return gs;
    }

    //Setter
    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public void setGs(GrowSpace gs) {
        this.gs = gs;
    }

}
