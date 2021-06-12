package com.example.resrclient;

import android.media.Image;

public class Mark {

    private String name;
    private Image icon;
    private String scope;

    public Mark(String pName, Image pIcon, String pScope){
        name = pName;
        icon = pIcon;
        scope = pScope;
    }

    public checkScope(){
        //checks what kind of object should be marked to assign the correct mark
    }
}
