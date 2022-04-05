package com.learnspring.springtutorial.controller;

import com.learnspring.springtutorial.models.Users;
import com.learnspring.springtutorial.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @PostMapping
    public Users savetUser(@RequestBody Users user){
        return userService.saveUser(user);
    }
    
    @GetMapping()
    public List<Users> getUsers(){
        return userService.getUsers();      
    }
    
    @GetMapping("/user/{id}")
    public Users getUserById(@PathVariable("id") long id){
        return userService.getUserById((int) id);
    }
    
    @DeleteMapping("/user/{id}")
    public String deleteUserById(@PathVariable("id") long id){
        userService.deleteUserById(id);
        return "Deleted Successfully";
    }
    
    @PutMapping("/user/{id}")
    public Users updateUserById(@PathVariable("id") long id, @RequestBody Users user){
        return userService.updateUser(id, user);
    }
}
