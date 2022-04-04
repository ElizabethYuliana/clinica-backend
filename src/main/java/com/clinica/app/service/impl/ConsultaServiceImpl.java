package com.clinica.app.service.impl;

import com.clinica.app.entity.Consulta;
import com.clinica.app.repository.ConsultaRepository;
import com.clinica.app.repository.PacienteRepository;
import com.clinica.app.service.ConsultaService;
import com.clinica.core.common.BaseService;
import com.clinica.core.constants.Constantes;
import com.clinica.core.util.GenericUtil;
import com.clinica.dto.consulta.ConsultaRequest;
import com.clinica.dto.consulta.ConsultaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultaServiceImpl extends BaseService implements ConsultaService {

    @Autowired
    ConsultaRepository consultaRepository;

    @Autowired
    PacienteRepository pacienteRepository;

    @Override
    public void saveOrUpdate(ConsultaRequest consultaRequest) {
        Consulta consulta = genericMapper.toConsulta(consultaRequest);
        consulta.setCreatedBy(Constantes.USER);
        consulta.setCreationDate(GenericUtil.getCurrentDate());
        consulta.setEstado(true);
        if (consultaRequest.getIdConsulta() != null) {
            consulta.setModifiedBy(Constantes.USER);
            consulta.setModificationDate(GenericUtil.getCurrentDate());
        }
        consultaRepository.save(consulta);
    }

    @Override
    public List<ConsultaResponse> listar() {
        return genericMapper.toListConsultaResponse(consultaRepository.listarConsultaActivo());
    }

    @Override
    public ConsultaResponse find(Integer id) {
        return genericMapper.toConsultaResponseOne(findByIdIsActive(id));
    }

    @Override
    public String delete(Integer id) {
        Consulta consulta = findByIdIsActive(id);
        if (consulta != null) {
            consulta.setEstado(false);
            consultaRepository.save(consulta);
            return Constantes.MESSAGE_ELIMINADO_OK;
        }
        return Constantes.MESSAGE_ELIMINADO_ERROR.concat(id.toString());
    }

    @Override
    public List<Consulta> consultaNativa() {
        return consultaRepository.findAll();
    }

    @Override
    public void guardar(Consulta consulta) {
        consultaRepository.save(consulta);
    }

    private Consulta findByIdIsActive(Integer id) {
        Optional<Consulta> optional = consultaRepository.findByIdConsultaAndAndEstadoIsTrue(id);
        return (optional.isPresent()) ? optional.get() : null;
    }
}
