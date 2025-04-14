package com.abaduna.serch.models;

import lombok.Data;

@Data
public class StatementRequest {
    private String titulo;
    private String contenidoLargo;
    private Long userId;
}
