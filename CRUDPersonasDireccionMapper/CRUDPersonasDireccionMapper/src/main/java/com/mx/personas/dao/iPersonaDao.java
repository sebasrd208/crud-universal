package com.mx.personas.dao;

import com.mx.personas.dominio.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface iPersonaDao extends JpaRepository<Persona, Integer> {


}
