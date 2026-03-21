package com.example.computadora.dominio;

import java.util.List;

/**
 *
 * @author sebas
 */
public interface iComputadoraService {

    public Computadoras guardar(Computadoras compu);
    
    public Computadoras editar(Computadoras compu);
    
    public Computadoras buscar(int id);
    
    public void eliminar(int id);
    
    public List<Computadoras> listar();
}
