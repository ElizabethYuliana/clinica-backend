package com.clinica.app.service;

import com.clinica.app.entity.Medico;
import com.clinica.app.entity.Usuario;

import java.util.List;

public interface UsuarioService {

    //Listar
    List<Usuario> listar();

    //Guardar
    void guardarOrUpdate(Usuario t);

    //Eliminar
    void eliminar(Integer id);

    //Buscar Uno
    Usuario findById(Integer id);
}
