package com.thkoeln.hct.backend.application.controller;

import com.thkoeln.hct.backend.application.service.FileService;
import com.thkoeln.hct.backend.domain.model.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.core.io.ByteArrayResource;
import javax.servlet.http.HttpServletRequest;



@RestController
public class FileDownloadController {

    @Autowired
    private FileService fileService;

    @GetMapping("/getFile/{id}")
    public ResponseEntity <File> getFile(@PathVariable Integer id) {//byte[]
        File file = fileService.getFile(id);

//        return ResponseEntity
//                .ok()
//                .contentType(MediaType.parseMediaType(file.getFileType()))
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFileName() + "\"")
//                .body(file.getData());

          return new ResponseEntity(file, HttpStatus.OK);
    }
}
