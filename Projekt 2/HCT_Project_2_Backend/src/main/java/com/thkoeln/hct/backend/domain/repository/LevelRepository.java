package com.thkoeln.hct.backend.domain.repository;

import com.thkoeln.hct.backend.domain.model.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface LevelRepository extends JpaRepository<Level, Integer> {
    Level findLevelById(Integer id);
}
