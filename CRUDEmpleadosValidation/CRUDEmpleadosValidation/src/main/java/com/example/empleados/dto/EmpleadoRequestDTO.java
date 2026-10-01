package com.example.empleados.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
public class EmpleadoRequestDTO {

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 2, max = 50)
    private String nombre;

    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "Debe ser un correo válido")
    private String correo;

    @NotBlank(message = "El puesto es obligatorio")
    private String puesto;

    @Min(value = 18, message = "Debe ser mayor de edad")
    private int edad;

}
