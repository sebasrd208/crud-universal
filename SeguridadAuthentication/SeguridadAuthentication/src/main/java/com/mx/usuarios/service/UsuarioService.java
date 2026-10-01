package com.mx.usuarios.service;

import com.mx.usuarios.dao.iUsuariosDao;
import com.mx.usuarios.dominio.Usuarios;
import com.mx.usuarios.dto.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private iUsuariosDao dao;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UsuarioResponseDTO registrar(UsuarioRequestDTO dto){
        Usuarios usuario= mapper.map(dto, Usuarios.class);
        usuario.setPassword(passwordEncoder.encode(dto.getPassword()));
        return mapper.map(dao.save(usuario), UsuarioResponseDTO.class);
    }

}
