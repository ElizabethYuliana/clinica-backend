package com.clinica.app.service;

import com.clinica.dto.core.exception.BaseResponse;
import com.clinica.dto.paciente.PacienteRequest;
import com.clinica.dto.paciente.PacienteResponse;

import java.util.List;
import java.util.Optional;

public interface PacienteService {

    BaseResponse<String> saveOrUpdate(PacienteRequest pacienteRequest);
    BaseResponse<List<PacienteResponse>> listar();
    BaseResponse<PacienteResponse> find(Integer id);
    BaseResponse<PacienteResponse> findCustom(Integer id);
    BaseResponse<String> delete(Integer id);
    BaseResponse<List<PacienteResponse>> findByEdadBetween(Integer edadInical, Integer edadFinal);
}
