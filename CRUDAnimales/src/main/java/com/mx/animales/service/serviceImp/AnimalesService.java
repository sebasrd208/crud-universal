package com.mx.animales.service.serviceImp;

import com.mx.animales.dao.iAnimalesDao;
import com.mx.animales.dominio.Animales;
import com.mx.animales.service.iAnimalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalesService implements iAnimalesService {

    @Autowired
    iAnimalesDao dao;

    @Override
    public Animales guardar(Animales a) {
        return dao.save(a);
    }

    @Override
    public Animales editar(Animales a) {
        return dao.save(a);
    }

    @Override
    public Animales buscar(int id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    public void eliminar(int id) {
        dao.deleteById(id);
    }

    @Override
    public List<Animales> listar() {
        return dao.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public Animales buscarPorNombre(String nombre) {
        return dao.findByNombreIgnoreCase(nombre);
    }

    public List<Animales> buscarPorTipo(String tipo){
        return dao.findByTipoIgnoreCase(tipo);
    }
}
