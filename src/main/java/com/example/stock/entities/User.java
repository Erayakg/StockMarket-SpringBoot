package com.example.stock.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Table(name = "USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    private String surname;

    private String UserName;

    @Lob
    private String about;

    private String email;

    private String password;


    @Lob
    private byte[] profilePhoto;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Portfolio> portfolios;

    private String role;
}