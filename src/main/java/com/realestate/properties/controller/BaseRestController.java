package com.realestate.properties.controller;

import com.realestate.properties.dto.ErrorResponse;
import com.realestate.properties.exceptions.BaseException;
import com.realestate.properties.exceptions.WrongCredentials;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Arrays;
import java.util.stream.Collectors;

public class BaseRestController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public final ResponseEntity<?> handleUserNotFoundException(MethodArgumentNotValidException ex, WebRequest request) {
        return new ResponseEntity<>(
                new ErrorResponse(ex.getBindingResult().getFieldErrors().stream().map(item -> item.getDefaultMessage()).collect(Collectors.toList()))
                , HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BaseException.class)
    public final ResponseEntity<?> handleUserNotFoundException(BaseException ex, WebRequest request) {
        return new ResponseEntity<>(
                new ErrorResponse(Arrays.asList(ex.getMessage()))
                , HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InternalAuthenticationServiceException.class)
    public final ResponseEntity<?> handleInternalAuthenticationServiceException(InternalAuthenticationServiceException ex, WebRequest request) {

        return new ResponseEntity<>(
                new ErrorResponse(Arrays.asList("Your username or password were not found."))
                , HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(WrongCredentials.class)
    public final ResponseEntity<?> handleWrongCredentials(Exception ex, WebRequest request) {
        ex.printStackTrace();
        return new ResponseEntity<>(
                new ErrorResponse(Arrays.asList(ex.getMessage()))
                , HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<?> handleGeneralExcpetions(Exception ex, WebRequest request) {
        ex.printStackTrace();
        return new ResponseEntity<>(
                new ErrorResponse(Arrays.asList("An unespected error heppened, please, try again."))
                , HttpStatus.NOT_FOUND);
    }
}
