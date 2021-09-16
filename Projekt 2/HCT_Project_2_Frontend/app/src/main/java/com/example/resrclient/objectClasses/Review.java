package com.example.resrclient.objectClasses;

public class Review {

    private Integer id;
    private double rating;
    private String date;
    private String comment;
    private double localCriteria;
    private double shelterCriteria;
    private double naturalCriteria;
    private double dangerCriteria;
    private User user;
    private GrowSpace growSpace;
    private boolean open;

    public Review(){
    }

    public Review(double pRating, String pDate, String pComment, User pAuthor, GrowSpace pGs){
        rating = pRating;
        date = pDate;
        comment = pComment;
        // how to initialize author and gs automatically?
        user = pAuthor;
        growSpace = pGs;
        open = false;
        // criteria are initialized according to the level of the user; maybe multiple constructors?
    }

    public Review(double localCriteria, double shelterCriteria, double naturalCriteria, double dangerCriteria, String date, String comment, User user, GrowSpace growSpace){
       this.localCriteria = localCriteria;
       this.shelterCriteria = shelterCriteria;
       this.naturalCriteria = naturalCriteria;
       this.dangerCriteria = dangerCriteria;
       this.date = date;
       this.comment =  comment;
       this.user = user;
       this.growSpace = growSpace;
       this.rating = (localCriteria + shelterCriteria + naturalCriteria + dangerCriteria) / 4;
    }

    public void open() {open = true;}


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    //Getter
    public double getRating() {
        return rating;
    }

    public GrowSpace getGrowSpace() {return growSpace;}

    public String getDate() {
        return date;
    }

    public String getComment() {
        return comment;
    }

    public User getUser() {
        return user;
    }

    public GrowSpace getGs() {
        return growSpace;
    }

    public boolean getOpen() {return open;}

    public double getNaturalCriteria() {
        return naturalCriteria;
    }

    public double getDangerCriteria() {
        return dangerCriteria;
    }

    //Setter
    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setGrowSpace(GrowSpace growSpace) {this.growSpace = growSpace;}

    public void setDate(String date) {
        this.date = date;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setGs(GrowSpace gs) {
        this.growSpace = gs;
    }

    public double getLocalCriteria() {
        return localCriteria;
    }

    public void setLocalCriteria(Integer localCriteria) {
        this.localCriteria = localCriteria;
    }

    public double getShelterCriteria() {
        return shelterCriteria;
    }

    public void setShelterCriteria(Integer shelterCriteria) {this.shelterCriteria = shelterCriteria;}

    public void setNaturalCriteria(Integer naturalCriteria) {this.naturalCriteria = naturalCriteria;}

    public void setDangerCriteria(Integer dangerCriteria) {
        this.dangerCriteria = dangerCriteria;
    }

}
