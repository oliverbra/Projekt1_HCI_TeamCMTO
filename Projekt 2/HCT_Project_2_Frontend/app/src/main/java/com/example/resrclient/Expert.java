package com.example.resrclient;

import java.util.ArrayList;

public class Expert extends User{

    private Mark expertMark;
    private ArrayList<GrowSpace> recommendGS;
    private ArrayList<Comment> sentComments;

    public Expert(String pId, String pName, Progress pProgress, Mark pExpertMark){
        super(pId, pName, pProgress);
        expertMark = pExpertMark;
    }

    public void recommendGS(GrowSpace gs){
        //recommended gs gets marked
    }
}
