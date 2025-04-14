package com.abaduna.serch.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import lombok.Data;
import jakarta.persistence.*;
@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String location;

}
