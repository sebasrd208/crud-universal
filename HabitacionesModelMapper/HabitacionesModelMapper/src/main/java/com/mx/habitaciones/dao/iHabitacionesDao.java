package com.mx.habitaciones.dao;

import com.mx.habitaciones.dominio.Habitaciones;
import org.springframework.data.jpa.repository.JpaRepository;

public interface iHabitacionesDao extends JpaRepository<Habitaciones, Integer> {


}
