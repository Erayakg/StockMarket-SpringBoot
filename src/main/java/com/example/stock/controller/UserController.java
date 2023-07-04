package com.example.stock.controller;

import com.example.stock.dto.AuthRequest;
import com.example.stock.dto.SaveUserdto;
import com.example.stock.entities.User;
import com.example.stock.services.JwtService;
import com.example.stock.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@CrossOrigin(maxAge = 3600)
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    JwtService jwtService;
    @Autowired
    AuthenticationManager manager;
    @GetMapping("/all")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }
    @GetMapping("/name/{name}")
    public Optional<User> getByName(@PathVariable String name){
        return userService.getbyname(name);
    }
    @PostMapping("/add")
    public User addUser(@RequestBody SaveUserdto user){
        return userService.Adduser(user);
    }
    @GetMapping("/{id}")
    public User GetById(@PathVariable Long id){
        return userService.getByid(id);
    }
    @PostMapping("/authenticate")
    public String authenticatedAndGenerate(@RequestBody AuthRequest authRequest){
        Authentication authenticate = manager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
        if (authenticate.isAuthenticated()){
            return jwtService.generateToken(authRequest.getUserName());
        }
        else {
            throw  new UsernameNotFoundException("invalid user");
        }
    }
}
