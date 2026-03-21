package com.example.muebles.service.serviceImp;

import com.example.muebles.dao.*;
import com.example.muebles.dominio.*;
import com.example.muebles.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.*;

import java.util.List;

@Service
public class MueblesService implements iMueblesService {

    @Autowired
    iMueblesDao dao;

    @Override
    public Muebles guardar(Muebles m) {
        return dao.save(m);
    }

    @Override
    public Muebles editar(Muebles m) {
        return dao.save(m);
    }

    @Override
    public Muebles buscar(int id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    public void eliminar(int id) {
        dao.deleteById(id);
    }

    @Override
    public List<Muebles> listar() {
        return dao.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    public Muebles buscarPorTipo(String tipo) {
        return dao.findByTipoIgnoreCase(tipo);
    }

    public List<Muebles> buscarPorArea(String area){
        return dao.findByAreaIgnoreCase(area);
    }
}
