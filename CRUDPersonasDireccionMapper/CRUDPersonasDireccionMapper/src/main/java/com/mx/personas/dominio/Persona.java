package com.mx.personas.dominio;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "PERSONAS_MAPPER")
@Data
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private int edad;
    @OneToOne(cascade = CascadeType.ALL)
    private Direccion direccion;
}
