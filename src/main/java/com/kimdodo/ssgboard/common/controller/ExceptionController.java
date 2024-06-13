package com.kimdodo.ssgboard.common.controller;

import com.kimdodo.ssgboard.common.domain.ErrorResponse;
import com.kimdodo.ssgboard.common.exception.BoardException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionController{

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ErrorResponse invalidExceptionHandler(MethodArgumentNotValidException e){
        ErrorResponse errorResponse = ErrorResponse.builder()
                .code("400")
                .message("잘못된 요청입니다")
                .build();
        for (FieldError fieldError : e.getFieldErrors()){
            errorResponse.addValidation(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return errorResponse;
    }

    @ExceptionHandler(BoardException.class)
    @ResponseBody
    public ResponseEntity<ErrorResponse> boardException(BoardException e){
        int statusCode = e.getStatusCode();
        ErrorResponse error = ErrorResponse.builder()
                .code(String.valueOf(statusCode))
                .message(e.getMessage())
                .validation(e.getValidation())
                .build();

        return ResponseEntity.status(statusCode)
                .body(error);
    }
}
