package com.example.empleados.controller;

import jakarta.validation.*;
import org.springframework.http.*;
import com.example.empleados.dto.*;
import com.example.empleados.service.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;

@RestController
@RequestMapping("empleados")
public class EmpleadosWS {

    @Autowired
    private EmpleadoService service;

    @GetMapping
    public ResponseEntity<?> listar(){
        return ResponseEntity.ok(service.listar());
    }

    @PostMapping
    public ResponseEntity<?> guardar(@Valid @RequestBody EmpleadoRequestDTO dto){
        return ResponseEntity.status(201).body(service.guardar(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable int id){
        return ResponseEntity.ok(service.buscar(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@PathVariable int id, @Valid @RequestBody EmpleadoRequestDTO dto){
        return ResponseEntity.ok(service.editar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable int id){
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
