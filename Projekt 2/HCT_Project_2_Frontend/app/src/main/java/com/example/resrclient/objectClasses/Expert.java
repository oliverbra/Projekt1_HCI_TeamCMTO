package com.example.resrclient.objectClasses;

import java.util.ArrayList;

public class Expert extends User{

    private ArrayList<User> user;

    public Expert(int pId, String pName, Level pLevel){
        //super(pId, pName);
        //expertMark = pExpertMark;
    }
    
    public ArrayList<User> getUser() {
        return user;
    }

    public void setUser(ArrayList<User> user) {
        this.user = user;
    }



}
