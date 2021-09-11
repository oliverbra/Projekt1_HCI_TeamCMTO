package com.thkoeln.hct.backend.domain.repository;

import com.thkoeln.hct.backend.domain.model.Expert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpertRepository extends JpaRepository<Expert, Integer> {

    Expert findExpertById(Integer id);
}
