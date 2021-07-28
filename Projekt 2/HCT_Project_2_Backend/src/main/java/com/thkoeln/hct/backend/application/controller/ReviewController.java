package com.thkoeln.hct.backend.application.controller;

import com.thkoeln.hct.backend.application.service.ReviewService;
import com.thkoeln.hct.backend.domain.model.Review;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewController {

    private static final Logger logger = LoggerFactory.getLogger(ReviewController.class);

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/review")
    public ResponseEntity<List<Review>> getAllReview() {
        logger.debug("GET: getAllReview");
        return new ResponseEntity(reviewService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/review/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable Integer id) {
        logger.debug("GET: getReviewById");
        return new ResponseEntity(reviewService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/review")
    public ResponseEntity<Review> createReview(@RequestBody Review review) {
        logger.debug("POST: createReview");
        return new ResponseEntity(reviewService.create(review), HttpStatus.CREATED);
    }

    @PutMapping(value = "/review", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Review> updateReview(@RequestBody Review review) {
        logger.debug("PUT: updateReview");
        return new ResponseEntity(reviewService.update(review), HttpStatus.OK);
    }

    @DeleteMapping  ("/review/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Integer id) {
        logger.debug("DELETE: deleteReview");
        reviewService.delete(id);
        return ResponseEntity.ok().build();
    }
    
}
