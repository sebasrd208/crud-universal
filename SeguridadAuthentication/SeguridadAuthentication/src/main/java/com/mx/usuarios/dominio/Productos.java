package com.mx.usuarios.dominio;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "PRODUCTOS_SEGURIDAD_DB")
@Data
public class Productos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private double precio;
    private int stock;
}
