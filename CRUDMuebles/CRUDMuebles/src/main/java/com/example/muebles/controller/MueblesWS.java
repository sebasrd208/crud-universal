package com.example.muebles.controller;

import com.example.muebles.dominio.Muebles;
import com.example.muebles.service.serviceImp.MueblesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("muebles")
public class MueblesWS {

    @Autowired
    MueblesService service;

    /*
     * ResponseEntity es una clase que representa toda la
     * repuesta HTTP completa, es decir: cabecera, cuerpo y estatus.
     *
     */

    @GetMapping("listar")
    public ResponseEntity<List<Muebles>> listar(){
        List<Muebles> lista = service.listar();

        if(lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }else {
            return ResponseEntity.status(HttpStatus.OK).body(lista);
        }
    }

    @PostMapping("guardar")
    public ResponseEntity<?> guardar(@RequestBody Muebles m){
        Muebles aux = service.buscar(m.getId());

        if (aux == null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(m));
        }else {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Error: Ese ID ya existe, intenta con otro.");
        }
    }

    @PutMapping("editar")
    public ResponseEntity<?> editar(@RequestBody Muebles m){
        Muebles aux = service.buscar(m.getId());

        if (aux != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(service.editar(m));
        }else {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Error: Ese ID no existe, intenta con otro.");
        }
    }

    @GetMapping("buscar/{id}")
    public ResponseEntity<Muebles> buscar(@PathVariable int id){
        Muebles aux = service.buscar(id);

        if(aux == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }else {
            return ResponseEntity.status(HttpStatus.OK).body(aux);
        }
    }

    @GetMapping("buscar-tipo/{tipo}")
    public ResponseEntity<Muebles> buscarPorTipo(@PathVariable String tipo){
        Muebles aux = service.buscarPorTipo(tipo);

        if(aux == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }else {
            return ResponseEntity.status(HttpStatus.OK).body(aux);
        }
    }

    @GetMapping("buscar-area")
    public ResponseEntity<List<Muebles>> buscarPorArea(@RequestParam String area){
        List<Muebles> lista = service.buscarPorArea(area);

        if(lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }else {
            return ResponseEntity.status(HttpStatus.OK).body(lista);
        }
    }
}
