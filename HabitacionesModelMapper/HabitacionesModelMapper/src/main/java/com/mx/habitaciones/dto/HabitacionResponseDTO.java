package com.mx.habitaciones.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class HabitacionResponseDTO {

    private String numero;
    private String tipo;
    private String precio;
    private LocalDateTime registro;

}
