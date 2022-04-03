package com.clinica.dto.mapper;

import com.clinica.app.entity.Consulta;
import com.clinica.app.entity.Paciente;
import com.clinica.core.util.GenericUtil;
import com.clinica.dto.consulta.ConsultaRequest;
import com.clinica.dto.consulta.ConsultaResponse;
import com.clinica.dto.paciente.PacienteRequest;
import com.clinica.dto.paciente.PacienteResponse;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GenericMapper {


    //PACIENTE
    Paciente toPaciente(PacienteRequest pacienteRequest);

    @Mapping(source = "idPaciente", target = "id")
    @Named(value = "pacienteResponse")
    PacienteResponse toPacienteResponse(Paciente paciente);

    @IterableMapping(qualifiedByName = "pacienteResponse")
    List<PacienteResponse> toListPacienteResponse(List<Paciente> listPaciente);

    @Mappings({
            @Mapping(target = "edad", ignore = true),
            @Mapping(target = "celular", ignore = true),
            @Mapping(target = "email", ignore = true),
            @Mapping(target = "direccion", ignore = true),
            @Mapping(target = "estado", ignore = true)
    })
    PacienteResponse toPacienResponseCustomPaciente(Paciente paciente);

    //CONSULTA
    @Mapping(source="idPaciente", target = "paciente.idPaciente")
    Consulta toConsulta(ConsultaRequest consultaRequest);


    //source="origen", target="destino"
    @Mappings({
            @Mapping(source = "idConsulta", target="id"),
            @Mapping(source = "numeroConsultorio", target="numero"),
            @Mapping(source = "fechaConsulta", target="fecha"),
            @Mapping(source = "detalleConsulta", target="detalle"),
            @Mapping(target = "idPaciente", source="paciente.idPaciente"),
            @Mapping(target = "nombre", source="paciente.nombre"),
            @Mapping(target = "apellidoPaterno", source="paciente.apellidoPaterno"),
            @Mapping(target = "apellidoMaterno", source="paciente.apellidoMaterno"),
            @Mapping(target = "dni", source="paciente.dni"),
    })
    @Named(value = "consultaResponse")
    ConsultaResponse toConsultaResponse(Consulta consulta);

    @Mappings({
            @Mapping(source = "idConsulta", target="id"),
            @Mapping(source = "numeroConsultorio", target="numero"),
            @Mapping(source = "fechaConsulta", target="fecha"),
            @Mapping(source = "detalleConsulta", target="detalle"),
            @Mapping(target = "idPaciente", source="paciente.idPaciente", ignore = true),
            @Mapping(target = "nombre", source="paciente.nombre", ignore = true),
            @Mapping(target = "apellidoPaterno", source="paciente.apellidoPaterno", ignore = true),
            @Mapping(target = "apellidoMaterno", source="paciente.apellidoMaterno", ignore = true),
            @Mapping(target = "celular", source="paciente.celular"),
            @Mapping(target = "dni", source="paciente.dni"),
    })
    ConsultaResponse toConsultaResponseOne(Consulta consulta);

    @IterableMapping(qualifiedByName = "consultaResponse")
    List<ConsultaResponse> toListConsultaResponse(List<Consulta> consulta);

}
