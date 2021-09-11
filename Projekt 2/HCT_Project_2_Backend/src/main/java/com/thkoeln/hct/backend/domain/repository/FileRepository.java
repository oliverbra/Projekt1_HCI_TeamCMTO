package com.thkoeln.hct.backend.domain.repository;

import com.thkoeln.hct.backend.domain.model.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<File, Integer> {
}
