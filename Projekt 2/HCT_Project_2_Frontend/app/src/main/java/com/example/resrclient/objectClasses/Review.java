package com.example.resrclient.objectClasses;

import java.util.Date;

public class Review {

    private Integer id;
    private double rating;
    private Date date;
    private String comment;
    private Integer localCriteria;
    private Integer shelterCriteria;
    private Integer naturalCriteria;
    private Integer dangerCriteria;
    private User user;
    private GrowSpace gs;
    private boolean open;

    public Review(double pRating, Date pDate, String pComment, User pAuthor, GrowSpace pGs){
        rating = pRating;
        date = pDate;
        comment = pComment;
        // how to initialize author and gs automatically?
        user = pAuthor;
        gs = pGs;
        open = false;
        // criteria are initialized according to the level of the user; maybe multiple constructors?
    }

    public void open() {open = true;}

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

    public User getUser() {
        return user;
    }

    public GrowSpace getGs() {
        return gs;
    }

    public boolean getOpen() {return open;}

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

    public void setUser(User user) {
        this.user = user;
    }

    public void setGs(GrowSpace gs) {
        this.gs = gs;
    }

    public Integer getLocalCriteria() {
        return localCriteria;
    }

    public void setLocalCriteria(Integer localCriteria) {
        this.localCriteria = localCriteria;
    }

    public Integer getShelterCriteria() {
        return shelterCriteria;
    }

    public void setShelterCriteria(Integer shelterCriteria) {
        this.shelterCriteria = shelterCriteria;
    }

    public Integer getNaturalCriteria() {
        return naturalCriteria;
    }

    public void setNaturalCriteria(Integer naturalCriteria) {
        this.naturalCriteria = naturalCriteria;
    }

    public Integer getDangerCriteria() {
        return dangerCriteria;
    }

    public void setDangerCriteria(Integer dangerCriteria) {
        this.dangerCriteria = dangerCriteria;
    }

}
