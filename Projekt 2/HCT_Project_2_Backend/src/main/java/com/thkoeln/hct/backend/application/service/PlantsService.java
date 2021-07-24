package com.thkoeln.hct.backend.application.service;

import com.thkoeln.hct.backend.domain.model.Plants;
import com.thkoeln.hct.backend.domain.repository.PlantsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlantsService {

    @Autowired
    private PlantsRepository plantsRepository;

    public List<Plants> findAll(){
        return plantsRepository.findAll();
    }

    public Plants create(@NonNull Plants plants){
        return plantsRepository.save(plants);
    }

    public Plants findById(@NonNull Integer id){
        return plantsRepository.findPlantsById(id);
    }

    public Plants update(@NonNull Plants plants){
        Plants plantToUpdate = plantsRepository.findPlantsById(plants.getId());
        plantToUpdate.setBotanicalName(plants.getBotanicalName());
        return plantsRepository.save(plantToUpdate);
    }

    public void delete(@NonNull Integer id){
        plantsRepository.delete(plantsRepository.findPlantsById(id));
    }
}
