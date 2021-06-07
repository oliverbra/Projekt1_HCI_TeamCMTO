package com.thkoeln.hct.backend.domain.repository;

import com.thkoeln.hct.backend.domain.model.Mensch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenschRepository extends JpaRepository<Mensch, Integer> {

}
