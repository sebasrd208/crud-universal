package com.mx.medicos.service.serviceImp;

import com.mx.medicos.dao.iHospitalesDao;
import com.mx.medicos.dominio.Hospitales;
import com.mx.medicos.service.iHospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalService implements iHospitalService {

    @Autowired
    iHospitalesDao dao;

    @Override
    public Hospitales guardar(Hospitales h) {
        return dao.save(h);
    }

    @Override
    public Hospitales editar(Hospitales h) {
        return dao.save(h);
    }

    @Override
    public Hospitales buscar(int id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    public void eliminar(int id) {
        dao.deleteById(id);
    }

    @Override
    public List<Hospitales> listar() {
        return dao.findAll(Sort.by(Sort.Direction.DESC, "idHospital"));
    }

    public Hospitales buscarNombre(String nombre){
        return dao.findByNombreIgnoreCase(nombre);
    }
}
