package com.example.resrclient.objectClasses;

import java.util.ArrayList;
import java.util.Date;

public class Comment {

    private String content;
    private Date date;
    private ArrayList<Mark> marks;

    public Comment(String pContent, Date pDate){
        content = pContent;
        date = pDate;

        marks = new ArrayList<Mark>();
    }

    //Getter
    public String getContent() {
        return content;
    }

    public Date getDate() {
        return date;
    }

    //Setter
    public void setContent(String content) {
        this.content = content;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
