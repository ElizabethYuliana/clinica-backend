package com.clinica.app.service.impl;

import com.clinica.app.entity.Menu;
import com.clinica.app.repository.MenuRepository;
import com.clinica.app.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    MenuRepository menuRepository;

    @Override
    public List<Menu> listar() {
        return menuRepository.findAll();
    }

    @Override
    public void guardarOrUpdate(Menu t) {
            menuRepository.save(t);
    }

    @Override
    public void eliminar(Integer id) {
        Menu m = menuRepository.findById(id).get();
        menuRepository.delete(m);
    }

    @Override
    public Menu findById(Integer id) {
        return menuRepository.findById(id).get();
    }
}
