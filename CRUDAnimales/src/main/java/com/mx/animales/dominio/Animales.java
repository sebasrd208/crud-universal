package com.mx.animales.dominio;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ANIMALES_BD")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Animales {

    @Id
    private int id;
    private String tipo;
    private String nombre;
    private int edad;
}
