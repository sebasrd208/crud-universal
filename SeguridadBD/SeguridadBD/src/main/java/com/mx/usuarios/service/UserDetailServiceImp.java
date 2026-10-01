package com.mx.usuarios.service;

import com.mx.usuarios.dao.*;
import com.mx.usuarios.dominio.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.userdetails.*;

@Service
public class UserDetailServiceImp implements UserDetailsService {

    @Autowired
    private iUsuariosDao dao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuarios usuario = dao.findByUsuario(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado."));

        return User.builder() //Contruir y devolver una implementacion de UserDetails
                .username(usuario.getUsuario()) //Asignamos el usuario al campo username de User
                .password(usuario.getPassword()) //Asignamos la contraseña al campo password de User
                .roles(usuario.getRol()) //Asignamos el Role del campo rol de User
                .build(); //Construye el objeto final y lo retorna.
    }
}
