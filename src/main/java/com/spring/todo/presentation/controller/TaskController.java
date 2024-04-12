package com.spring.todo.presentation.controller;

import com.spring.todo.application.service.TaskService;
import com.spring.todo.infrastructure.persistence.dto.TaskDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @package : com.spring.todo.presentation.controller
 * @name : TaskController.java
 * @date : 2024-04-12
 * @author : Isaias Villarreal
 * @version : 1.0.0
 */

@RequiredArgsConstructor
@RequestMapping("/api/v1/tasks")
public @RestController class TaskController {

    private final TaskService taskService;

    @GetMapping
    public ResponseEntity<Page<TaskDto>> findAll(@PageableDefault(page = 0, size = 10) Pageable pageable) {
        return ResponseEntity.ok(this.taskService.findAll(pageable).join());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDto> findById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(this.taskService.findById(id).join());
    }

    @PostMapping
    public ResponseEntity<TaskDto> save(@RequestBody TaskDto taskDto) {

        return ResponseEntity.ok(this.taskService.save(taskDto).join());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskDto> update(@PathVariable(name = "id") Long id, @RequestBody TaskDto taskDto) {
        return ResponseEntity.ok(this.taskService.update(id, taskDto).join());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(name = "id") Long id) {
        this.taskService.delete(id).join();
        return ResponseEntity.ok("Task deleted successfully");
    }
}
