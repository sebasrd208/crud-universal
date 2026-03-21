package com.mx.personas.service;

import java.util.*;
import org.modelmapper.*;
import com.mx.personas.dto.*;
import com.mx.personas.dao.*;
import com.mx.personas.dominio.*;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;

@Service
public class PersonaService {

    @Autowired
    private iPersonaDao dao;

    @Autowired
    private ModelMapper mapper;

    public List<PersonaResponseDTO> listar(){
        return dao.findAll().stream().map(p -> mapper.map(p, PersonaResponseDTO.class)).toList();
    }

    public PersonaResponseDTO guardar(PersonaRequestDTO dto) {
        Persona persona = mapper.map(dto, Persona.class);
        Persona guardado = dao.save(persona);

        return mapper.map(guardado, PersonaResponseDTO.class);
    }

    public PersonaResponseDTO buscar(int id) {
        Persona p = dao.findById(id).orElseThrow();
        return mapper.map(p, PersonaResponseDTO.class);
    }

    public PersonaResponseDTO editar(int id, PersonaRequestDTO dto) {
        Persona p = dao.findById(id).orElseThrow();
        p.setNombre(dto.getNombre());
        p.setEdad(dto.getEdad());
        //Edicion anidada
        Direccion d = p.getDireccion();
        d.setCalle(dto.getDireccion().getCalle());
        d.setNumero(dto.getDireccion().getNumero());
        d.setColonia(dto.getDireccion().getColonia());

        Persona actualizado = dao.save(p);
        return mapper.map(actualizado, PersonaResponseDTO.class);
    }

    public void eliminar(int id) {
        Persona p = dao.findById(id).orElseThrow();
        dao.delete(p);
    }
}
