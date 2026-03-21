package com.example.muebles.dao;

import com.example.muebles.dominio.Muebles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface iMueblesDao extends JpaRepository<Muebles, Integer> {

    public Muebles findByTipoIgnoreCase(String tipo);

    public List<Muebles> findByAreaIgnoreCase(String marca);

}
