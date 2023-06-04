package com.example.stock.services;

import com.example.stock.dto.SaveUserdto;
import com.example.stock.entities.User;
import com.example.stock.repository.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;
    public List<User> getAllUser() {
       return userRepo.findAll();
    }
    public List<User> getbyname(String name){
        return userRepo.findByName(name);
    }
    public User Adduser(SaveUserdto user) {

        User newUser=new User();

        newUser.setName(user.getName());
        newUser.setSurname(user.getSurname());
        newUser.setAbout(user.getAbout());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());

        return userRepo.save(newUser);
    }

}
