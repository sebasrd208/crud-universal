package com.mx.personas.dao;

import com.mx.personas.dominio.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface iDireccionDao extends JpaRepository<Direccion, Integer> {

}
