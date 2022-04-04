package com.clinica.app.controller;


import com.clinica.app.entity.Especialidad;
import com.clinica.app.service.EspecialidadService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/especialidad")
public class EspecialidadController {

    @Autowired
    EspecialidadService especialidadService;

    @GetMapping("/listar")
    public List<Especialidad> listar(){
        return especialidadService.listar();
    }

    @PostMapping("/guardar")
    public void guardar(@RequestBody Especialidad especialidad){
        especialidadService.guardarOrUpdate(especialidad);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable(name = "id")Integer id){
        especialidadService.eliminar(id);
    }

    @GetMapping("/buscar/{id}")
    public Especialidad buscarUno(@PathVariable(name = "id") Integer id){
        return especialidadService.findById(id);
    }


}
