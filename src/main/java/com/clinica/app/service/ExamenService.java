package com.clinica.app.service;


import com.clinica.app.entity.Examen;

import java.util.List;

public interface ExamenService {

    //Listar
    List<Examen> listar();

    //Guardar
    void guardarOrUpdate(Examen t);

    //Eliminar
    void eliminar(Integer id);

    //Buscar Uno
    Examen findById(Integer id);
}
