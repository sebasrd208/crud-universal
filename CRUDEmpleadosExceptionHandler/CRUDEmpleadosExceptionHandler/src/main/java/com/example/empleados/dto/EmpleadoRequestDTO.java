package com.example.empleados.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
public class EmpleadoRequestDTO {

    @NotBlank(message = "El nombre es un campo obligatorio.")
    private String nombre;

    @NotBlank(message = "El puesto es un campo obligatorio.")
    private String puesto;

    @NotNull(message = "El sueldo es un campo obligatorio.")
    @Min(value = 0, message = "El sueldo no puede ser negativo")
    private double sueldo;

}
