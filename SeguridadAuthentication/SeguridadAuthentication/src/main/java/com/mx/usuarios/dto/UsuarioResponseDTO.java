package com.mx.usuarios.dto;

import com.mx.usuarios.dominio.*;
import jakarta.persistence.*;
import lombok.*;

@Data
public class UsuarioResponseDTO {

    private int id;
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private Rol rol;

}
