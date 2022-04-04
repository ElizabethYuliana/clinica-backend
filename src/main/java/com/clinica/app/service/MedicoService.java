package com.clinica.app.service;

import com.clinica.app.entity.Medico;

import java.util.List;

public interface MedicoService {

    //Listar
    List<Medico> listar();

    //Guardar
    void guardarOrUpdate(Medico t);

    //Eliminar
    void eliminar(Integer id);

    //Buscar Uno
    Medico findById(Integer id);
}
