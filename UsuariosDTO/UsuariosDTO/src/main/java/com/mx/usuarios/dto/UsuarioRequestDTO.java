package com.mx.usuarios.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRequestDTO {

    private String nombre;
    private String username;
    private String correo;
    private String password;
}
