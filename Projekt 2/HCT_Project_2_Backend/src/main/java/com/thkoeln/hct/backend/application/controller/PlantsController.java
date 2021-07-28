package com.thkoeln.hct.backend.application.controller;

import com.thkoeln.hct.backend.application.service.PlantsService;
import com.thkoeln.hct.backend.domain.model.Plants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
public class PlantsController {

    private static final Logger logger = LoggerFactory.getLogger(PlantsController.class);

    @Autowired
    private PlantsService plantsService;

    @GetMapping("/plants")
    public ResponseEntity<List<Plants>> getAllPlants() {
        logger.debug("GET: getAllPlants");
        return new ResponseEntity(plantsService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/plants/{id}")
    public ResponseEntity<Plants> getPlantsById(@PathVariable Integer id) {
        logger.debug("GET: getPlantsById");
        return new ResponseEntity(plantsService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/plants")
    public ResponseEntity<Plants> createPlant(@RequestBody Plants plants) {
        logger.debug("POST: createPlant");
        return new ResponseEntity(plantsService.create(plants), HttpStatus.CREATED);
    }

    @PutMapping("/plants")
    public ResponseEntity<Plants> updatePlant(@RequestBody Plants plants) {
        logger.debug("PUT: updatePlant");
        return new ResponseEntity(plantsService.update(plants), HttpStatus.OK);
    }

    @DeleteMapping  ("/plants/{id}")
    public ResponseEntity<Void> deletePlant(@PathVariable Integer id) {
        logger.debug("DELETE: deletePlant");
        plantsService.delete(id);
        return ResponseEntity.ok().build();
    }

}
