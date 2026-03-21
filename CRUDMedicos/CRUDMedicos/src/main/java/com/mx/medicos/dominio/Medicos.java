package com.mx.medicos.dominio;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "MEDICOS_BD")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Medicos {

    @Id
    private int id;
    private String nombre;
    private String especialidad;
    private double sueldo;

    //ManyToOne define el tipo de cardinalidad entre las entidades
    //FetchType.EAGER indica que cuando carga un medico automaticamente carga la
    //informacion del hospital.
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hospital") //Define la llave doranea
    private Hospitales hospital;

}
