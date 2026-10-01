package com.mx.usuarios.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class Noticias{

    @GetMapping("noticias")
    public String noticias() {
        return "Este es un mensaje desde el controlador de NOTICIAS.";
    }
}
