package com.mx.habitaciones.service;

import java.util.*;

import com.mx.habitaciones.dominio.Habitaciones;
import org.modelmapper.*;
import com.mx.habitaciones.dao.*;
import com.mx.habitaciones.dto.*;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;

@Service
public class HabitacionesService {

    @Autowired
    private iHabitacionesDao dao;

    @Autowired
    private ModelMapper mapper;

    public List<HabitacionResponseDTO> listar(){
        /* dao.findAll() devuelve la lista de entidades
         * stream() convierte la lista en un flujo de datos
         * .map() transformar cada uno de los elementos del stream en otro objeto
         * lambda: Para cada uno de los objetos de tipo Habitaciones conviertelo en una instancia de
         * HabitacionResponseDTO.
         * toList convierte el stream previamente procesado en una lista nuevamente.
         */

        return dao.findAll().stream().map(h -> mapper.map(h, HabitacionResponseDTO.class)).toList();
    }

    public HabitacionResponseDTO guardar(HabitacionRequestDTO dto) {
        Habitaciones entity = mapper.map(dto, Habitaciones.class);
        entity.setDisponible(true);
        Habitaciones guardado = dao.save(entity);
        return mapper.map(guardado, HabitacionResponseDTO.class);
    }

    public HabitacionResponseDTO buscar(int id) {
        Habitaciones h = dao.findById(id)
                .orElseThrow(() -> new RuntimeException("Habitacion no encontrada."));

        return mapper.map(h, HabitacionResponseDTO.class);
    }

    public HabitacionResponseDTO editar(int id, HabitacionRequestDTO dto) {
        Habitaciones h = dao.findById(id)
                .orElseThrow(() -> new RuntimeException("Habitacion no encontrada."));

        h.setNumero(dto.getNumero());
        h.setTipo(dto.getTipo());
        h.setPrecio(dto.getPrecio());

        Habitaciones update = dao.save(h);
        return mapper.map(update, HabitacionResponseDTO.class);
    }

    public void eliminar(int id) {
        Habitaciones h = dao.findById(id)
                .orElseThrow(() -> new RuntimeException("Habitacion no encontrada."));
        dao.delete(h);
    }
}
