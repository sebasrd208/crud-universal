package com.example.empleados.service;

import com.example.empleados.dao.iEmpleadosDAO;
import com.example.empleados.dominio.Empleados;
import com.example.empleados.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.*;

import java.util.List;

@Service
public class EmpleadosService implements iEmpleadosService{

    @Autowired
    private iEmpleadosDAO dao;

    @Override
    public Empleados guardar(Empleados e) {
        if(e.getId() == null) {
            throw new BusinessException("El ID no puede ser nulo.");
        }
        if(dao.existsById(e.getId())) {
            throw new BusinessException("Ese ID ya esta en uso, intenta con otro.");
        }

        if(e.getNombre() == null || e.getNombre().isBlank()) {
            throw new BusinessException("El nombre es un campo obligatorio.");
        }

        if(e.getSueldo() <= 0) {
            throw new BusinessException("El sueldo debe ser mayor a 0");
        }

        return dao.save(e);
    }

    @Override
    public Empleados editar(Empleados e) {
        if(!dao.existsById(e.getId())) {
            throw new BusinessException("No existe un empleado con ese ID.");
        }

        if(e.getNombre() == null || e.getNombre().isBlank()) {
            throw new BusinessException("El nombre es obligatorio.");
        }

        return dao.save(e);
    }

    @Override
    public void eliminar(Empleados e) {
        if(!dao.existsById(e.getId())) {
            throw new BusinessException("El empleado con ID: " + e.getId() + " no existe");
        }

        dao.delete(e);
    }

    @Override
    public Empleados buscar(int id) {
        return dao.findById(id)
                .orElseThrow(() -> new BusinessException("El empleado con ID: " + id + " no existe"));
    }

    @Override
    public List<Empleados> listar() {
        return dao.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public List<Empleados> buscarPorPuesto(String puesto){
        List<Empleados> lista = dao.findByPuesto(puesto);

        if(lista == null || lista.isEmpty()) {
            throw new BusinessException("No existe ningun empleado con el puesto de " + puesto);
        }

        return lista;
    }
}
