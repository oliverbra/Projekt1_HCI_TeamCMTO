package com.example.resrclient;

import java.util.ArrayList;
import java.util.Date;

public class Comment {

    private String content;
    private Date date;
    //private ArrayList<Mark> marks;

    public Comment(String pContent, Date pDate){
        content = pContent;
        date = pDate;
    }
}
