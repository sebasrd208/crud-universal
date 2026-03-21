package com.mx.medicos.controller;

import com.mx.medicos.dominio.*;
import org.springframework.http.*;
import com.mx.medicos.service.serviceImp.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;

@RestController
@RequestMapping("hospitales")
public class HospitalesWS {

    @Autowired
    HospitalService service;

    @GetMapping("listar")
    public ResponseEntity<?> listar(){
        return ResponseEntity.status(HttpStatus.OK).body(service.listar());
    }

    @PostMapping("guardar")
    public ResponseEntity<?> guardar(@RequestBody Hospitales h){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(h));
    }

    @GetMapping("buscar/{id}")
    public ResponseEntity<?> buscar(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscar(id));
    }

    @PutMapping("editar")
    public ResponseEntity<?> editar(@RequestBody Hospitales h){
        return ResponseEntity.status(HttpStatus.OK).body(service.editar(h));
    }

    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable int id){
        service.eliminar(id);
        return ResponseEntity.status(HttpStatus.OK).body("Eliminacion exitosa!");
    }

    @GetMapping("buscar-nombre/{nombre}")
    public ResponseEntity<?> buscarPorNombre(@PathVariable String nombre){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarNombre(nombre));
    }
}
