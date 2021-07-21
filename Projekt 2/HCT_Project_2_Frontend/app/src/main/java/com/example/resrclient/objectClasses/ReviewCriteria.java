package com.example.resrclient.objectClasses;

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

    /*public boolean checkScope(){
        //checks User level to define criteria
    }*/

    //Getter
    public String getName() {
        return name;
    }

    public String getExplanation() {
        return explanation;
    }

    public int getRatingScale() {
        return ratingScale;
    }

    public String getScope() {
        return scope;
    }

    //Setter
    public void setName(String name) {
        this.name = name;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public void setRatingScale(int ratingScale) {
        this.ratingScale = ratingScale;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

}
