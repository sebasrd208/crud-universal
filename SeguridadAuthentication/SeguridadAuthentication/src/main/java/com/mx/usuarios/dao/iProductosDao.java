package com.mx.usuarios.dao;

import com.mx.usuarios.dominio.Productos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface iProductosDao extends JpaRepository<Productos, Integer> {

}
