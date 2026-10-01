package com.example.empleados.service;

import com.example.empleados.dominio.*;
import com.example.empleados.dto.*;
import com.example.empleados.exception.*;
import org.modelmapper.*;
import com.example.empleados.dao.*;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;

import java.util.*;

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

        if(dao.existsById(emp.getId())) {
            throw new EmpleadoDuplicadoException("Ese ID ya esta en uso, intenta con otro.");
        }

        if(emp.getSueldo() > 10000) {
            throw new EmpleadoValidationException("El sueldo no debe pasar los 10000 quincenales.");
        }

        return mapper.map(dao.save(emp), EmpleadoResponseDTO.class);
    }

    public EmpleadoResponseDTO buscar(int id) {
        Empleados emp = dao.findById(id)
                .orElseThrow(() ->
                        new EmpleadoNotFoundException("Empleado no encontrado con el id: " + id));

        return mapper.map(emp, EmpleadoResponseDTO.class);
    }

    public EmpleadoResponseDTO editar(int id, EmpleadoRequestDTO dto) {
        Empleados emp = dao.findById(id)
                .orElseThrow(() ->
                        new EmpleadoNotFoundException("Empleado no encontrado con el id:" + id));

        if(dto.getSueldo() > 10000) {
            throw new EmpleadoValidationException("El sueldo no debe pasar los 10000 quincenales.");
        }

        emp.setNombre(dto.getNombre());
        emp.setPuesto(dto.getPuesto());
        emp.setSueldo(dto.getSueldo());

        return mapper.map(emp, EmpleadoResponseDTO.class);
    }

    public void eliminar(int id) {
        if(!dao.existsById(id)) {
            throw new EmpleadoNotFoundException("Empleado no encontrado con el id: " + id);
        }
        dao.deleteById(id);
    }


}
