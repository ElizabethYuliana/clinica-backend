package com.clinica.app.controller;

import com.clinica.app.entity.Menu;
import com.clinica.app.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    MenuService menuService;

    @GetMapping("/listar")
    public List<Menu> listar(){
        return menuService.listar();
    }

    @PostMapping("/guardar")
    public void guardar(@RequestBody Menu menu){
        menuService.guardarOrUpdate(menu);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable(name = "id") Integer id){
        menuService.eliminar(id);
    }

    @GetMapping("/buscar/{id}")
    public Menu buscarUno(@PathVariable(name = "id") Integer id){
        return menuService.findById(id);
    }
}
