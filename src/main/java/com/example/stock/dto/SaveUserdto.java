package com.example.stock.dto;

import jakarta.persistence.Lob;
import lombok.Data;

@Data
public class SaveUserdto {

    private String name;
    private String surname;
    private String about;
    private String email;
    private String password;
}
