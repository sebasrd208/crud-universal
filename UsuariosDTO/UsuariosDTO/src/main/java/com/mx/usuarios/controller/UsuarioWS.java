package com.mx.usuarios.controller;

import java.util.*;
import com.mx.usuarios.dto.*;
import com.mx.usuarios.service.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;

@RestController
@RequestMapping("usuarios")
public class UsuarioWS {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> listarUsuarios(){
        return ResponseEntity.ok(service.listar());
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> guardarUsuario(@RequestBody UsuarioRequestDTO request){
        return ResponseEntity.status(201).body(service.guardar(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> buscar(@PathVariable int id){
        return ResponseEntity.ok(service.buscar(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> editar(
            @PathVariable int id,
            @RequestBody UsuarioRequestDTO request){
        return ResponseEntity.ok(service.editar(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id){
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("buscar-username/{username}")
    public ResponseEntity<UsuarioResponseDTO> buscarPorUsername(@PathVariable String username){
        return ResponseEntity.ok(service.buscarPorUsername(username));
    }
}
