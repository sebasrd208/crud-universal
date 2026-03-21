package com.mx.usuarios.service;

import com.mx.usuarios.dao.iUsuarioDao;
import com.mx.usuarios.dominio.Usuarios;
import com.mx.usuarios.dto.UsuarioRequestDTO;
import com.mx.usuarios.dto.UsuarioResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private iUsuarioDao dao;

    public List<UsuarioResponseDTO> listar() {
        List<Usuarios> usuarios = dao.findAll();

        return usuarios.stream()
                .map(usuario ->
                        new UsuarioResponseDTO(usuario.getUsername(), usuario.getCorreo(),
                                usuario.getFechaRegistro()))
                .collect(Collectors.toList());
    }

    public UsuarioResponseDTO guardar(UsuarioRequestDTO request) {
        //Creamos un objeto de tipo USUARIOS
        Usuarios nuevo = new Usuarios();

        //Asignar valores del usuario REQUEST al usuario NUEVO
        nuevo.setNombre(request.getNombre());
        nuevo.setUsername(request.getUsername());
        nuevo.setCorreo(request.getCorreo());
        nuevo.setPassword(request.getPassword());

        //Guardamos al usuario e la bd
        Usuarios guardado = dao.save(nuevo);

        return new UsuarioResponseDTO(guardado.getUsername(), guardado.getCorreo(), guardado.getFechaRegistro());
    }

    public UsuarioResponseDTO buscar(int id) {
        Usuarios usuario = dao.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado."));

        return new UsuarioResponseDTO(usuario.getUsername(), usuario.getCorreo(), usuario.getFechaRegistro());
    }

    public UsuarioResponseDTO editar(int id, UsuarioRequestDTO request) {
        Usuarios u = dao.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado."));

        u.setNombre(request.getNombre());
        u.setUsername(request.getUsername());
        u.setCorreo(request.getCorreo());
        u.setPassword(request.getPassword());

        Usuarios actualizado = dao.save(u);

        return new UsuarioResponseDTO(actualizado.getUsername(), actualizado.getCorreo(), actualizado.getFechaRegistro());
    }

    public void eliminar(int id) {
        if(!dao.existsById(id)) {
            throw new RuntimeException("Usuario no encontrado.");
        }

        dao.deleteById(id);
    }

    public UsuarioResponseDTO buscarPorUsername(String username) {

        Usuarios usuario = dao.findByUsernameIgnoreCase(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado."));

        return new UsuarioResponseDTO(usuario.getUsername(), usuario.getCorreo(), usuario.getFechaRegistro());
    }
}
