package com.mx.habitaciones.dominio;

import lombok.*;
import java.time.*;
import jakarta.persistence.*;
import org.hibernate.annotations.*;

@Entity
@Table(name = "HABITACIONES_BD")
@Data
public class Habitaciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String numero;
    private String tipo;
    private double precio;
    private boolean disponible;
    @CreationTimestamp
    private LocalDateTime registro;
}
