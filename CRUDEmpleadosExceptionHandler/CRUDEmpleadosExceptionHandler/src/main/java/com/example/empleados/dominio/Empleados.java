package com.example.empleados.dominio;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "EMPLEADOS_HANDLER_BD")
@Data
public class Empleados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String puesto;
    private double sueldo;
}
