package com.thkoeln.hct.backend.application.service;

import com.thkoeln.hct.backend.common.exceptions.FileNotFoundException;
import com.thkoeln.hct.backend.common.exceptions.FileStorageException;
import com.thkoeln.hct.backend.domain.model.File;
import com.thkoeln.hct.backend.domain.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;


@Service
public class FileService {
    @Autowired
    private FileRepository fileRepository;

    public File storeFile(MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if (fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            File dbFile = new File(fileName, file.getContentType(), file.getBytes());

            return fileRepository.save(dbFile);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }

    }

    public File getFile(Integer id) {
        return fileRepository.findById(id)
                .orElseThrow(() -> new FileNotFoundException("File not found with id " + id));
    }


}
