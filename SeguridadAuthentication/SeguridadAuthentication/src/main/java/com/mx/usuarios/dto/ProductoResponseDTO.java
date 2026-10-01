package com.mx.usuarios.dto;

import lombok.Data;

@Data
public class ProductoResponseDTO {

    private int id;
    private String nombre;
    private double precio;
    private int stock;

}
