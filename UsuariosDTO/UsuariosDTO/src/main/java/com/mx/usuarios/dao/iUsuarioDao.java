package com.mx.usuarios.dao;

import com.mx.usuarios.dominio.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface iUsuarioDao extends JpaRepository<Usuarios, Integer> {

    public Optional<Usuarios> findByUsernameIgnoreCase(String username);
}
