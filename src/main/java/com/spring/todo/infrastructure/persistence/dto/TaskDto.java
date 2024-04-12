package com.spring.todo.infrastructure.persistence.dto;

import com.spring.todo.domain.entity.TaskStatusEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @package : com.spring.todo.infrastructure.persistence.dto
 * @name : TaskDto.java
 * @date : 2024-04-12
 * @author : Isaias Villarreal
 * @version : 1.0.0
 * DTO for {@link com.spring.todo.domain.entity.TaskEntity}
 */
public record TaskDto(
        @NotNull
        Long id,

        @NotNull
        @NotBlank
        String title,

        @NotNull
        @NotBlank
        String description,

        @NotNull
        Date dueDate,

        @NotNull
        TaskStatusEnum status) implements Serializable {
}