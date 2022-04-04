package com.clinica.app.service;

import java.util.List;

public interface BaseEntityService<T> {

    //Listar
    List<T> listar();

    //Guardar
    void guardarOrUpdate(T t);

    //Eliminar
    void eliminar(Integer id);

    //Buscar Uno
    T findById(Integer id);
}
