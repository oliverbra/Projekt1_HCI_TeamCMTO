package com.thkoeln.hct.backend.domain.repository;

import com.thkoeln.hct.backend.domain.model.Plants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantsRepository extends JpaRepository<Plants, Integer> {

    Plants findPlantsById(Integer id);

    @Query("select p from Plants p where p.botanicalName = ?1")
    List<Plants> findPlantsByBotanicalName(String name);

}
