package com.thkoeln.hct.backend.application.controller;

import com.thkoeln.hct.backend.domain.model.Person;
import com.thkoeln.hct.backend.domain.model.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HalloWorldController {

    @RequestMapping(method = RequestMethod.GET,
    path="sayHallo",produces = MediaType.APPLICATION_JSON_VALUE)
    public String sayHallo(){
        return "Hallo Ali";
    }

    @RequestMapping(method = RequestMethod.GET,
            path="person")
    public String person(){
        return "Mensch";
    }

    @RequestMapping(method = RequestMethod.GET,
            path="personAli",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Person getPersonAli(){
        return new Person();
    }

    @RequestMapping(method = RequestMethod.GET,
            path="userTest",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUser(){
        return new User();
    }


}
