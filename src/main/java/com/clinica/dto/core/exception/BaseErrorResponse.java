package com.clinica.dto.core.exception;

import com.clinica.core.util.GenericUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseErrorResponse {

    @JsonFormat(pattern = "dd/mm/yyyy hh:mm:ss")
    private String fecha;
    private Integer codigoEstado;
    private String mensajeUsuario;
    private List<String> detalles;
    private String mensajeTecnico;


    public String getFecha() {
        return GenericUtil.formaDate(LocalDateTime.now(), "dd/mm/yyyy hh:mm:ss");
    }

    public BaseErrorResponse(Integer codigoEstado, String mensajeUsuario, String mensajeTecnico, List<String> detalles) {
        this.codigoEstado = codigoEstado;
        this.mensajeUsuario = mensajeUsuario;
        this.mensajeTecnico = mensajeTecnico;
        this.detalles = detalles;
    }
}
