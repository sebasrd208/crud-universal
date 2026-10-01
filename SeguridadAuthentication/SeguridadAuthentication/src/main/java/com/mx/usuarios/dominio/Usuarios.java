package com.mx.usuarios.dominio;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "USUARIOS_SEGURIDAD_DB")
@Data
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private Rol rol;

}
