package com.mx.usuarios.dominio;

import lombok.*;
import java.time.*;
import jakarta.persistence.*;
import org.hibernate.annotations.*;

@Entity
@Table(name = "USUARIOS_BD")
@Data
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String username;
    private String correo;
    private String password;
    @CreationTimestamp
    private LocalDateTime fechaRegistro;

}
