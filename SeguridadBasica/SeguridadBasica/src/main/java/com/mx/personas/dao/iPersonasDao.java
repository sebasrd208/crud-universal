package com.mx.personas.dao;

import com.mx.personas.dominio.Personas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface iPersonasDao extends JpaRepository<Personas, Integer> {
}
