package com.mx.usuarios.dao;

import java.util.*;
import com.mx.usuarios.dominio.*;
import org.springframework.data.jpa.repository.*;

public interface iUsuariosDao extends JpaRepository<Usuarios, Integer> {

    Optional<Usuarios> findByUsuario(String usuario);
}
