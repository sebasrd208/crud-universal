package com.example.empleados.controller;

import java.util.*;

import com.example.empleados.exception.BusinessException;
import org.springframework.http.*;
import com.example.empleados.dominio.*;
import com.example.empleados.service.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;

@RestController
@RequestMapping("empleados")
public class EmpleadoWS {

    @Autowired
    private EmpleadosService service;

    @GetMapping("listar")
    public ResponseEntity<?> listar(){
        List<Empleados> lista = service.listar();

        if(lista == null || lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(lista);
    }

    @PostMapping("guardar")
    public ResponseEntity<?> guarda(@RequestBody Empleados e){
        try {
            Empleados emp = service.guardar(e);
            return ResponseEntity.ok(emp);
        }catch (BusinessException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @PutMapping("editar")
    public ResponseEntity<?> editar(@RequestBody Empleados e){
        try {
            return ResponseEntity.ok(service.editar(e));
        }catch (BusinessException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @DeleteMapping("eliminar")
    public ResponseEntity<?> eliminar(@RequestBody Empleados e){
        try {
            service.eliminar(e);
            return ResponseEntity.ok("El empleado se elimino con exito!");
        }catch (BusinessException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @GetMapping("buscar/{id}")
    public ResponseEntity<?> buscar(@PathVariable int id){
        try {
            return ResponseEntity.ok(service.buscar(id));
        } catch (BusinessException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @GetMapping("buscar-puesto/{puesto}")
    public ResponseEntity<?> buscarPorPuesto(@PathVariable String puesto){
        try {
            return ResponseEntity.ok(service.buscarPorPuesto(puesto));
        } catch (BusinessException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
}
