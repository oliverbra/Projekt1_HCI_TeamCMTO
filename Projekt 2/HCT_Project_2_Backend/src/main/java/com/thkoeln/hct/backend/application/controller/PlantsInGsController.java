package com.thkoeln.hct.backend.application.controller;

import com.thkoeln.hct.backend.application.service.PlantsInGsService;
import com.thkoeln.hct.backend.domain.model.PlantsInGs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class PlantsInGsController {
    private static final Logger logger = LoggerFactory.getLogger(PlantsInGsController.class);

    @Autowired
    private PlantsInGsService plantsInGsService;

    @GetMapping("/plantsInGs")
    public ResponseEntity<List<PlantsInGs>> getAllPlantsInGs() {
        logger.debug("GET: getAllPlantsInGs");
        return new ResponseEntity(plantsInGsService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/plantsInGs/{id}")
    public ResponseEntity<PlantsInGs> getPlantsInGsById(@PathVariable Integer id) {
        logger.debug("GET: getPlantsInGsById");
        return new ResponseEntity(plantsInGsService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/plantsInGs")
    public ResponseEntity<PlantsInGs> createPlantsInGs(@RequestBody PlantsInGs plantsInGs) {
        logger.debug("POST: createPPlantsInGs");
        return new ResponseEntity(plantsInGsService.create(plantsInGs), HttpStatus.CREATED);
    }

    @PutMapping(value = "/plantsInGs", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PlantsInGs> updatePlantsInGs(@RequestBody PlantsInGs plantsInGs) {
        logger.debug("PUT: updatePlantsInGs");
        return new ResponseEntity(plantsInGsService.update(plantsInGs), HttpStatus.OK);
    }

    @DeleteMapping  ("/plantsInGs/{id}")
    public ResponseEntity<Void> deletePlantsInGs(@PathVariable Integer id) {
        logger.debug("DELETE: deletePlantsInGs");
        plantsInGsService.delete(id);
        return ResponseEntity.ok().build();
    }
}
