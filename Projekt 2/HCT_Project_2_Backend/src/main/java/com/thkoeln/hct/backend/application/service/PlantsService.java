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
        plantToUpdate.setBlossomColour(plants.getBlossomColour());
        plantToUpdate.setBlossomingTime(plants.getBlossomingTime());
        plantToUpdate.setCommonName(plants.getCommonName());
        plantToUpdate.setCareText(plants.getCareText());
        plantToUpdate.setDescriptionText(plants.getDescriptionText());
        plantToUpdate.setGrowthCharacteristics(plants.getGrowthCharacteristics());
        plantToUpdate.setLight(plants.getLight());
        plantToUpdate.setNativty(plants.getNativty());
        plantToUpdate.setNectarPollen(plants.getNectarPollen());
        plantToUpdate.setNutrientRequirements(plants.getNutrientRequirements());
        plantToUpdate.setOrnamentalValue(plants.getOrnamentalValue());
        plantToUpdate.setPhValue(plants.getPhValue());
        plantToUpdate.setPlantCategory(plants.getPlantCategory());
        plantToUpdate.setPoisonous(plants.getPoisonous());
        plantToUpdate.setSoil(plants.getSoil());
        plantToUpdate.setSoilMoisture(plants.getSoilMoisture());
        plantToUpdate.setUrl(plants.getUrl());
        plantToUpdate.setUtilityValue(plants.getUtilityValue());
        plantToUpdate.setBotanicalName(plants.getBotanicalName());
        return plantsRepository.save(plantToUpdate);
    }

    public void delete(@NonNull Integer id){
        plantsRepository.delete(plantsRepository.findPlantsById(id));
    }
}
