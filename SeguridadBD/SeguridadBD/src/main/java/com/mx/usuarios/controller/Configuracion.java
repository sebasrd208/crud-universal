package com.mx.usuarios.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class Configuracion {

    @GetMapping("config")
    public String config() {
        return "Este es un mensaje desde el controlador de CONFIGURACION.";
    }
}
