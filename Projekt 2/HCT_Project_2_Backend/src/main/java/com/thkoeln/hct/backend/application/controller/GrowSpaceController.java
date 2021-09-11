package com.thkoeln.hct.backend.application.controller;

import com.thkoeln.hct.backend.application.service.GrowSpaceService;
import com.thkoeln.hct.backend.domain.model.GrowSpace;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@RestController
public class GrowSpaceController {

    private static final Logger logger = LoggerFactory.getLogger(GrowSpaceController.class);

    @Autowired
    private GrowSpaceService growSpaceService;

    @GetMapping("/growspaces")
    public ResponseEntity<List<GrowSpace>> getAllGrowSpaces(){
        logger.debug("GET : getALLGrowSpaces");
        return new ResponseEntity<>(growSpaceService.findAll(),HttpStatus.OK);
    }

    @GetMapping("/growspaces/{id}")
    public ResponseEntity<GrowSpace> getGrowSpacesByid(@PathVariable Integer id){
        logger.debug("GET : getGrowSpacesbyId");
        return new ResponseEntity(growSpaceService.findByid(id),HttpStatus.OK);
    }

    @GetMapping("/growspaces/random")
    public ResponseEntity<GrowSpace> getRandomGrowspace() {
        logger.debug("GET: getRandomGrowSpace");
        return new ResponseEntity(growSpaceService.findRandom(), HttpStatus.OK);
    }

    @PostMapping("/growspaces")
    public ResponseEntity<GrowSpace> createGrowSpace(@RequestBody GrowSpace growSpace) {
        logger.debug("POST: createGrowSpace");
        return new ResponseEntity(growSpaceService.create(growSpace), HttpStatus.CREATED);
    }

   @PutMapping(value = "/growspaces", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GrowSpace> updateGrowSpace(@RequestBody GrowSpace growSpace) {
        logger.debug("PUT: updateGrowSpaces");
        return new ResponseEntity(growSpaceService.update(growSpace), HttpStatus.OK);
    }
    @DeleteMapping  ("/growspaces/{id}")
    public ResponseEntity<Void> deleteGrowSpace(@PathVariable Integer id) {
        logger.debug("DELETE: deleteGrowSpace");
        growSpaceService.delete(id);
        return ResponseEntity.ok().build();
    }
}
