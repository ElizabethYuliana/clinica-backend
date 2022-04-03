package com.clinica.core.exception.global;

import com.clinica.core.exception.http.NotFoundException;
import com.clinica.dto.core.exception.BaseErrorResponse;
import com.clinica.dto.core.exception.BaseExceptionResponse;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


// Version anterior
//@ControllerAdvice
//@RestController
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<BaseErrorResponse> handleAllException(Exception ex, WebRequest request) {
        List<String> listaErrores = new ArrayList<>();
        listaErrores.add(ex.getLocalizedMessage());
        BaseErrorResponse baseErrorResponse = new BaseErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error de servidor",
                ex.getCause().toString(), listaErrores);

        return new ResponseEntity<>(baseErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }



    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<BaseErrorResponse> notFoundException(NotFoundException ex , ServletWebRequest request) {
        BaseErrorResponse baseErrorResponse = new BaseErrorResponse();

        System.out.println(request.getHeaderNames());
        System.out.println(request.getContextPath());
        System.out.println(request.getRequest().getRequestURI());
        System.out.println(request.getHeader("User-Agent"));
        System.out.println(request.getHeader("jorge"));
        request.getHeaderNames().forEachRemaining(System.out::println);
        System.out.println(request.getRemoteUser());

//        baseErrorResponse.setFecha(LocalDateTime.now());
        baseErrorResponse.setCodigoEstado(HttpStatus.NOT_FOUND.value());
        baseErrorResponse.setMensajeUsuario(ex.getMessage());
        baseErrorResponse.setMensajeTecnico("Error en el metodo findPaciente()");
//        baseErrorResponse.setMensajeTecnico("");


//        return new ResponseEntity<>(baseErrorResponse, HttpStatus.NOT_FOUND);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).header("Test", "1234")
                .body(baseErrorResponse);
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<BaseErrorResponse> conflict(SQLException ex) {
        BaseErrorResponse baseExceptionResponse = new BaseErrorResponse();
        baseExceptionResponse.setCodigoEstado(HttpStatus.CONFLICT.value());
        baseExceptionResponse.setMensajeUsuario("Error de base de datos");
        baseExceptionResponse.setMensajeTecnico(ex.getLocalizedMessage());
        baseExceptionResponse.setDetalles(null);
        return new ResponseEntity<>(baseExceptionResponse, HttpStatus.CONFLICT);
    }

    // Excepcion para las validaciones de los campos del Entity
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<BaseErrorResponse> handleConstraintViolation(ConstraintViolationException ex, WebRequest request) {

        List<String> listaErrores = new ArrayList<>();
        for (ConstraintViolation con : ex.getConstraintViolations()) {
            listaErrores.add(con.getMessage());
        }
        BaseErrorResponse baseErrorResponse = new BaseErrorResponse(HttpStatus.BAD_REQUEST.value(), "Por favor, verifique los campos ingresados",
                ex.getLocalizedMessage(), listaErrores);
        return new ResponseEntity<>(baseErrorResponse, HttpStatus.BAD_REQUEST);
    }


    // Excepcion para las validaciones de los campos de DTOS
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> errors = new ArrayList<String>();
        ex.getBindingResult().getAllErrors().forEach(e -> {
            errors.add(e.getDefaultMessage());
        });
        BaseErrorResponse er = new BaseErrorResponse(400, "Error en los campos",
                "Error en la valores de inputs", errors);
        return new ResponseEntity<>(er, HttpStatus.BAD_REQUEST);
    }
}
