package com.thkoeln.hct.backend.application.controller;

import com.thkoeln.hct.backend.application.service.DatabaseFileService;
import com.thkoeln.hct.backend.domain.model.DatabaseFile;
import com.thkoeln.hct.backend.domain.model.Plants;
import com.thkoeln.hct.backend.domain.model.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class FileUploadController {

    private static final Logger logger = LoggerFactory.getLogger(DatabaseFileService.class);

    @Autowired
    private DatabaseFileService fileStorageService;

    @PostMapping("/uploadFile")
    public ResponseEntity uploadFile(@RequestParam("file") MultipartFile file) {
        DatabaseFile fileName = fileStorageService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName.getFileName())
                .toUriString();

     //   return new ResponseEntity(fileName.getFileName(), fileDownloadUri,
      //          file.getContentType(), file.getSize());
        return new ResponseEntity(fileStorageService.create(fileName), HttpStatus.OK);
    }

    @PostMapping("/uploadMultipleFiles")
    public List <ResponseEntity> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(file))
                .collect(Collectors.toList());
    }

    @PostMapping("/file")
    public ResponseEntity<List<DatabaseFile>> getAllFiles() {
        logger.debug("GET: getAllFiles");
        return new ResponseEntity(fileStorageService.findAll(), HttpStatus.OK);
    }

}

