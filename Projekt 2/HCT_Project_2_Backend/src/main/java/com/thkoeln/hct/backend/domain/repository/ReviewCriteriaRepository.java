package com.thkoeln.hct.backend.domain.repository;

import com.thkoeln.hct.backend.domain.model.Plants;
import com.thkoeln.hct.backend.domain.model.ReviewCriteria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewCriteriaRepository extends JpaRepository<ReviewCriteria, Integer> {

    ReviewCriteria findReviewCriteriaById(Integer id);
}
