package com.thkoeln.hct.backend.application.service;

import com.thkoeln.hct.backend.domain.model.Level;
import com.thkoeln.hct.backend.domain.repository.LevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LevelService {
    @Autowired
    private LevelRepository levelRepository;

    public List<Level> findAll(){
        return levelRepository.findAll();
    }

    public Level create(@NonNull Level level){
        return levelRepository.save(level);
    }

    public Level findById(@NonNull Integer id){
        return levelRepository.findLevelById(id);
    }

    public Level update(@NonNull Level level){
        Level levelToUpdate = levelRepository.findLevelById(level.getId());
        levelToUpdate.setLevel(level.getLevel());
        return levelRepository.save(levelToUpdate);
    }

    public void delete(@NonNull Integer id){
        levelRepository.delete(levelRepository.findLevelById(id));
    }

    public Level levelUp(Level level) {
        int id = level.getId() + 1; // --> Level müssen nach ID sortiert sein
        return  levelRepository.findLevelById(id);
    }
}
