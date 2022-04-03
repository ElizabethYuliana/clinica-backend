package com.clinica.dto.consulta;

import com.clinica.app.entity.Paciente;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import net.bytebuddy.agent.builder.AgentBuilder;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConsultaResponse {

    private Integer id;

    private String numero;

    private String fecha;

    private String detalle;

    public Integer idPaciente;

    public String nombre;

    public String apellidoPaterno;

    public String apellidoMaterno;

    public String celular;

    public String dni;


}
