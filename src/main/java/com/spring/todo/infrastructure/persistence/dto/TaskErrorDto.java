package com.spring.todo.infrastructure.persistence.dto;

import lombok.Builder;
import lombok.Data;

/**
 * This is a DTO class for Task error handling
 * @package : com.spring.todo.infrastructure.persistence.dto
 * @name : TaskErrorDto.java
 * @date : 2024-04-12
 * @author : Isaias Villarreal
 * @version : 1.0.0
 */
@Builder
@Data
public class TaskErrorDto {

    private String code;
    private String message;
}
