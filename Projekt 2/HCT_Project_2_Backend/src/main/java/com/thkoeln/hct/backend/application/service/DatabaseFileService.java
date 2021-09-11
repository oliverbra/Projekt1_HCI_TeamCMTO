package com.thkoeln.hct.backend.application.service;

import com.thkoeln.hct.backend.common.exceptions.FileNotFoundException;
import com.thkoeln.hct.backend.common.exceptions.FileStorageException;
import com.thkoeln.hct.backend.domain.model.DatabaseFile;
import com.thkoeln.hct.backend.domain.repository.DatabaseFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

import org.springframework.lang.NonNull;





@Service
public class DatabaseFileService {
    @Autowired
    private DatabaseFileRepository dbFileRepository;

    public DatabaseFile storeFile(MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if (fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            DatabaseFile dbFile = new DatabaseFile(fileName, file.getContentType(), file.getBytes());

            return dbFileRepository.save(dbFile);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }

    }

    public DatabaseFile getFile(Integer id) {
        return dbFileRepository.findById(id)
                .orElseThrow(() -> new FileNotFoundException("File not found with id " + id));
    }


    public DatabaseFile create (@NonNull DatabaseFile databaseFile)
    {return dbFileRepository.save(databaseFile);}

    public List<DatabaseFile> findAll(){
        return dbFileRepository.findAll();
    }
}
