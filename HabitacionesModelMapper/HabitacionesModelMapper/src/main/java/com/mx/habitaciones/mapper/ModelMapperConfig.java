package com.mx.habitaciones.mapper;

import org.modelmapper.*;
import org.springframework.context.annotation.*;

@Configuration
public class ModelMapperConfig {

    @Bean
    ModelMapper modelMapper(){
        return new ModelMapper();
    }

    /*ModelMapper es una libreria de mapeo de objetos que convierte
     * automaticamente entidades a dto y dto a entidades.
     */
}
