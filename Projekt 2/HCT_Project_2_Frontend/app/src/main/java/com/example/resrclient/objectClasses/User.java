package com.example.resrclient.objectClasses;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.resrclient.asyncTasks.UpdateUserGP;
import com.example.resrclient.restClasses.RestTaskLevel;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.File;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class User {

    private Integer id;
    private String email;
    private String userName;
    private String progress;
    private int growpoints;
    private Level level;
    private String password;
    private GrowSpace growSpace;
    private List<Review> reviews;
    private List<GrowSpace> bookmarkedGrowspaces;



    private File file;


    public User() {
    }

    public User (Integer id){
        this.id = id;
    }

    // Dieser constructor existiert für LoginTask
    public User(String email, String password){
      //
        this.email  = email ;
        this.password = password;
    }
    //Dieser Constructor existiert für RegiesterTask
    public User(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.growpoints = 0;
        this.level = new Level();

    }

    public void increaseGP(int amount, Context ctx) throws ExecutionException, InterruptedException {
        growpoints += amount;
        if(this.getGrowpoints() >= this.getLevel().getLevelThreshold()) {
            this.setGrowpoints(this.getGrowpoints() - this.getLevel().getLevelThreshold());
            String url = "http://10.0.2.2:8080/levels/";
            int nextLevelId = this.getLevel().getId() + 1;
            Level nextLevel = new RestTaskLevel().execute(url + nextLevelId).get();
            this.setLevel(nextLevel);
            levelUp(ctx);
            Log.v("Result", "Done 1: " + this.getLevel().getLevelName() + " " + this.getGrowpoints());
        }
        // Update user
        String url = "http://10.0.2.2:8080/users";
        User updatedUser =  new UpdateUserGP(ctx).execute(url, intToString(this.getGrowpoints()), intToString(this.getLevel().getId())).get();
        Log.v("Result", "Done 3: " + updatedUser.getLevel().getLevelName() + " " + updatedUser.getGrowpoints());

    }

    public void openReview(int i, Context ctx) throws ExecutionException, InterruptedException {
        if(!reviews.get(i).getOpen()) {
            reviews.get(i).open();
            increaseGP(calculatePoints(reviews.get(i).getRating()), ctx);
        }
    }

    public int calculatePoints(double rating) {
        int points;
        if(rating == 5) {
        points = (int) rating * 15;}
        else if (rating < 5 & rating >= 2) {
            points = (int) rating * 10; }
        else { points = 0;}
        return points;
    }

    public void levelUp(Context ctx) {
        // Play a level up animation or so
        // Maybe just show a message / toast
        Toast.makeText(ctx, "Yaay! Level Up! :)", Toast.LENGTH_SHORT).show();
    }
/*
    //adds GD to ownGS
    //public GrowSpace createGS(){}

    //deletes GS from ownGS
    //public void deleteGS(){}

    //edits a GS in ownGS
    //public void editGS(){}

    //favors a GS
    //add User in GrowSpace.adorers
    //public void favorGS(){}

    //reviews a GS
    //Composition: new Review...
    //public Review reviewGS(){}

    //Getter
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Progress getProgress() {
        return progress;
    }

    //Setter
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProgress(Progress progress) {
        this.progress = progress;
    } */

    public int getGrowpoints() {
        return growpoints;
    }

    public void setGrowpoints(int growpoints) {
        this.growpoints = growpoints;
    }

    public GrowSpace getGrowSpace() {
        return growSpace;
    }

    public void setGrowSpace(GrowSpace growSpace) {
        this.growSpace = growSpace;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String intToString(int i) {
        return "" + i;
    }

    public List<Review> getReviews() {return reviews; }

    public void setReviews(List<Review> reviews) {this.reviews = reviews;}

    public List<GrowSpace> getBookmarkedGrowspaces() {return bookmarkedGrowspaces;}

    public void setBookmarkedGrowspaces(List<GrowSpace> bookmarkedGrowspaces) {this.bookmarkedGrowspaces = bookmarkedGrowspaces;}

}
