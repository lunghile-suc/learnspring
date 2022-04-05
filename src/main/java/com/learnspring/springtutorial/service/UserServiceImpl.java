package com.learnspring.springtutorial.service;

import com.learnspring.springtutorial.models.Users;
import com.learnspring.springtutorial.repository.UserRepository;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    
    @Autowired
    private UserRepository userRepository;
    
    @Override
    public Users saveUser(Users user) {
        return userRepository.save(user);
    }

    @Override
    public List<Users> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public Users getUserById(long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void deleteUserById(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Users updateUser(long id, Users user) {
        Users userFromDB = userRepository.findById(id).get();
        
        if(Objects.nonNull(user.getEmail()) && !"".equalsIgnoreCase(user.getEmail())){
            userFromDB.setEmail(user.getEmail());
        }
        
        if(Objects.nonNull(user.getFirstName()) && !"".equalsIgnoreCase(user.getFirstName())){
            userFromDB.setFirstName(user.getFirstName());
        }
        
        if(Objects.nonNull(user.getSurname()) && !"".equalsIgnoreCase(user.getSurname())){
            userFromDB.setSurname(user.getSurname());
        }
        
        return userRepository.save(userFromDB);
    }
    
}
