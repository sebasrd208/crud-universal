package com.example.computadora.controller;

import java.util.*;
import com.example.computadora.dominio.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;

//Convierte la clase en un controlador de tipo REST
@RestController
//Define la ruta de acceso a la clase controladora
@RequestMapping(path = "/api/Compu")
public class ComputadoraWS {

    @Autowired
    private iComputadoraService service;

    /* URL: protocolo://host:puerto/Path
     * 
     * Path: RequestMapping/endpoint
     *
     * URL: protocolo://host:puerto/RequestMapping/endpoint
     *
     * URL: http://localhost:8001/api/Compu/listar
     *
     */
    //Anotacion que indica el tipo de metodo http que lo consume y define el endpoint del
    // metodo controlador
    @GetMapping(value = "listar")
    public List<Computadoras> listar() {
        return service.listar();
    }

    /* Serializacion: Java -> JSON
     * Descerializacion: JSON -> Java
     *
     * @RequestBody descerializa el cuerpo de la peticion (JSON) a un objeto Java
     */
    @PostMapping(value = "guardar")
    public Computadoras guardar(@RequestBody Computadoras compu) {
        return service.guardar(compu);
    }

    @PutMapping(value = "editar")
    public Computadoras editar(@RequestBody Computadoras compu) {
        return service.editar(compu);
    }

    //@PathVariable obtiene el valor directamente de la url en la peticion
    @GetMapping(value = "buscar/{id}")
    public Computadoras buscar(@PathVariable int id) {
        return service.buscar(id);
    }

    @DeleteMapping(value = "eliminar/{id}")
    public void eliminar(@PathVariable int id) {
        service.eliminar(id);
    }
}
