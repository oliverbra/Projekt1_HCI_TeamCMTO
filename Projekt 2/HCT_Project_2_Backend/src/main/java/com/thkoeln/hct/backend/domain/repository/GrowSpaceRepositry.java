package com.thkoeln.hct.backend.domain.repository;

import com.thkoeln.hct.backend.domain.model.GrowSpace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrowSpaceRepositry extends JpaRepository<GrowSpace, Integer> {
    GrowSpace findGrowSpaceById(Integer id);
}
