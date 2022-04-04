package com.clinica.app.service.impl;

import com.clinica.app.entity.Paciente;
import com.clinica.app.repository.PacienteRepository;
import com.clinica.app.service.PacienteService;
import com.clinica.core.common.BaseService;
import com.clinica.core.constants.Constantes;
import com.clinica.core.exception.http.NotFoundException;
import com.clinica.core.util.GenericUtil;
import com.clinica.dto.core.exception.BaseResponse;
import com.clinica.dto.paciente.PacienteRequest;
import com.clinica.dto.paciente.PacienteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@Service
@Qualifier("pacienteServiceImpl1")
public class PacienteServiceImpl extends BaseService implements PacienteService {

    @Autowired
    PacienteRepository pacienteRepository;

    @Override
    public BaseResponse<String> saveOrUpdate(@Valid PacienteRequest pacienteRequest) {
        Paciente paciente = genericMapper.toPaciente(pacienteRequest);
        paciente.setCreatedBy(Constantes.USER);
        paciente.setCreationDate(GenericUtil.getCurrentDate());
        paciente.setEstado(Boolean.TRUE);
        if (pacienteRequest.getIdPaciente() != null) {
            paciente.setModifiedBy(Constantes.USER);
            paciente.setModificationDate(GenericUtil.getCurrentDate());
        }
        pacienteRepository.save(paciente);
        return new BaseResponse(HttpStatus.CREATED.value(), "Operacion exitosa",
                "Guardado correctamente");
    }

    @Override
    public BaseResponse<List<PacienteResponse>> listar() {
        return new BaseResponse(HttpStatus.CREATED.value(), "Operacion exitosa",
                genericMapper.toListPacienteResponse(pacienteRepository.findAllActive()));
    }

    @Override
    public BaseResponse<PacienteResponse> find(Integer id) {
        return new BaseResponse(HttpStatus.CREATED.value(),
                "Operacion exitosa", genericMapper.toPacienteResponse(findPaciente(id)));
    }

    @Override
    public BaseResponse<PacienteResponse> findCustom(Integer id) {
        return new BaseResponse(HttpStatus.CREATED.value(),
                "Operacion exitosa", genericMapper.toPacienResponseCustomPaciente(findPaciente(id)));
    }

    @Override
    public BaseResponse<String> delete(Integer id) {
        Paciente paciente = findPaciente(id);
        if (paciente != null) {
            paciente.setEstado(Boolean.FALSE);
            pacienteRepository.save(paciente);
            return new BaseResponse(HttpStatus.CREATED.value(),
                    "Operacion exitosa", Constantes.MESSAGE_ELIMINADO_OK);
        }
        return new BaseResponse(HttpStatus.CREATED.value(),
                "Error al eliminar", Constantes.MESSAGE_ELIMINADO_ERROR.concat(id.toString()));

    }

    @Override
    public BaseResponse<List<PacienteResponse>> findByEdadBetween(Integer edadInical, Integer edadFinal) {
        List<Paciente> listaPaciente = pacienteRepository.findByEdadBetween(edadInical, edadFinal);
        return new BaseResponse(HttpStatus.CREATED.value(), "Operacion exitosa",
                genericMapper.toListPacienteResponse(listaPaciente));
    }

    @Override
    public List<Paciente> listaNativa() {
        return pacienteRepository.findAll();
    }

    private Paciente findPaciente(Integer id) {
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        return (paciente.isPresent()) ? paciente.get() : paciente.orElseThrow(
                () -> new NotFoundException("No se encuentra el paciente con id:" +id));
    }
}
