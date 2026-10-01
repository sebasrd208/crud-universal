package com.example.empleados.service;

import java.util.*;
import org.modelmapper.*;
import com.example.empleados.dao.*;
import com.example.empleados.dto.*;
import com.example.empleados.dominio.*;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;

@Service
public class EmpleadoService {

    @Autowired
    private iEmpleadosDao dao;

    @Autowired
    private ModelMapper mapper;

    public List<EmpleadoResponseDTO> listar(){
        return dao.findAll().stream().map(emp -> mapper.map(emp, EmpleadoResponseDTO.class)).toList();
    }

    public EmpleadoResponseDTO guardar(EmpleadoRequestDTO dto) {
        Empleados emp = mapper.map(dto, Empleados.class);
        return mapper.map(dao.save(emp), EmpleadoResponseDTO.class);
    }

    public EmpleadoResponseDTO buscar(int id) {
        Empleados emp = dao.findById(id)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado con el id: " + id));

        return mapper.map(emp, EmpleadoResponseDTO.class);
    }

    public EmpleadoResponseDTO editar(int id, EmpleadoRequestDTO dto) {
        Empleados existente = dao.findById(id)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado con el id: " + id));

        existente.setNombre(dto.getNombre());
        existente.setCorreo(dto.getCorreo());
        existente.setPuesto(dto.getPuesto());
        existente.setEdad(dto.getEdad());

        return mapper.map(dao.save(existente), EmpleadoResponseDTO.class);
    }

    public void eliminar(int id) {
        Empleados emp = dao.findById(id)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado con el id: " + id));

        dao.delete(emp);
    }
}
