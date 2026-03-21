package com.example.computadora.dao;

import com.example.computadora.dominio.Computadoras;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sebas
 */

//Esta anotacion indica que es la responsable de la conexion en BD
@Repository
public interface IComputadorasDAO extends CrudRepository<Computadoras, Integer>{
    
}
