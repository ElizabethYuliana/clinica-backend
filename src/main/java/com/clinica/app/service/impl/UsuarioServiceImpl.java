package com.clinica.app.service.impl;

import com.clinica.app.entity.Usuario;
import com.clinica.app.repository.UsuarioRepository;
import com.clinica.app.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    @Override
    public void guardarOrUpdate(Usuario t) {
        usuarioRepository.save(t);
    }

    @Override
    public void eliminar(Integer id) {
        Usuario u = usuarioRepository.findById(id).get();
        usuarioRepository.delete(u);

    }

    @Override
    public Usuario findById(Integer id) {
        return usuarioRepository.findById(id).get();
    }
}
