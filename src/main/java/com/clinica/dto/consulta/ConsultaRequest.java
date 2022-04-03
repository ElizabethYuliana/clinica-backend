package com.clinica.dto.consulta;

import com.clinica.app.entity.Paciente;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ConsultaRequest {

    private Integer idConsulta;

    private String numeroConsultorio;

    private LocalDateTime fechaConsulta;

    private String detalleConsulta;

    private Integer idPaciente;




}
