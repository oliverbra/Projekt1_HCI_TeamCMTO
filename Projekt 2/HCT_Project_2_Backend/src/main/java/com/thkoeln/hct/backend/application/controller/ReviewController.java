package com.thkoeln.hct.backend.application.controller;

import com.thkoeln.hct.backend.application.service.GrowSpaceService;
import com.thkoeln.hct.backend.application.service.ReviewService;
import com.thkoeln.hct.backend.application.service.UserService;
import com.thkoeln.hct.backend.domain.model.GrowSpace;
import com.thkoeln.hct.backend.domain.model.Level;
import com.thkoeln.hct.backend.domain.model.Review;
import com.thkoeln.hct.backend.domain.repository.ReviewRepository;
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

    @Autowired
    private GrowSpaceService growSpaceService;

    @Autowired
    private UserService userService;


    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews() {
        logger.debug("GET: getAllReviews");
        return new ResponseEntity(reviewService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/growspaces/{growspaceId}/reviews")
    public ResponseEntity<List<Review>> getAllReviewsByGrowspaceId(@PathVariable Integer growspaceId) {
        logger.debug("GET: getAllReviewsByGrowspaceId");
        return new ResponseEntity(reviewService.findByGsID(growspaceId), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/reviews")
    public ResponseEntity<List<Review>> getAllReviewsByUserId(@PathVariable Integer userId) {
        logger.debug("GET: getAllReviewsByUserId");
        return new ResponseEntity(userService.findById(userId), HttpStatus.OK);
    }

    @PostMapping("/growspaces/{growspaceId}/reviews")
    public ResponseEntity<Review> createReview(@RequestBody Review review, @PathVariable Integer growspaceId) {
        logger.debug("POST: createReview");
        review.setGrowSpace(growSpaceService.findByid(growspaceId));
        return new ResponseEntity(reviewService.create(review), HttpStatus.CREATED);
    }

    @GetMapping("/reviews/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable Integer id) {
        logger.debug("GET: getReviewById");
        return new ResponseEntity(reviewService.findById(id), HttpStatus.OK);
    }

    @PutMapping(value = "/reviews", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Review> updateReview(@RequestBody Review review) {
        logger.debug("PUT: updateReview");
        return new ResponseEntity(reviewService.update(review), HttpStatus.OK);
    }

    @DeleteMapping  ("/reviews/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Integer id) {
        logger.debug("DELETE: deleteReview");
        reviewService.delete(id);
        return ResponseEntity.ok().build();
    }
    
}
