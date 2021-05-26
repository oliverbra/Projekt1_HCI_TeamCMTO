package com.thkoeln.hct.backend.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {

    String name;
    int alter;
    boolean verheiratet;
    String beruf;

    public Person(){
        setName("Ali");
        setBeruf("Arbeitslos");
        setAlter(29);
        setVerheiratet(false);
    }


}
