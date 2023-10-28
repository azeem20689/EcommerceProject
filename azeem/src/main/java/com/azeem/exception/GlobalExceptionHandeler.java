package com.azeem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandeler {

    @ExceptionHandler(ControllerException.class)
    public ResponseEntity<ApiResponse> ControllerExceptionHandler(Exception ex) {
        return new ResponseEntity<ApiResponse>(new ApiResponse("601", ex.getMessage())
                , HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ApiResponse> methodNotSupported(Exception ex){
        return new ResponseEntity<ApiResponse>(new ApiResponse("602",ex.getMessage())
        , HttpStatus.METHOD_NOT_ALLOWED);
    }
}
