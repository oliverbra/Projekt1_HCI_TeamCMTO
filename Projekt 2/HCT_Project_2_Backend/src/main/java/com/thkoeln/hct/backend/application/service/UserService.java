package com.thkoeln.hct.backend.application.service;

import com.thkoeln.hct.backend.domain.model.User;
import com.thkoeln.hct.backend.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User create(@NonNull User user){
        return userRepository.save(user);
    }

    public User findById(@NonNull Integer id){
        return userRepository.findUserByid(id);
    }

    public User update(@NonNull User user){
        User userToUpdate = userRepository.findUserByid(user.getId());
        userToUpdate.setEmail(user.getEmail());
        return userRepository.save(userToUpdate);
    }

    public void delete(@NonNull Integer id){
        userRepository.delete(userRepository.findUserByid(id));
    }
}
