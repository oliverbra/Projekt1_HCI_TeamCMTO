package com.thkoeln.hct.backend.application.controller;

import com.thkoeln.hct.backend.application.service.MarkService;
import com.thkoeln.hct.backend.domain.model.Mark;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class MarkController {

    private static final Logger logger = LoggerFactory.getLogger(MarkController.class);

    @Autowired
    private MarkService markService;

    @GetMapping("/marks")
    public ResponseEntity<List<Mark>> getAllMark() {
        logger.debug("GET: getAllMark");
        return new ResponseEntity(markService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/marks/{id}")
    public ResponseEntity<Mark> getMarkById(@PathVariable Integer id) {
        logger.debug("GET: getMarkById");
        return new ResponseEntity(markService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/marks")
    public ResponseEntity<Mark> createLevel(@RequestBody Mark mark) {
        logger.debug("POST: createLevel");
        return new ResponseEntity(markService.create(mark), HttpStatus.CREATED);
    }

    @PutMapping(value = "/marks", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Mark> updateLevel(@RequestBody Mark mark) {
        logger.debug("PUT: updateLevel");
        return new ResponseEntity(markService.update(mark), HttpStatus.OK);
    }

    @DeleteMapping  ("/marks/{id}")
    public ResponseEntity<Void> deleteLevel(@PathVariable Integer id) {
        logger.debug("DELETE: deleteLevel");
        markService.delete(id);
        return ResponseEntity.ok().build();
    }
}
