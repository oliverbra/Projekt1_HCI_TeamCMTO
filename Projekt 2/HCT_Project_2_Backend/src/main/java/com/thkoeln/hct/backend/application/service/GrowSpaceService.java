package com.thkoeln.hct.backend.application.service;

import com.thkoeln.hct.backend.domain.model.GrowSpace;
import com.thkoeln.hct.backend.domain.repository.GrowSpaceRepositry;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Random;

@Service
public class GrowSpaceService {
    @Autowired
    private GrowSpaceRepositry growSpaceRepositry;

    public List<GrowSpace> findAll(){return growSpaceRepositry.findAll();}

    public  GrowSpace create (@NonNull GrowSpace growSpace) {return growSpaceRepositry.save(growSpace);}

    public GrowSpace findByid(@NonNull Integer id) {return growSpaceRepositry.findGrowSpaceById(id);}

    public GrowSpace update(@NonNull GrowSpace growSpace){
        GrowSpace growSpaceToUpdate = growSpaceRepositry.findGrowSpaceById(growSpace.getId());
        growSpaceToUpdate.setName(growSpace.getName());
        growSpaceToUpdate.setProblems(growSpace.getProblems());
        growSpaceToUpdate.setGoal(growSpace.getGoal());
        growSpaceToUpdate.setSize(growSpace.getSize());
        growSpaceToUpdate.setCategory(growSpace.getCategory());
        growSpaceToUpdate.setLocation(growSpace.getLocation());
        growSpaceToUpdate.setAverageRating(growSpace.getAverageRating());
        return growSpaceRepositry.save(growSpaceToUpdate);
    }

    public void delete(@NonNull Integer id) {growSpaceRepositry.delete(growSpaceRepositry.findGrowSpaceById(id));}

    public GrowSpace findRandom(){
        List<GrowSpace> growSpaceList = growSpaceRepositry.findAll();
        Random rand = new Random();
        GrowSpace randomGrowSpace = growSpaceList.get(rand.nextInt(growSpaceList.size()));
        return growSpaceRepositry.findGrowSpaceById(randomGrowSpace.getId());
    }
}
