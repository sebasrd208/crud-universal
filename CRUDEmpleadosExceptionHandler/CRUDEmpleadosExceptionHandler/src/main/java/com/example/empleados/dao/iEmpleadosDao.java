package com.example.empleados.dao;

import com.example.empleados.dominio.Empleados;
import org.springframework.data.jpa.repository.JpaRepository;

public interface iEmpleadosDao extends JpaRepository<Empleados, Integer> {

}
