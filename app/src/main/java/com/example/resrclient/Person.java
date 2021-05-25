package com.example.resrclient;

import com.fasterxml.jackson.annotation.JsonProperty;

import  java.util.Date;
//import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {

   // @JsonProperty("ID")
   // private long ID;
   // @JsonProperty("FirstName")
   // private String FirstName;
   // @JsonProperty("LastName")
   // private String LastName;
   // @JsonProperty("payRate")
   // private double payRate;
   // @JsonProperty("StartDate")
   // private Date StartDate;
   // @JsonProperty("EndDate")
    // private Date EndDate;

    //
//    @JsonProperty("Mensch")
//    private String Mensch;

    @JsonProperty("name")
    private String name;
    @JsonProperty("alter")
    private int alter;
    @JsonProperty("verheiratet")
    private boolean verheiratet;
    @JsonProperty("beruf")
    private String beruf;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAlter() {
        return alter;
    }

    public void setAlter(int alter) {
        this.alter = alter;
    }

    public boolean isVerheiratet() {
        return verheiratet;
    }

    public void setVerheiratet(boolean verheiratet) {
        this.verheiratet = verheiratet;
    }

    public String getBeruf() {
        return beruf;
    }

    public void setBeruf(String beruf) {
        this.beruf = beruf;
    }
}
