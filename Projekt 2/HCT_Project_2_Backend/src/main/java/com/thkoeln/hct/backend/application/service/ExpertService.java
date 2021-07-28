package com.thkoeln.hct.backend.application.service;

import com.thkoeln.hct.backend.domain.model.Expert;
import com.thkoeln.hct.backend.domain.repository.ExpertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpertService {
    @Autowired
    private ExpertRepository expertRepository;

    public List<Expert> findAll(){
        return expertRepository.findAll();
    }

    public Expert create(@NonNull Expert expert){
        return expertRepository.save(expert);
    }

    public Expert findById(@NonNull Integer id){
        return expertRepository.findExpertById(id);
    }

    public Expert update(@NonNull Expert expert){
        Expert expertToUpdate = expertRepository.findExpertById(expert.getId());
        expertToUpdate.setUser(expert.getUser());
        return expertRepository.save(expertToUpdate);
    }

    public void delete(@NonNull Integer id){
        expertRepository.delete(expertRepository.findExpertById(id));
    }
}
