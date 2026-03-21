package com.mx.medicos.service;

import com.mx.medicos.dominio.*;
import java.util.*;

public interface iMedicoService {

    public Medicos guardar(Medicos m);

    public Medicos editar(Medicos m);

    public Medicos buscar(int id);

    public void eliminar(int id);

    public List<Medicos> listar();
}
