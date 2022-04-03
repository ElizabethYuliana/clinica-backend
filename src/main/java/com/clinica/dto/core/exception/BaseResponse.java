package com.clinica.dto.core.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BaseResponse<T> {

    private Integer codigoEstado;
    private String mensaje;
    private T response;
}
