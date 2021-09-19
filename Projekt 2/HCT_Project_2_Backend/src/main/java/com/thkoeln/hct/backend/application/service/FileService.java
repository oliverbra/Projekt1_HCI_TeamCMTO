package com.thkoeln.hct.backend.application.service;

import com.thkoeln.hct.backend.common.exceptions.FileNotFoundException;
import com.thkoeln.hct.backend.common.exceptions.FileStorageException;
import com.thkoeln.hct.backend.domain.model.File;
import com.thkoeln.hct.backend.domain.model.Plants;
import com.thkoeln.hct.backend.domain.repository.FileRepository;
import com.thkoeln.hct.backend.domain.repository.PlantsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Optional;
import java.util.regex.Pattern;


@Service
public class FileService {
    @Autowired
    private FileRepository fileRepository;
    @Autowired
    private PlantsRepository plantsRepository;
    @Autowired
    private PlantsService plantsService;


    public void plantsAddFile(String name, File file){
        Optional<Plants> plantAsOptiona = plantsService.findPlantsByBotanicalName(name);

        if(plantAsOptiona.isPresent()){
            Plants plants = plantAsOptiona.get();
            plants.setFile(file);
            plantsRepository.save(plants);
        }


    }

    public File storeFile(MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        String[] split  = fileName.split(Pattern.quote("."));
        String name = split[0];
        try {
            // Check if the file's name contains invalid characters
            if (fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            File dbFile = new File(fileName, file.getContentType(), file.getBytes(), file.getName());
            dbFile.setName(name);
            File savedFile = fileRepository.save(dbFile);
            plantsAddFile(name,dbFile);

            return savedFile;

        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }

    }

    public File getFile(Integer id) {
        return fileRepository.findById(id)
                .orElseThrow(() -> new FileNotFoundException("File not found with id " + id));
    }


}
