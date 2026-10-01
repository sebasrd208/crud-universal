package com.mx.usuarios.service;

import com.mx.usuarios.dao.*;
import com.mx.usuarios.dominio.*;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.crypto.password.*;

@Service
public class UsuariosService {

    @Autowired
    private iUsuariosDao dao;

    @Autowired
    private PasswordEncoder password;
    //Clase de Spring Security encargada de encriptar contraseñas y compararlas

    public Usuarios registro(Usuarios usuario) {
        String passwordEncriptado = password.encode(usuario.getPassword());
        usuario.setPassword(passwordEncriptado);
        return dao.save(usuario);
    }


}
