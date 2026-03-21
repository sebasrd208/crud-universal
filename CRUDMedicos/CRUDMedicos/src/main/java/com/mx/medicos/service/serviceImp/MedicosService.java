package com.mx.medicos.service.serviceImp;

import com.mx.medicos.dao.iMerdicosDAO;
import com.mx.medicos.dominio.Medicos;
import com.mx.medicos.service.iMedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MedicosService implements iMedicoService {

    @Autowired
    iMerdicosDAO dao;

    @Override
    public Medicos guardar(Medicos m) {
        return dao.save(m);
    }

    @Override
    public Medicos editar(Medicos m) {
        return dao.save(m);
    }

    @Override
    public Medicos buscar(int id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    public void eliminar(int id) {
        dao.deleteById(id);
    }

    @Override
    public List<Medicos> listar() {
        return dao.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public Medicos buscarNombre(String nombre){
        return dao.findByNombreIgnoreCase(nombre);
    }

    public List<Medicos> buscarEspecialidad(String especialidad){
        return dao.buscarPorEspecialidad(especialidad);
    }
}
