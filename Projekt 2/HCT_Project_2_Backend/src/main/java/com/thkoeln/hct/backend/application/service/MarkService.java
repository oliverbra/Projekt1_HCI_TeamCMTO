package com.thkoeln.hct.backend.application.service;

import com.thkoeln.hct.backend.domain.model.Mark;
import com.thkoeln.hct.backend.domain.repository.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarkService {
    
    @Autowired
    private MarkRepository marksRepository;

    public List<Mark> findAll(){
        return marksRepository.findAll();
    }

    public Mark create(@NonNull Mark mark){
        return marksRepository.save(mark);
    }

    public Mark findById(@NonNull Integer id){
        return marksRepository.findMarkById(id);
    }

    public Mark update(@NonNull Mark mark){
        Mark markToUpdate = marksRepository.findMarkById(mark.getId());
        markToUpdate.setGrowSpace(mark.getGrowSpace());
        return marksRepository.save(markToUpdate);
    }

    public void delete(@NonNull Integer id){
        marksRepository.delete(marksRepository.findMarkById(id));
    }
}
