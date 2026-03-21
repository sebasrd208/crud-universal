package com.mx.medicos.dao;

import com.mx.medicos.dominio.Medicos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface iMerdicosDAO extends JpaRepository<Medicos, Integer> {

    public Medicos findByNombreIgnoreCase(String nombre);

    @Query(value = "SELECT * FROM MEDICOS WHERE UPPER(ESPECIALIDAD) = UPPER(:especialidad)", nativeQuery = true)
    public List<Medicos> buscarPorEspecialidad(String especialidad);

    /* @Query es una anotacion que se usa para escribir consultas complejas con SQL
     * nativo y sirve cuando no puedes expresar la consulta con el nombre del metodo o
     * cuando necesitas control total sobre la consulta.
     *
     */
}
