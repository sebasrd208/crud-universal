package com.example.empleados.exception;

import java.util.*;
import org.springframework.http.*;
import org.springframework.web.bind.*;
import org.springframework.web.bind.annotation.*;

/*Esta clase captura automaticamente las excepciones de validacion generadas por el
 * controlador cuando fallen alguna de las anotaciones de Validation en el DTO request.*/

@ControllerAdvice// Indica que la clase manejara las excepciones globalmente.
public class GlobalExceptionHandler extends RuntimeException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handlerValidationError
            (MethodArgumentNotValidException ex){
        Map<String, String> errores = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errores.put(error.getField(), error.getDefaultMessage());
        });

        return new ResponseEntity<>(errores, HttpStatus.BAD_REQUEST);
    }
}
