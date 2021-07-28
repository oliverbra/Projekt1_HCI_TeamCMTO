package com.thkoeln.hct.backend.application.controller;

import com.thkoeln.hct.backend.application.service.ReviewCriteriaService;
import com.thkoeln.hct.backend.domain.model.ReviewCriteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewCriteriaController {

    private static final Logger logger = LoggerFactory.getLogger(ReviewCriteriaController.class);

    @Autowired
    private ReviewCriteriaService reviewCriteriaService;

    @GetMapping("/reviewCriteria")
    public ResponseEntity<List<ReviewCriteria>> getAllReviewCriteria() {
        logger.debug("GET: getAllReviewCriteria");
        return new ResponseEntity(reviewCriteriaService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/reviewCriteria/{id}")
    public ResponseEntity<ReviewCriteria> getReviewCriteriaById(@PathVariable Integer id) {
        logger.debug("GET: getReviewCriteriaById");
        return new ResponseEntity(reviewCriteriaService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/reviewCriteria")
    public ResponseEntity<ReviewCriteria> createReviewCriteria(@RequestBody ReviewCriteria reviewCriteria) {
        logger.debug("POST: createReviewCriteria");
        return new ResponseEntity(reviewCriteriaService.create(reviewCriteria), HttpStatus.CREATED);
    }

    @PutMapping(value = "/reviewCriteria", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ReviewCriteria> updateReviewCriteria(@RequestBody ReviewCriteria reviewCriteria) {
        logger.debug("PUT: updateReviewCriteria");
        return new ResponseEntity(reviewCriteriaService.update(reviewCriteria), HttpStatus.OK);
    }

    @DeleteMapping  ("/reviewCriteria/{id}")
    public ResponseEntity<Void> deleteReviewCriteria(@PathVariable Integer id) {
        logger.debug("DELETE: deleteReviewCriteria");
        reviewCriteriaService.delete(id);
        return ResponseEntity.ok().build();
    }
}
