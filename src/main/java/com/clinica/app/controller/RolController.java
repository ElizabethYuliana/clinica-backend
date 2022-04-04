package com.clinica.app.controller;

import com.clinica.app.entity.Rol;
import com.clinica.app.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/rol")
public class RolController {

    @Autowired
    RolService rolService;

    @GetMapping("/listar")
    public List<Rol> listar(){
        return rolService.listar();
    }

    @PostMapping("/guardar")
    public void guardar(@RequestBody Rol rol){
        rolService.guardarOrUpdate(rol);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable(name = "id") Integer id){
        rolService.eliminar(id);
    }

    @GetMapping("/buscar/{id}")
    public Rol buscarUno(@PathVariable(name = "id") Integer id){
        return rolService.findById(id);
    }
}
