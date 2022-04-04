package com.clinica.app.controller;

import com.clinica.app.entity.Paciente;
import com.clinica.app.service.PacienteService;
import com.clinica.dto.core.exception.BaseResponse;
import com.clinica.dto.paciente.PacienteRequest;
import com.clinica.dto.paciente.PacienteResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "paciente")
@Api(value = "REST api para realizar operaciones a los pacientes")
public class PacienteController {

    @Autowired
    PacienteService pacienteService;

    @PostMapping("/save")
    public ResponseEntity<BaseResponse<String>> saveOrUpdate(@Valid @RequestBody PacienteRequest pacienteRequest) {
        return new ResponseEntity<>(pacienteService.saveOrUpdate(pacienteRequest), HttpStatus.CREATED);
    }

    @GetMapping("/findall")
    public BaseResponse<List<PacienteResponse>> listar() {
        return pacienteService.listar();
    }

    @ApiOperation(
            value = "${clinica-swagger.controller.find-by-id.descripcion}",
            notes = "${clinica-swagger.controller.find-by-id.notas}"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "BAD REQUEST"),
            @ApiResponse(code = 404, message = "NOT FOUND")
    })
    @GetMapping("/find/{id}")
    public BaseResponse<PacienteResponse> find(@PathVariable(name = "id") Integer id) {
        return pacienteService.find(id);
    }

    @DeleteMapping("/delete/{id}")
    public BaseResponse<String> delete(@PathVariable Integer id) {
        return pacienteService.delete(id);
    }

    @GetMapping("/edad-between")
    public BaseResponse<List<PacienteResponse>> findByEdadBetween(@RequestParam(name = "edadInicial") Integer edadInicial,
                                                   @RequestParam(name = "edadFinal") Integer edadFinal) {
        return pacienteService.findByEdadBetween(edadInicial, edadFinal);
    }

    @GetMapping("/find-custom/{id}")
    public  BaseResponse<PacienteResponse> findCustom(@PathVariable(name = "id") Integer id) {
        return pacienteService.findCustom(id);
    }

    @GetMapping("/lista-nativa")
    public List<Paciente> listaNativa() {
        return pacienteService.listaNativa();
    }

}
