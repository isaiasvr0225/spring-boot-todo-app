package com.spring.todo.domain.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class TaskException extends RuntimeException{

    private String code;
    private HttpStatus httpStatus;

    public TaskException(String code, String message, HttpStatus httpStatus) {
        super(message);
        this.code = code;
        this.httpStatus = httpStatus;
    }
}
