package com.example.empleados.dto;

import lombok.*;

@Data
public class EmpleadoResponseDTO {

    private int id;
    private String nombre;
    private String puesto;
    private double sueldo;
}
