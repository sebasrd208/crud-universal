package com.mx.personas.dominio;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "PERSONAS_SEGURIDAD_BASICA_BD")
@Data
public class Personas {

    @Id
    private int id;
    private String nombre;
    private int edad;
    private String ciudad;

}
