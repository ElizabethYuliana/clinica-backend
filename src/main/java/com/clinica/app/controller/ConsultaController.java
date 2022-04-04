package com.clinica.app.controller;

import com.clinica.app.entity.Consulta;
import com.clinica.app.service.ConsultaService;
import com.clinica.dto.consulta.ConsultaRequest;
import com.clinica.dto.consulta.ConsultaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/consulta")
public class ConsultaController {

    @Autowired
    ConsultaService consultaService;

    @PostMapping("/save")
    public void saveOrUpdate(@RequestBody ConsultaRequest consultaRequest) {
        consultaService.saveOrUpdate(consultaRequest);
    }

    @GetMapping("/findall")
    public List<ConsultaResponse> listar() {
        return consultaService.listar();
    }

    @GetMapping("/find/{id}")
    public ConsultaResponse find(@PathVariable(name = "id") Integer id) {
        return consultaService.find(id);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") Integer id) {
        return consultaService.delete(id);
    }

    @GetMapping("/lista-nativa")
    public List<Consulta> listaNativa() {
        return consultaService.consultaNativa();
    }

    @PostMapping("/save-nativo")
    public void saveNativo(@RequestBody Consulta consultaRequest) {
        consultaService.guardar(consultaRequest);
    }

    // DTO
//    @GetMapping("/findall-1")
//    public List<ConsultaResponse> listarDTOMapStream() {
//        return consultaService.listarDTOMapStream();
//    }
//
//    @GetMapping("/findall-2")
//    public List<ConsultaResponseLombok> listarDTOLombok() {
//        return consultaService.listarDTOLombok();
//    }
//
//    @GetMapping("/findall-3")
//    public List<ConsultaResponseModelMapper> listarDTOModelMapper() {
//        return consultaService.listarDTOModelMapper();
//    }
//
//    @GetMapping("/find2/{id}")
//    ConsultaResponseModelMapper findModelMopper(@PathVariable(name = "id") Integer id){
//        return consultaService.findModelMopper(id);
//    }
}
