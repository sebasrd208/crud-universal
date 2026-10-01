package com.mx.usuarios.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class Contacto {

    @GetMapping("contacto")
    public String contacto() {
        return "Este es un mensaje desde el controlador de CONTACTO.";
    }
}
