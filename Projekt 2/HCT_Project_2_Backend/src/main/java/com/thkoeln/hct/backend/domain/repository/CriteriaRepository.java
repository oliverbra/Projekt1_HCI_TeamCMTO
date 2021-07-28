package com.thkoeln.hct.backend.domain.repository;

import com.thkoeln.hct.backend.domain.model.Criteria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CriteriaRepository extends JpaRepository<Criteria, Integer> {
    Criteria findCriteriaById (Integer id);
}
