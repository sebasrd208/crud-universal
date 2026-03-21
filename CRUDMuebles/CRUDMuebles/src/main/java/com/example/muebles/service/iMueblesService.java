package com.example.muebles.service;

import com.example.muebles.dominio.Muebles;

import java.util.List;

public interface iMueblesService {

    public Muebles guardar(Muebles m);

    public Muebles editar(Muebles m);

    public Muebles buscar(int id);

    public void eliminar(int id);

    public List<Muebles> listar();
}
