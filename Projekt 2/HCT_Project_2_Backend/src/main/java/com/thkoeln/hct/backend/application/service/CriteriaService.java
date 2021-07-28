package com.thkoeln.hct.backend.application.service;

import com.thkoeln.hct.backend.domain.model.Criteria;
import com.thkoeln.hct.backend.domain.repository.CriteriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CriteriaService {

    @Autowired
    private CriteriaRepository criteriaRepository;

    public List<Criteria> findAll(){
        return criteriaRepository.findAll();
    }

    public Criteria create(@NonNull Criteria criteria){
        return criteriaRepository.save(criteria);
    }

    public Criteria findById(@NonNull Integer id){
        return criteriaRepository.findCriteriaById(id);
    }

    public Criteria update(@NonNull Criteria criteria){
        Criteria plantToUpdate = criteriaRepository.findCriteriaById(criteria.getId());
        plantToUpdate.setExplanation(criteria.getExplanation());
        return criteriaRepository.save(plantToUpdate);
    }

    public void delete(@NonNull Integer id){
        criteriaRepository.delete(criteriaRepository.findCriteriaById(id));
    }
}
