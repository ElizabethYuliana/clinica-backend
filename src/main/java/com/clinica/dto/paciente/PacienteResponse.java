package com.clinica.dto.paciente;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PacienteResponse {

    public Integer id;
    public String nombre;
    public Integer edad;
    public String apellidoPaterno;
    public String apellidoMaterno;
    public String celular;
    public String dni;
    @JsonInclude(JsonInclude.Include.ALWAYS)
    public String direccion;
    public String email;
    private Boolean estado;
}
