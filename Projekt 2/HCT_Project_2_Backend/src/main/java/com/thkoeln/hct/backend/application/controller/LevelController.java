package com.thkoeln.hct.backend.application.controller;

import com.thkoeln.hct.backend.application.service.LevelService;
import com.thkoeln.hct.backend.domain.model.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LevelController {
    private static final Logger logger = LoggerFactory.getLogger(LevelController.class);

    @Autowired
    private LevelService levelService;

    @GetMapping("/levels")
    public ResponseEntity<List<Level>> getAllLevel() {
        logger.debug("GET: getAllLevel");
        return new ResponseEntity(levelService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/levels/{id}")
    public ResponseEntity<Level> getLevelById(@PathVariable Integer id) {
        logger.debug("GET: getLevelById");
        return new ResponseEntity(levelService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/levels")
    public ResponseEntity<Level> createLevel(@RequestBody Level level) {
        logger.debug("POST: createLevel");
        return new ResponseEntity(levelService.create(level), HttpStatus.CREATED);
    }

    @PutMapping(value = "/levels", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Level> updateLevel(@RequestBody Level level) {
        logger.debug("PUT: updateLevel");
        return new ResponseEntity(levelService.update(level), HttpStatus.OK);
    }

    @DeleteMapping  ("/levels/{id}")
    public ResponseEntity<Void> deleteLevel(@PathVariable Integer id) {
        logger.debug("DELETE: deleteLevel");
        levelService.delete(id);
        return ResponseEntity.ok().build();
    }
}
