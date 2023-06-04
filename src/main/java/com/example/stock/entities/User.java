package com.example.stock.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Name;
    private String Surname;
    @Lob
    private String About;
    private String email;
    private String password;
    @Lob
    private byte[] profilePhoto;
    @OneToMany
    List<Coin> coins;

}
