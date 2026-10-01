package com.mx.usuarios.controller;

import com.mx.usuarios.dto.*;
import com.mx.usuarios.service.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.*;
import org.springframework.beans.factory.annotation.*;

@RestController
@RequestMapping("productos")
@CrossOrigin
public class ProductosWS {

    @Autowired
    private ProductosService service;

    //Publico
    @GetMapping
    public ResponseEntity<?> listar(){
        return ResponseEntity.ok(service.listar());
    }

    //Solo ADMIN
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')") //Solo los usuarios con rol ADMIN pueden ejecutar este metodo.
    public ResponseEntity<?> guardar(@RequestBody ProductoRequestDTO dto){
        return ResponseEntity.ok(service.guardar(dto));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> buscar(@PathVariable int id){
        return ResponseEntity.ok(service.buscar(id));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<?> eliminar(@PathVariable int id){
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
