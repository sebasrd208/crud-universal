package com.mx.habitaciones.controller;

import com.mx.habitaciones.dto.*;
import org.springframework.http.*;
import com.mx.habitaciones.service.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;

@RestController
@RequestMapping("habitaciones")
public class HabitacionesWS {

    @Autowired
    private HabitacionesService service;

    @GetMapping
    public ResponseEntity<?> listar(){
        return ResponseEntity.ok(service.listar());
    }

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody HabitacionRequestDTO dto){
        return ResponseEntity.status(201).body(service.guardar(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable int id){
        return ResponseEntity.ok(service.buscar(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@PathVariable int id, @RequestBody HabitacionRequestDTO dto){
        return ResponseEntity.ok(service.editar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable int id){
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
