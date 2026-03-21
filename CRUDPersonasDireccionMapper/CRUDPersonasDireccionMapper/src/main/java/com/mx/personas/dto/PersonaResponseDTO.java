package com.mx.personas.dto;

import lombok.Data;

@Data
public class PersonaResponseDTO {

    private String nombre;
    private int edad;
    private DireccionResponseDTO direccion;

}
