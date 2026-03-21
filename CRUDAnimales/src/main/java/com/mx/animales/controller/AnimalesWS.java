package com.mx.animales.controller;

import com.mx.animales.dominio.Animales;
import com.mx.animales.service.serviceImp.AnimalesService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Animales")
public class AnimalesWS {

    @Autowired
    private AnimalesService service;

    @GetMapping("listar")
    public List<Animales> listar(){
        return service.listar();
    }

    @PostMapping("guardar")
    public Animales guardar(@RequestBody Animales a) {
        return service.guardar(a);
    }

    @GetMapping("buscar/{id}")
    public Animales buscar(@PathVariable int id) {
        return service.buscar(id);
    }

    @PutMapping("editar")
    public Animales editar(@RequestBody Animales a) {
        return service.editar(a);
    }

    @DeleteMapping("eliminar/{id}")
    public void eliminar(@PathVariable int id) {
        service.eliminar(id);
    }

    @GetMapping("buscarPorNombre/{nombre}")
    public Animales buscarPorNombre(@PathVariable String nombre) {
        return service.buscarPorNombre(nombre);
    }

    @GetMapping("buscarPorTipo")
    public List<Animales> buscarPorTipo(@RequestParam String tipo){
        return service.buscarPorTipo(tipo);
    }
}
