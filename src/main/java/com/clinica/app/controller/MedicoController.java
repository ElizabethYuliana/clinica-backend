package com.clinica.app.controller;


import com.clinica.app.entity.Medico;
import com.clinica.app.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/medico")
public class MedicoController {

    @Autowired
    MedicoService medicoService;

    @GetMapping("/listar")
    public List<Medico> listarMedico(){
        return medicoService.listar();
    }

    @GetMapping("/buscar/{id}")
    public Medico buscarUno(@PathVariable(name = "id") Integer id){
        return medicoService.findById(id);
    }

    @PostMapping("/guardar")
    public void guardar(@RequestBody Medico medico){
        medicoService.guardarOrUpdate(medico);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable(name = "id") Integer id ){
        medicoService.eliminar(id);
    }




}
