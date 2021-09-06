package com.example.resrclient.objectClasses;

import android.content.Context;
import android.widget.Toast;

import com.example.resrclient.asyncTasks.UpdateUserGP;
import com.example.resrclient.restClasses.RestTaskUser;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;

public class User {

    private Integer id;
    private String email;
    private String userName;
    private String progress;
    private int growpoints;
    private Level level;
    private String password;
    private Set<GrowSpace> growSpace;
    private List<Review> reviews;
    private List<GrowSpace> bookmarkedGrowspaces;


    public User() {
    }

    // Dieser constructor existiert für LoginTask
    public User(String email, String password){
      //
        this.email  = email ;
        this.password = password;
    }
    //Dieser Constructor existiert für RegiesterTask
    public User(String userName, String email, String password){
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public void increaseGP(int amount) throws ExecutionException, InterruptedException {
        growpoints += amount;

        // Update user
        String url = "http://10.0.2.2:8080/users";
        new UpdateUserGP().execute(url, gpToString(this.getGrowpoints())).get();
        //Get newUser
        url = "http://10.0.2.2:8080/users/" + this.getId();
        User updatedUser = new RestTaskUser().execute(url).get();
        if(updatedUser.getLevel() != this.getLevel()) {
            this.level = updatedUser.getLevel();
            this.growpoints = updatedUser.getGrowpoints();
        }
    }

    public void openReview(int i) throws ExecutionException, InterruptedException {
        if(!reviews.get(i).getOpen()) {
            reviews.get(i).open();
            increaseGP(calculatePoints(reviews.get(i).getRating()));
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

    public Set<GrowSpace> getGrowSpace() {
        return growSpace;
    }

    public void setGrowSpace(Set<GrowSpace> growSpace) {
        this.growSpace = growSpace;
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

    public String gpToString(int growpoints) {
        return "" + growpoints;
    }
}
