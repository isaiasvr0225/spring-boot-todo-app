package com.spring.todo.application.service;

import com.spring.todo.domain.entity.TaskEntity;
import com.spring.todo.domain.exception.TaskException;
import com.spring.todo.infrastructure.persistence.dto.TaskDto;
import com.spring.todo.infrastructure.persistence.mapper.TaskMapper;
import com.spring.todo.infrastructure.persistence.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.util.concurrent.CompletableFuture;

/**
 * @package : com.spring.todo.application.service
 * @name : TaskServiceImpl.java
 * @date : 2024-04-12
 * @author  : Isaias Villarreal
 * @version : 1.0.0
 */
@RequiredArgsConstructor
public @Service class TaskServiceImpl implements TaskService{

    private final TaskRepository taskRepository;

    private final TaskMapper taskMapper;

    private final Logger logger = LoggerFactory.getLogger(TaskServiceImpl.class);

    /**
     * This method is used to find all tasks using pagination and cache, also it is an asynchronous method
     * @param Pageable pageable
     * @return CompletableFuture<Page<TaskDto>>
     */
    @Async("asyncExecutor")
    @Cacheable("findAllTasks")
    @Override
    public CompletableFuture<Page<TaskDto>> findAll(Pageable pageable) {

        Page<TaskEntity> pageTaskEntities = this.taskRepository.findAll(pageable);

        if (pageTaskEntities.isEmpty()) {
            throw new TaskException("500", "Internal server error", HttpStatus.NOT_FOUND);
        }

        Page<TaskDto> pageTaskDtos = pageTaskEntities.map(this.taskMapper::toDto);

        return CompletableFuture.completedFuture(pageTaskDtos);
    }

    /**
     * This method is used to find a task by id and cache, also it is an asynchronous method
     * @param Long id
     * @return CompletableFuture<TaskDto>
     */
    @Async("asyncExecutor")
    @Cacheable("findTaskById")
    @Override
    public CompletableFuture<TaskDto> findById(Long id) {
        TaskEntity taskEntity = this.taskRepository.findById(id)
                .orElseThrow(() -> new TaskException("404", "Task not found", HttpStatus.NOT_FOUND));

        TaskDto taskDto = this.taskMapper.toDto(taskEntity);

        return CompletableFuture.completedFuture(taskDto);

    }

    /**
     * This method is used to save a task and cache, also it is an asynchronous method
     * @param TaskDto taskDto
     * @return CompletableFuture<TaskDto>
     */
    @Async("asyncExecutor")
    @Override
    public CompletableFuture<TaskDto> save(TaskDto taskDto) {

        if (    taskDto == null ||
                taskDto.title() == null       || taskDto.title().isBlank()       ||
                taskDto.description() == null || taskDto.description().isBlank() ||
                taskDto.dueDate() == null     ||
                taskDto.status() == null      || taskDto.status().toString().isBlank()) {
            throw new TaskException("400", "Fields must not be null or blank", HttpStatus.BAD_REQUEST);
        }

        TaskEntity taskEntity = this.taskMapper.toEntity(taskDto);

        TaskDto taskDtoSaved = this.taskMapper.toDto(this.taskRepository.save(taskEntity));

        return CompletableFuture.completedFuture(taskDtoSaved);
    }

    /**
     * This method is used to update a task and cache, also it is an asynchronous method
     * @param Long id
     * @param TaskDto taskDto
     * @return CompletableFuture<TaskDto>
     */
    @Async("asyncExecutor")
    @Override
    public CompletableFuture<TaskDto> update(Long id, TaskDto taskDto) {

        if (    id == null ||
                taskDto == null ||
                taskDto.title() == null       || taskDto.title().isBlank()       ||
                taskDto.description() == null || taskDto.description().isBlank() ||
                taskDto.dueDate() == null) {
            throw new TaskException("400", "Id and fields must not be null or blank", HttpStatus.BAD_REQUEST);
        }

        TaskEntity taskEntity = this.taskRepository.findById(id)
                .orElseThrow(() -> new TaskException("404", "Task not found", HttpStatus.NOT_FOUND));

        TaskDto taskDtoUpdated = this.taskMapper.toDto(this.taskRepository.save(taskEntity));

        return CompletableFuture.completedFuture(taskDtoUpdated);
    }

    /**
     * This method is used to delete a task and cache, also it is an asynchronous method
     * @param Long id
     * @return CompletableFuture<Void>
     */
    @Async("asyncExecutor")
    @Override
    public CompletableFuture<Void> delete(Long id) {

        if (id == null) {
            throw new TaskException("400", "Id must not be null", HttpStatus.BAD_REQUEST);
        }

        return CompletableFuture.runAsync(() -> {
            this.taskRepository.deleteById(id);
        });
    }


}
