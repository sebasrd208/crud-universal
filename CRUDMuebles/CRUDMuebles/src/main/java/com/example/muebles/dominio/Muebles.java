package com.example.muebles.dominio;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "MUEBLES_BD")
@Data
public class Muebles {

    @Id
    private int id;
    private String tipo;
    private String marca;
    private String area;
    private double precio;
    private int stock;
}
