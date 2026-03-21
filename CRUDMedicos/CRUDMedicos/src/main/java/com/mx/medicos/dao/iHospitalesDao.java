package com.mx.medicos.dao;

import com.mx.medicos.dominio.Hospitales;
import org.springframework.data.jpa.repository.JpaRepository;

public interface iHospitalesDao extends JpaRepository<Hospitales, Integer> {

    public Hospitales findByNombreIgnoreCase(String nombre);
}
