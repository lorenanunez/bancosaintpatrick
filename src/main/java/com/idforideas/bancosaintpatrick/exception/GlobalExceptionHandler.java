package com.idforideas.bancosaintpatrick.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @SneakyThrows
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String, String> errorFields = new HashMap<>();
        ex.getFieldErrors().forEach(fieldError ->
            errorFields.put(fieldError.getField(), fieldError.getDefaultMessage())
        );
        log.error(ex.getMessage());
        return ResponseEntity.badRequest()
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ObjectMapper().writeValueAsString(errorFields));
    }

    @ExceptionHandler(NotEnoughBalanceException.class)
    public ResponseEntity<String> handleNotEnoughBalanceException(NotEnoughBalanceException ex) {
        log.error(ex.getMessage());
        return ResponseEntity
                .unprocessableEntity()
                .contentType(MediaType.TEXT_PLAIN)
                .body(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        log.error(ex.getMessage());
        return ResponseEntity.ok("Oops! Something wrong happened.");
    }

}
