package com.example.empleados.dominio;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "EMPLEADOS_BD")
@Data
public class Empleados {

    @Id
    private Integer id;
    private String nombre;
    private String puesto;
    private double sueldo;
}
