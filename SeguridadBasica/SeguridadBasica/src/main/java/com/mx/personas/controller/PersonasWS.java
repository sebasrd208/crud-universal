package com.mx.personas.controller;

import com.mx.personas.dominio.*;
import com.mx.personas.service.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;

@RestController
@RequestMapping("personas")
public class PersonasWS {

    @Autowired
    private PersonasService service;

    @GetMapping("listar")
    public ResponseEntity<?> listar(){
        return ResponseEntity.ok(service.listar());
    }

    @PostMapping("guardar")
    public ResponseEntity<?> guardar(@RequestBody Personas p){
        service.guardar(p);
        return ResponseEntity.ok("Registro exitoso!");
    }

    @GetMapping("buscar/{id}")
    public ResponseEntity<?> buscar(@PathVariable int id){
        return ResponseEntity.ok(service.buscar(id));
    }

    @PutMapping("editar")
    public ResponseEntity<?> editar(@RequestBody Personas p){
        service.editar(p);
        return ResponseEntity.ok("Modificacion exitosa!");
    }

    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable int id){
        service.eliminar(id);
        return ResponseEntity.ok("Eliminacion exitosa!");
    }
}
