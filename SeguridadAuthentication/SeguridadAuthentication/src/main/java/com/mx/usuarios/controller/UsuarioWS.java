package com.mx.usuarios.controller;

import com.mx.usuarios.dto.*;
import com.mx.usuarios.service.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;

@RestController
@RequestMapping("auth")
@CrossOrigin
public class UsuarioWS {

    @Autowired
    private UsuarioService service;

    @PostMapping("registrar")
    public ResponseEntity<?> registrar(@RequestBody UsuarioRequestDTO dto){
        return ResponseEntity.ok(service.registrar(dto));
    }
}
