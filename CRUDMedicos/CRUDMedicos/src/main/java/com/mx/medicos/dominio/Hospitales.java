package com.mx.medicos.dominio;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Table(name = "HOSPITALES_BD")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hospitales {

    @Id
    private int idHospital;
    private String nombre;

    //Suprime los metodos get y set de la lista de medicos.
    //Esto es util porque evita la recursividad infinita
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    //Define cardinalidad, mapeo y persistencia
    @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL)
    List<Medicos> lista = new ArrayList<>();

}
