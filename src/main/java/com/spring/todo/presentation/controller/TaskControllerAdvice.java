package com.spring.todo.presentation.controller;

import com.spring.todo.domain.exception.TaskException;
import com.spring.todo.infrastructure.persistence.dto.TaskErrorDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @package : com.spring.todo.presentation.controller
 * @name : TaskControllerAdvice.java
 * @date : 2024-04-12
 * @author : Isaias Villarreal
 * @version : 1.0.0
 */
@RestControllerAdvice
public class TaskControllerAdvice {

    /**
     * This method is used to handle TaskException
     * @param TaskException taskException
     * @return ResponseEntity<TaskErrorDto>
     */
    @ExceptionHandler(value = TaskException.class)
    public ResponseEntity<TaskErrorDto> handleTaskException(TaskException taskException) {
        return ResponseEntity.status(taskException.getHttpStatus()).body(TaskErrorDto.builder()
                .code(taskException.getCode())
                .message(taskException.getMessage())
                .build());
    }
}
