package com.thkoeln.hct.backend.application.service;

import com.thkoeln.hct.backend.domain.model.GrowSpace;
import com.thkoeln.hct.backend.domain.model.PlantList;
import com.thkoeln.hct.backend.domain.model.Plants;
import com.thkoeln.hct.backend.domain.model.ReviewList;
import com.thkoeln.hct.backend.domain.repository.PlantsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PlantsService {

    @Autowired
    private PlantsRepository plantsRepository;
    @Autowired
    private GrowSpaceService growSpaceService;
    @Autowired
    private FileService fileService;
;

    public PlantList findAll(){
        PlantList allPlants = new PlantList();
        allPlants.setPlantsList(plantsRepository.findAll());
        return allPlants;
    }

    public Plants create(@NonNull Plants plants){
        return plantsRepository.save(plants);
    }

    public Optional<Plants> findPlantsByBotanicalName(String name){

        List<Plants> plants =  plantsRepository.findPlantsByBotanicalName(name);

        if(plants.stream().findFirst().isPresent()){
             return plants.stream().findFirst();

        }


//        if (plantsRepository != null) {
//            List<Plants> plantsList = plantsRepository.findAll();
//            plantsList = plantsList.stream().filter(pl -> pl.getBotanicalName().equals(name)).collect(Collectors.toList());
//            if (plantsList != null) {
//                return plantsList.get(0);
//            }
//        }
        return  Optional.empty();
    }

    public Plants findById(@NonNull Integer id){
        return plantsRepository.findPlantsById(id);
    }

    public Plants update(@NonNull Plants plants){
        Plants plantToUpdate = plantsRepository.findPlantsById(plants.getId());
        plantsRepository.save(plants);
        return  plants;
    }

    /*public Plants update(@NonNull Plants plants){


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

        plantToUpdate.setGrowSpace(plants.getGrowSpace());

        return plantsRepository.save(plantToUpdate);
    }*/



    public void delete(@NonNull Integer id){
        plantsRepository.delete(plantsRepository.findPlantsById(id));
    }
}
