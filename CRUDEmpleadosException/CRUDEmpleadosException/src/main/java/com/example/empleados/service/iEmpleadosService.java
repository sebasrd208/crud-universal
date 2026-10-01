package com.example.empleados.service;

import com.example.empleados.dominio.Empleados;

import java.util.List;

public interface iEmpleadosService {

    public Empleados guardar(Empleados e);

    public Empleados editar(Empleados e);

    public void eliminar(Empleados e);

    public Empleados buscar(int id);

    public List<Empleados> listar();
}
