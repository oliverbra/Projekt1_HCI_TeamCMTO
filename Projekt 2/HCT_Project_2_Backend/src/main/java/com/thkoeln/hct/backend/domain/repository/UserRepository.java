package com.thkoeln.hct.backend.domain.repository;

import com.thkoeln.hct.backend.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserById(Integer id);
    User findByEmail(String email);
    User findByEmailAndPassword(String email, String password);
}
