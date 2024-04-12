package com.spring.todo.infrastructure.persistence.repository;

import com.spring.todo.domain.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This interface is used to manage the task repository, it extends from JpaRepository interface
 * @package : com.spring.todo.infrastructure.persistence.repository
 * @name : TaskRepository.java
 * @date : 2024-04-12
 * @author : Isaias Villarreal
 * @version : 1.0.0
 */
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
}
