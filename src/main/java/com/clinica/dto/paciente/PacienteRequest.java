package com.clinica.dto.paciente;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

@Getter
@Setter
@Schema(description = "Modelo Paciente")
public class PacienteRequest {

    public Integer idPaciente;

    @Schema(description = "Nombre del paciente", required = true, example = "Juan")
    @Size(min = 3, max = 100, message = "El nombre debe ser valido")
    public String nombre;

    @Schema(description = "Edad del paciente", required = true, example = "18")
    @Max(value = 100, message = "La edad debe ser valido")
    public Integer edad;

    @Schema(description = "Apellido Paterno del paciente", required = true, example = "Perez")
    @Size(min = 3, max = 100, message = "El apellido paterno ser valido")
    public String apellidoPaterno;

    @Schema(description = "Apellido Materno del paciente", required = true, example = "Samillan")
    @Size(min = 3, max = 100, message = "El apellido materno debe ser valido")
    public String apellidoMaterno;

    @Schema(description = "Celular", required = false, example = "912333221")
    @Size(min = 9, max = 9, message = "EL numero de celular debe ser valido")
    public String celular;

    @Schema(required = true, example = "7232323")
    @Size(min = 8, max = 8, message = "EL DNI debe ser valido")
    public String dni;

    @Schema(required = true, example = "Lima")
    @Size(min = 3, max = 100, message = "La direccion debe ser valido")
    public String direccion;

    @Schema(required = true, example = "correo@gmail.com")
    @Email(message = "El correo debe ser valido")
    public String email;

    @Schema( required = false, example = "TRUE")
    private Boolean estado;
}
