package com.mx.usuarios.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class Informacion {

    @GetMapping("info")
    public String info() {
        return "Este es un mensaje desde el controlador de INFORMACION.";
    }
}
