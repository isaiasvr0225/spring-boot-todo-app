package com.spring.todo.application.service;

import com.spring.todo.infrastructure.persistence.dto.TaskDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.concurrent.CompletableFuture;

/**
 * @package : com.spring.todo.application.service
 * @name : TaskService.java
 * @date : 2024-04-12
 * @author : Isaias Villarreal
 * @version : 1.0.0
 */
public interface TaskService {

    /**
     * This method is used to find all tasks
     * @param Pageable pageable
     * @return CompletableFuture<Page<TaskDto>>
     */
    CompletableFuture<Page<TaskDto>> findAll(Pageable pageable);

    /**
     * This method is used to find a task by id
     * @param Long id
     * @return CompletableFuture<TaskDto>
     */
    CompletableFuture<TaskDto> findById(Long id);

    /**
     * This method is used to save a task
     * @param TaskDto taskDto
     * @return CompletableFuture<TaskDto>
     */
    CompletableFuture<TaskDto> save(TaskDto taskDto);

    /**
     * This method is used to update a task
     * @param Long id
     * @param TaskDto taskDto
     * @return CompletableFuture<TaskDto>
     */
    CompletableFuture<TaskDto> update(Long id, TaskDto taskDto);

    /**
     * This method is used to delete a task
     * @param Long id
     * @return CompletableFuture<Void>
     */
    CompletableFuture<Void> delete(Long id);

}
