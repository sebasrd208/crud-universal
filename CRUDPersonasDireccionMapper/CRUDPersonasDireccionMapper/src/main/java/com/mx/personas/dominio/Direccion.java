package com.mx.personas.dominio;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "DIRECCION_MAPPER")
@Data
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String calle;
    private String numero;
    private String colonia;
}
