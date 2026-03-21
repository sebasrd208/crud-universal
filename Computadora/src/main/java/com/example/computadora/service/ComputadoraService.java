package com.example.computadora.service;

import com.example.computadora.dao.IComputadorasDAO;
import com.example.computadora.dominio.Computadoras;
import com.example.computadora.dominio.iComputadoraService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sebas
 */
//Indica que esta clase contiene toda la logica de negocio del sistema
@Service
public class ComputadoraService implements iComputadoraService {

    //Inyectar el repositorio/Dao en el servidor
    @Autowired
    public IComputadorasDAO dao;

    @Override
    public Computadoras guardar(Computadoras compu) {
        return dao.save(compu);
    }

    @Override
    public Computadoras editar(Computadoras compu) {
        return dao.save(compu);
    }

    @Override
    public Computadoras buscar(int id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    public void eliminar(int id) {
        dao.deleteById(id);
    }

    @Override
    public List<Computadoras> listar() {
        List<Computadoras> lista = (List<Computadoras>) dao.findAll();
        
        lista = lista.stream()
                .sorted((c1, c2) -> Integer.compare(c1.getId(), c2.getId()))
                .collect(Collectors.toList());

        return lista;
    }

}
