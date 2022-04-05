package com.learnspring.springtutorial.service;

import com.learnspring.springtutorial.models.Users;
import java.util.List;

public interface UserService {

    public Users saveUser(Users user);

    public List<Users> getUsers();

    public Users getUserById(long id);

    public void deleteUserById(long id);

    public Users updateUser(long id, Users user);
    
}
