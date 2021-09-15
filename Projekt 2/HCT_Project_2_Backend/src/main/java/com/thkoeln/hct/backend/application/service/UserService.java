package com.thkoeln.hct.backend.application.service;

import com.thkoeln.hct.backend.common.exceptions.UserAlreadyExistException;
import com.thkoeln.hct.backend.common.exceptions.WrongCredentialsException;
import com.thkoeln.hct.backend.domain.model.User;
import com.thkoeln.hct.backend.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;
import org.springframework.lang.NonNull;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.thkoeln.hct.backend.domain.model.Level;
import com.thkoeln.hct.backend.domain.repository.LevelRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private LevelRepository levelRepository;

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
        if(checkIfEmailExists(user.getEmail()) ||checkIfUsernameExists(user.getUserName())){
            throw new UserAlreadyExistException("User already exists for this email OR username");
        }
        return userRepository.save(user);
    }

    public User findById(@NonNull Integer id){
        return userRepository.findUserById(id);
    }

    public User update(@NonNull User user){
        User userToUpdate = userRepository.findUserById(user.getId());
        userToUpdate.setGrowpoints(user.getGrowpoints());
        userToUpdate.setLevel(user.getLevel());

        /*/ Check Level Up
        if(userToUpdate.getGrowpoints() >= userToUpdate.getLevel().getLevelThreshold()) {
            // Reduce User GP after Level Up
            userToUpdate.setGrowpoints(userToUpdate.getGrowpoints() - userToUpdate.getLevel().getLevelThreshold());
            // Perform Level Up
            int id = userToUpdate.getLevel().getId() + 1; // --> Level müssen nach ID sortiert sein
            userToUpdate.setLevel(levelRepository.findLevelById(id));

            //levelService = new LevelService(levelRepository);
            //userToUpdate.setLevel(levelService.levelUp(levelToLevelUp));
        } */

        return userRepository.save(user);
    }

    public void delete(@NonNull Integer id){
        userRepository.delete(userRepository.findUserById(id));
    }

    public boolean checkIfEmailExists(String email) {return userRepository.findByEmail(email) !=null ? true : false;}

    public boolean checkIfUsernameExists(String userName) {return userRepository.findByuserName(userName) !=null ? true : false;}

    public boolean checkIfCredentialsWrong(String email, String password) {return userRepository.findByEmailAndPassword(email, password) !=null ? true : false;}

   /* private void encodePassword(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
    } */

}
