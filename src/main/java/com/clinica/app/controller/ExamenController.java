package com.clinica.app.controller;

import com.clinica.app.entity.Examen;
import com.clinica.app.service.ExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/examen")
public class ExamenController {

    @Autowired
    ExamenService examenService;

    @GetMapping("/listar")
    public List<Examen> listar(){
        return examenService.listar();
    }

    @PostMapping("/guardar")
    public void guardar(@RequestBody Examen examen){
        examenService.guardarOrUpdate(examen);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable(name = "id") Integer id){
        examenService.eliminar(id);
    }

    @GetMapping("/buscar/{id}")
    public Examen buscarUno(@PathVariable(name = "id") Integer id){
        return examenService.findById(id);
    }

}
