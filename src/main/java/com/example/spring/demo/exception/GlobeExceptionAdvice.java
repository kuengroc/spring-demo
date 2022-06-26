package com.example.spring.demo.exception;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobeExceptionAdvice {
    @ExceptionHandler({StatusException.class})
    public ResponseEntity<Object> handle(StatusException e) {
        Object data = e.getData();
        HttpStatus status = e.getStatus();
        String message = e.getMessage();
        ResponseEntity.BodyBuilder bodyBuilder = ResponseEntity.status(status);
        if (StringUtils.isNotBlank(message)) {
            bodyBuilder.header("message", message);
        }
        return bodyBuilder.body(data);
    }
}
