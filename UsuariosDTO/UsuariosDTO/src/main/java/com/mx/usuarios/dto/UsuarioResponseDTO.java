package com.mx.usuarios.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import java.time.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioResponseDTO {

    private String username;
    private String correo;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime fecha;

    /* DTO es un Objeto de Transferencia de Datos que se usa para
     * transportar la informacion entre las capas del proyecto.
     *
     * NO es una entidad y NO tiene logica de negocio
     *
     */

}
