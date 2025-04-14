package com.abaduna.serch.models;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Statements {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String contenidoLargo;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
