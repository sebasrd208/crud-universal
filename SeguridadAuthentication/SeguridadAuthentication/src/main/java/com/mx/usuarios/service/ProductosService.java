package com.mx.usuarios.service;

import com.mx.usuarios.exception.RecursoNoEncontradoException;
import org.modelmapper.*;
import com.mx.usuarios.dto.*;
import com.mx.usuarios.dao.*;
import com.mx.usuarios.dominio.*;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;

import java.util.List;


@Service
public class ProductosService {

    @Autowired
    private iProductosDao dao;

    @Autowired
    private ModelMapper mapper;

    public List<ProductoResponseDTO> listar(){
        return dao.findAll().stream().map(p -> mapper.map(p, ProductoResponseDTO.class)).toList();
    }

    public ProductoResponseDTO guardar(ProductoRequestDTO dto) {
        Productos producto = mapper.map(dto, Productos.class);
        return mapper.map(dao.save(producto), ProductoResponseDTO.class);
    }

    public ProductoResponseDTO buscar(int id) {
        Productos producto = dao.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Producto no encontrado."));

        return mapper.map(producto, ProductoResponseDTO.class);
    }

    public void eliminar(int id) {
        if(!dao.existsById(id)) {
            throw new RecursoNoEncontradoException("Producto no encontrado.");
        }

        dao.deleteById(id);
    }


}
