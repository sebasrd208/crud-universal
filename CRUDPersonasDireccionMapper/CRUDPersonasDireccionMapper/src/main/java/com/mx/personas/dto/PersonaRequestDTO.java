package com.mx.personas.dto;

import lombok.Data;

@Data
public class PersonaRequestDTO {

    private String nombre;
    private int edad;
    private DireccionRequestDTO direccion;

}