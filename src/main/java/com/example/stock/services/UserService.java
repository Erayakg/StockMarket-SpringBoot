package com.example.stock.services;

import com.example.stock.dto.SaveUserdto;
import com.example.stock.entities.User;
import com.example.stock.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    private final PasswordEncoder passwordEncoder;

    public UserService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> getAllUser() {
       return userRepo.findAll();
    }
    public Optional<User> getbyname(String name){
        return userRepo.findByName(name);
    }
    public User Adduser(SaveUserdto user) {

        User newUser=new User();

        newUser.setName(user.getName());
        newUser.setSurname(user.getSurname());
        newUser.setAbout(user.getAbout());
        newUser.setEmail(user.getEmail());
        newUser.setRole(user.getRole());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(newUser);
    }
    public  User getByid(Long id){
        return userRepo.getUserById(id);
    }

}
