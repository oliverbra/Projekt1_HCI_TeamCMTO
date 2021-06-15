package com.example.resrclient;

import java.util.ArrayList;
import java.util.Date;

public class Review {

    private double rating;
    private Date date;
    //private Comment comment;
    private User author;
    //private double ArrayList<ReviewCriteria>;

    public Review(double pRating, Date pDate, User pAuthor){
        rating = pRating;
        date = pDate;
        author = pAuthor;
    }
}
