package com.mx.animales.dao;

import com.mx.animales.dominio.Animales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface iAnimalesDao extends JpaRepository<Animales, Integer> {

    /*Estos metodos pertenecen a Spring Data JPA. Son query methods que generan
     * una consulta automatica directamente la bd a partir del nombre del metodo.*/

    //SELECT * FROM ANIMALES WHERE NOMBRE = nombre;
    public Animales findByNombreIgnoreCase(String nombre);

    //SELECT * FROM ANIMALES WHERE TIPO = tipo;
    public List<Animales> findByTipoIgnoreCase(String tipo);
}
