package com.thkoeln.hct.backend.domain.repository;

import com.thkoeln.hct.backend.domain.model.GrowSpace;
import com.thkoeln.hct.backend.domain.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

    Review findReviewByGrowSpaceId(Integer id);
}
