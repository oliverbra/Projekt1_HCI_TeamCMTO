package com.thkoeln.hct.backend.application.service;

import com.thkoeln.hct.backend.domain.model.PlantsInGs;
import com.thkoeln.hct.backend.domain.repository.PlantsInGsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlantsInGsService {
    @Autowired
    private PlantsInGsRepository plantsInGsRepository;

    public List<PlantsInGs> findAll(){
        return plantsInGsRepository.findAll();
    }

    public PlantsInGs create(@NonNull PlantsInGs pPlantsInGsInGs){
        return plantsInGsRepository.save(pPlantsInGsInGs);
    }

    public PlantsInGs findById(@NonNull Integer id){
        return plantsInGsRepository.findPlantsInGsById(id);
    }

    public PlantsInGs update(@NonNull PlantsInGs pPlantsInGsInGs){
        PlantsInGs plantToUpdate = plantsInGsRepository.findPlantsInGsById(pPlantsInGsInGs.getId());
        plantToUpdate.setPlants(pPlantsInGsInGs.getPlants());
        return plantsInGsRepository.save(plantToUpdate);
    }

    public void delete(@NonNull Integer id){
        plantsInGsRepository.delete(plantsInGsRepository.findPlantsInGsById(id));
    }
}
