package com.thkoeln.hct.backend.application.service;

import com.thkoeln.hct.backend.domain.model.ReviewCriteria;
import com.thkoeln.hct.backend.domain.repository.ReviewCriteriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewCriteriaService {

    @Autowired
    private ReviewCriteriaRepository reviewCriteriaRepository;

    public List<ReviewCriteria> findAll(){
        return reviewCriteriaRepository.findAll();
    }

    public ReviewCriteria create(@NonNull ReviewCriteria reviewCriteria){
        return reviewCriteriaRepository.save(reviewCriteria);
    }

    public ReviewCriteria findById(@NonNull Integer id){
        return reviewCriteriaRepository.findReviewCriteriaById(id);
    }

    public ReviewCriteria update(@NonNull ReviewCriteria reviewCriteria){
        ReviewCriteria reviewCriteriaToUpdate = reviewCriteriaRepository.findReviewCriteriaById(reviewCriteria.getId());
        reviewCriteriaToUpdate.setFaktor(reviewCriteria.getFaktor());
        return reviewCriteriaRepository.save(reviewCriteriaToUpdate);
    }

    public void delete(@NonNull Integer id){
        reviewCriteriaRepository.delete(reviewCriteriaRepository.findReviewCriteriaById(id));
    }
}
