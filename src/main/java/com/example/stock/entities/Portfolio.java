package com.example.stock.entities;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    Date createdDate;
    Double portfolioPrice;

    @OneToMany(cascade = CascadeType.ALL )
    List<PortfolioCoin>  portfolioCoins =new ArrayList<>();

    @ManyToOne
    @JsonBackReference
    private User user;
    @PrePersist
    public void prePersist() {
        this.createdDate = new Date();
    }
}
