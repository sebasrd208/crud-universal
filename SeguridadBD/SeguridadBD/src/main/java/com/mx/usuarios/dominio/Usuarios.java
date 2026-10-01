package com.mx.usuarios.dominio;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "USUARIOS_SECURITY_BD")
@Data
public class Usuarios {

    @Id
    private String usuario;
    private String password;
    private String rol;
}
