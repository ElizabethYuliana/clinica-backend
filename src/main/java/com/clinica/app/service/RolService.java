package com.clinica.app.service;

import com.clinica.app.entity.Medico;
import com.clinica.app.entity.Rol;

import java.util.List;

public interface RolService {

    //Listar
    List<Rol> listar();

    //Guardar
    void guardarOrUpdate(Rol t);

    //Eliminar
    void eliminar(Integer id);

    //Buscar Uno
    Rol findById(Integer id);
}
