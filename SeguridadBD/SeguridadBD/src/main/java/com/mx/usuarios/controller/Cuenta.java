package com.mx.usuarios.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class Cuenta {

    @GetMapping("cuenta")
    public String cuenta() {
        return "Este es un mensaje desde el controlador de CUENTAS.";
    }
}
