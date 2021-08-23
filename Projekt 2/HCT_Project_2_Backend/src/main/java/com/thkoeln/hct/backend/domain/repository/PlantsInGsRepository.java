package com.thkoeln.hct.backend.domain.repository;

import com.thkoeln.hct.backend.domain.model.Plants;
import com.thkoeln.hct.backend.domain.model.PlantsInGs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantsInGsRepository extends JpaRepository<PlantsInGs, Integer> {
    PlantsInGs findPlantsInGsById(Integer id);
}
