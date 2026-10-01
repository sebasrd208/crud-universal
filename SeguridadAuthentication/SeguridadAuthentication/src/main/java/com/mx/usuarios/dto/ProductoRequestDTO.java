package com.mx.usuarios.dto;

import lombok.Data;

@Data
public class ProductoRequestDTO {

    private String nombre;
    private double precio;
    private int stock;

}
