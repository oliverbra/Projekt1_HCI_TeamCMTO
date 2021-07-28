package com.thkoeln.hct.backend.application.controller;

import com.thkoeln.hct.backend.application.service.CriteriaService;
import com.thkoeln.hct.backend.domain.model.Criteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CriteriaController {

    private static final Logger loggerCriteria = LoggerFactory.getLogger(CriteriaController.class);

    @Autowired
    private CriteriaService criteriaService;

    @GetMapping("/criteria")
    public ResponseEntity<List<Criteria>> getAllCriteria() {
        loggerCriteria.debug("GET: getAllCriteria");
        return new ResponseEntity(criteriaService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/criteria/{id}")
    public ResponseEntity<Criteria> getCriteriaById(@PathVariable Integer id) {
        loggerCriteria.debug("GET: getCriteriaById");
        return new ResponseEntity(criteriaService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/criteria")
    public ResponseEntity<Criteria> createCriteria(@RequestBody Criteria criteria) {
        loggerCriteria.debug("POST: createCriteria");
        return new ResponseEntity(criteriaService.create(criteria), HttpStatus.CREATED);
    }

   @PutMapping(value = "/criteria", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Criteria> updateCriteria(@RequestBody Criteria criteria) {
        loggerCriteria.debug("PUT: updateCriteria");
        return new ResponseEntity(criteriaService.update(criteria), HttpStatus.OK);
    }

    @DeleteMapping  ("/criteria/{id}")
    public ResponseEntity<Void> deleteCriteria(@PathVariable Integer id) {
        loggerCriteria.debug("DELETE: deleteCriteria");
        criteriaService.delete(id);
        return ResponseEntity.ok().build();
    }
}
