package com.mx.usuarios.dto;

import com.mx.usuarios.dominio.Rol;
import jakarta.persistence.*;
import lombok.Data;

@Data
public class UsuarioRequestDTO {

    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private Rol rol;
}
