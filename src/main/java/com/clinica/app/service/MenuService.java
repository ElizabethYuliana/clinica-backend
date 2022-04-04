package com.clinica.app.service;

import com.clinica.app.entity.Menu;

import java.util.List;

public interface MenuService {

    //Listar
    List<Menu> listar();

    //Guardar
    void guardarOrUpdate(Menu t);

    //Eliminar
    void eliminar(Integer id);

    //Buscar Uno
    Menu findById(Integer id);
}
