package com.thkoeln.hct.backend.domain.repository;

import com.thkoeln.hct.backend.domain.model.DatabaseFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatabaseFileRepository extends JpaRepository<DatabaseFile, Integer> {
    DatabaseFile findDatabaseFileById(Integer id);
}
