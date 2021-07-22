package com.example.resrclient.objectClasses;

import java.util.ArrayList;

public class Expert extends User{

    private Mark expertMark;
    private ArrayList<GrowSpace> recommendGS;

    public Expert(int pId, String pName, Progress pProgress, Mark pExpertMark){
        //super(pId, pName);
        //expertMark = pExpertMark;
    }

    public void recommendGS(GrowSpace gs){
        //recommended gs gets marked
    }

    //Getter

    //Setter

}
