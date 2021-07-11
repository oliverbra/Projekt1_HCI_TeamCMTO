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

    public void checkScope(){
        //checks what kind of object should be marked to assign the correct mark
    }

    //Getter
    public String getName() {
        return name;
    }

    public Image getIcon() {
        return icon;
    }

    public String getScope() {
        return scope;
    }

    //Setter
    public void setName(String name) {
        this.name = name;
    }

    public void setIcon(Image icon) {
        this.icon = icon;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

}
