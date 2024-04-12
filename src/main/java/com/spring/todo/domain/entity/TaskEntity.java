package com.spring.todo.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @package : com.spring.todo.domain.entity
 * @name : TaskEntity.java
 * @date : 2024-04-12
 * @author  : Isaias Villarreal
 * @version : 1.0.0
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tasks")
public @Entity class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @NotNull
    @NotBlank
    @Column(columnDefinition = "TEXT", nullable = false)
    private String title;

    @NotNull
    @NotBlank
    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

    @NotNull
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    @Column(name = "due_date", nullable = false)
    private Date dueDate;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TaskStatusEnum status;
}