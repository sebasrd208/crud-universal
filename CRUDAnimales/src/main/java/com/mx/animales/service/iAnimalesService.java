package com.mx.animales.service;

import com.mx.animales.dominio.*;
import java.util.*;

public interface iAnimalesService {

    public Animales guardar(Animales a);

    public Animales editar(Animales a);

    public Animales buscar(int id);

    public void eliminar(int id);

    public List<Animales> listar();
}
