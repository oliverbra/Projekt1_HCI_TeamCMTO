package com.example.resrclient;

public class ReviewCriteria {

    private String name;
    private String explanation;
    private int ratingScale;
    private String scope;

    public ReviewCriteria(String pName, String pExplanation, int pRatingScale, String pScope){
        name = pName;
        explanation = pExplanation;
        ratingScale = pRatingScale;
        scope = pScope;
    }

    public boolean checkScope(){
        //checks User level to define criteria
    }

}
