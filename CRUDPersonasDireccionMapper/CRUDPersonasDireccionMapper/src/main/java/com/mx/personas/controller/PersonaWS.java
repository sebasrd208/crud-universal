package com.mx.personas.controller;

import com.mx.personas.dto.*;
import com.mx.personas.service.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;

@RestController
@RequestMapping("personas")
public class PersonaWS {

    @Autowired
    private PersonaService service;

    @GetMapping
    public ResponseEntity<?> listar(){
        return ResponseEntity.ok(service.listar());
    }

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody PersonaRequestDTO dto){
        return ResponseEntity.status(201).body(service.guardar(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable int id){
        return ResponseEntity.ok(service.buscar(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@PathVariable int id, @RequestBody PersonaRequestDTO dto){
        return ResponseEntity.ok(service.editar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable int id){
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
