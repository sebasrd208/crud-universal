package com.mx.medicos.service;

import com.mx.medicos.dominio.*;
import java.util.*;

public interface iHospitalService {

    Hospitales guardar(Hospitales h);

    Hospitales editar(Hospitales h);

    Hospitales buscar(int id);

    void eliminar(int id);

    List<Hospitales> listar();
}
