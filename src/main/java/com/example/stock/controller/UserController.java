package com.example.stock.controller;

import com.example.stock.dto.SaveUserdto;
import com.example.stock.entities.User;
import com.example.stock.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/all")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }
    @GetMapping("/{name}")
    public List<User> getByName(@PathVariable String name){
        return userService.getbyname(name);
    }
    @PostMapping("/add")
    public User addUser(@RequestBody SaveUserdto user){
        return userService.Adduser(user);
    }


}
