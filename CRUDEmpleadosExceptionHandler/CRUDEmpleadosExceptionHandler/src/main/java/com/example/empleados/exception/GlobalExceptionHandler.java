package com.example.empleados.exception;

import java.time.*;
import java.util.*;
import org.springframework.http.*;
import org.springframework.web.bind.*;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    public ResponseEntity<?> buildResponse(String mensaje, HttpStatus status){
        Map<String, Object> error = new HashMap<>();

        error.put("timestamp", LocalDateTime.now());
        error.put("mensaje", mensaje);
        error.put("codigo", status.value());

        return new ResponseEntity<>(error, status);
    }

    @ExceptionHandler(EmpleadoNotFoundException.class)
    public ResponseEntity<?> manejoEmpleadoNoEncontrado(EmpleadoNotFoundException ex){
        return buildResponse(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmpleadoDuplicadoException.class)
    public ResponseEntity<?> manejoEmpleadoDuplicado(EmpleadoDuplicadoException ex){
        return buildResponse(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmpleadoValidationException.class)
    public ResponseEntity<?> manejoEmpleadoValidationError(EmpleadoValidationException ex){
        return buildResponse(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> manejoValidationError(MethodArgumentNotValidException ex){
        Map<String, String> errores = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errores.put(error.getField(), error.getDefaultMessage());
        });

        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("codigo", HttpStatus.BAD_REQUEST.value());
        response.put("errores", errores);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> manejoGlobalGeneral(Exception ex){
        Map<String, Object> error = new HashMap<>();
        error.put("timestamp", LocalDateTime.now());
        error.put("mensaje", "Error generico no manejado.");
        error.put("codigo", HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.put("detalle", ex.getMessage());

        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
