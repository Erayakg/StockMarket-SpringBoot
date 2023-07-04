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

    @Column(name = "name")
    private String name;
    private String surname;
    @Lob
    private String about;
    private String email;
    private String password;
    @Lob
    private byte[] profilePhoto;


    @OneToMany(cascade = CascadeType.ALL)
    private List<Portfolio> portfolios;

    private String role;



}
