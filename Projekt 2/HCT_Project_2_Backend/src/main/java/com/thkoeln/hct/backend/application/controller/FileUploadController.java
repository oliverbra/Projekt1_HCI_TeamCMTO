package com.thkoeln.hct.backend.application.controller;

import com.thkoeln.hct.backend.application.service.FileService;
import com.thkoeln.hct.backend.domain.model.File;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class FileUploadController {

    private static final Logger logger = LoggerFactory.getLogger(FileService.class);

    @Autowired
    private FileService fileService;

    @PostMapping("/uploadFile")
    public ResponseEntity uploadFile(@RequestParam("file") MultipartFile file) {
        File fileName = fileService.storeFile(file);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/uploadMultipleFiles")
    public List <ResponseEntity> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(file))
                .collect(Collectors.toList());
    }

}

