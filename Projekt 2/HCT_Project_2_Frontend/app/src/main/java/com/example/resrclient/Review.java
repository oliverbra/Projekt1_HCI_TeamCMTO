package com.example.resrclient;

import java.util.ArrayList;
import java.util.Date;

public class Review {

    private double rating;
    private Date date;
    private Comment comment;
    private User author;
    private GrowSpace gs;
    private ArrayList<ReviewCriteria> criteria;

    public Review(double pRating, Date pDate, String pCommentContent, User pAuthor, GrowSpace pGs){
        rating = pRating;
        date = pDate;
        comment = new Comment(pCommentContent,pDate);
        // how to initialize author and gs automatically?
        author = pAuthor;
        gs = pGs;
       // criteria are initialized according to the level of the user; maybe multiple constructors?
    }
}