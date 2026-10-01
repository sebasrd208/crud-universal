package com.example.empleados.dao;

import com.example.empleados.dominio.Empleados;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface iEmpleadosDAO extends JpaRepository<Empleados, Integer> {

    public List<Empleados> findByPuesto(String puesto);
}
