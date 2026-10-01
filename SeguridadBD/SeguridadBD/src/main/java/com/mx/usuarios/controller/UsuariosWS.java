package com.mx.usuarios.controller;

import com.mx.usuarios.dominio.*;
import com.mx.usuarios.service.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;

@RestController
@RequestMapping("usuarios")
public class UsuariosWS {

    @Autowired
    private UsuariosService service;

    @PostMapping("/registro")
    public ResponseEntity<?> registro(@RequestBody Usuarios usuario){
        return ResponseEntity.ok(service.registro(usuario));
    }

    @GetMapping("/prueba")
    public ResponseEntity<?> prueba(){
        return ResponseEntity.ok("Este es un mensaje de prueba desde UsuariosWS.");
    }
}
