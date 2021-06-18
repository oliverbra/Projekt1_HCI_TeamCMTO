package com.thkoeln.hct.backend.application.controller;

import com.thkoeln.hct.backend.domain.model.Mensch;
import com.thkoeln.hct.backend.domain.repository.MenschRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MenschController {

    @Autowired
    MenschRepository menschRepository;

    @RequestMapping(method = RequestMethod.GET,
            path="mensch",
            produces = MediaType.APPLICATION_JSON_VALUE)
   // public Mensch getMensch(){
    //    return new Mensch();
   // }

  //  List<Mensch> menschList = new ArrayList<Mensch>();

    public List<Mensch> getMensch() {
        List<Mensch> menschList = menschRepository.findAll();
        return menschList;
    }
}
