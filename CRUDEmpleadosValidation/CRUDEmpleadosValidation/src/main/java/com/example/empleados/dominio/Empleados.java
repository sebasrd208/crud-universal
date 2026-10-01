package com.example.empleados.dominio;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "EMPLEADOS_VALID_DB")
@Data
public class Empleados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String correo;
    private String puesto;
    private int edad;

}
