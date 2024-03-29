package com.thkoeln.hct.backend.application.service;

import com.thkoeln.hct.backend.domain.model.Review;
import com.thkoeln.hct.backend.domain.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import java.util.List;
@Service


public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> findAll(){
        return reviewRepository.findAll();
    }

    public Review create(@NonNull Review review){
        return reviewRepository.save(review);
    }

    public Review findById(@NonNull Integer id){
   return reviewRepository.findReviewById(id);

    }

    public Review update(@NonNull Review review){
        Review reviewToUpdate = reviewRepository.findReviewById(review.getId());
        reviewToUpdate.setComment(review.getComment());
        reviewToUpdate.setDate(review.getDate());
        reviewToUpdate.setGrowSpace(review.getGrowSpace());
        reviewToUpdate.setUser(review.getUser());
        reviewToUpdate.setDangerCriteria(review.getDangerCriteria());
        reviewToUpdate.setLocalCriteria(review.getLocalCriteria());
       // reviewToUpdate.setText(review.getText());
        return reviewRepository.save(reviewToUpdate);
    }

    public void delete(@NonNull Integer id){
        reviewRepository.delete(reviewRepository.findReviewById(id));
    }
}
