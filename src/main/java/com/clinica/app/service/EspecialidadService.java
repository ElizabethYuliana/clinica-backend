package com.clinica.app.service;

import com.clinica.app.entity.Especialidad;

import java.util.List;

public interface EspecialidadService {

    //Listar
    List<Especialidad> listar();

    //Guardar
    void guardarOrUpdate(Especialidad t);

    //Eliminar
    void eliminar(Integer id);

    //Buscar Uno
    Especialidad findById(Integer id);
}
