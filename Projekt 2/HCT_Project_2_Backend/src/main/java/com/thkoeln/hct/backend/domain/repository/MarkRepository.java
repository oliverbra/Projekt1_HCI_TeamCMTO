package com.thkoeln.hct.backend.domain.repository;

import com.thkoeln.hct.backend.domain.model.Mark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MarkRepository extends JpaRepository<Mark,Integer> {
    Mark findMarkById (Integer id);
}
