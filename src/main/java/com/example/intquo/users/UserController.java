package com.example.intquo.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("users/{id}")
    public User findById(@PathVariable Integer id){
        return userRepository.findById(id).orElse(null);
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    @PostMapping("/users")
    public User createUser(@RequestBody User user){
        return userRepository.save(user);
    }
}
