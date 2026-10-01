package com.mx.personas.service;

import java.util.*;
import com.mx.personas.dao.*;
import com.mx.personas.dominio.*;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;

@Service
public class PersonasService {

    @Autowired
    private iPersonasDao dao;

    public void guardar(Personas p){
        dao.save(p);
    }

    public void editar(Personas p) {
        dao.save(p);
    }

    public void eliminar(int id) {
        dao.deleteById(id);
    }

    public Personas buscar(int id) {
        return dao.findById(id).orElse(null);
    }

    public List<Personas> listar(){
        return dao.findAll();
    }
}
