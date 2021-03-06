package com.clinica.app.service;

import com.clinica.app.entity.Consulta;
import com.clinica.dto.consulta.ConsultaRequest;
import com.clinica.dto.consulta.ConsultaResponse;

import java.util.List;

public interface ConsultaService {

    void saveOrUpdate(ConsultaRequest consulta);
    List<ConsultaResponse> listar();
    ConsultaResponse find(Integer id);
    String delete(Integer id);
    List<Consulta> consultaNativa();
    void guardar(Consulta consulta);

    //DTO
//    List<ConsultaResponse> listarDTOMapStream();
//    List<ConsultaResponseLombok> listarDTOLombok();
//    List<ConsultaResponseModelMapper> listarDTOModelMapper();
//    ConsultaResponseModelMapper findModelMopper(Integer id);
}
