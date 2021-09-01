package com.thkoeln.hct.backend.application.service;

import com.thkoeln.hct.backend.common.exceptions.UserAlreadyExistException;
import com.thkoeln.hct.backend.common.exceptions.WrongCredentialsException;
import com.thkoeln.hct.backend.domain.model.User;
import com.thkoeln.hct.backend.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
   // BCryptPasswordEncoder passwordEncoder;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User userLogin(User user) throws WrongCredentialsException{
        if(checkIfCredentialsWrong(user.getEmail(), user.getPassword())){
            return userRepository.findByEmail(user.getEmail());
        } else {
            throw new WrongCredentialsException("username and/or password do not match");
        }
    }

    // TODO: Encrypt user password
    public User create(@NonNull User user) throws UserAlreadyExistException {
        if(checkIfUserExists(user.getEmail())){
            throw new UserAlreadyExistException("User already exists for this email");
        }
        return userRepository.save(user);
    }

    public User findById(@NonNull Integer id){
        return userRepository.findUserByid(id);
    }

    public User update(@NonNull User user){

        return userRepository.save(user);
    }

    public void delete(@NonNull Integer id){
        userRepository.delete(userRepository.findUserByid(id));
    }

    public boolean checkIfUserExists(String email) {return userRepository.findByEmail(email) !=null ? true : false;}

    public boolean checkIfCredentialsWrong(String email, String password) {return userRepository.findByEmailAndPassword(email, password) !=null ? true : false;}

   /* private void encodePassword(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
    } */

}
