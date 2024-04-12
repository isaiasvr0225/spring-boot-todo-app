package com.spring.todo.infrastructure.persistence.mapper;

import com.spring.todo.domain.entity.TaskEntity;
import com.spring.todo.infrastructure.persistence.dto.TaskDto;
import org.mapstruct.*;

/**
 * This is a mapper interface for TaskEntity and TaskDto
 * @package : com.spring.todo.infrastructure.persistence.mapper
 * @name : TaskMapper.java
 * @date : 2024-04-12
 * @author : Isaias Villarreal
 * @version : 1.0.0
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TaskMapper {

    /**
     * This method is used to map TaskDto to TaskEntity
     * @param TaskDto taskDto
     * @return TaskEntity
     */
    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "title", source = "title"),
            @Mapping(target = "description", source = "description"),
            @Mapping(target = "dueDate", source = "dueDate"),
            @Mapping(target = "status", source = "status")
    })
    TaskEntity toEntity(TaskDto taskDto);


    /**
     * This method is used to map TaskEntity to TaskDto
     * @param TaskEntity taskEntity
     * @return TaskDto
     */
    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "title", source = "title"),
            @Mapping(target = "description", source = "description"),
            @Mapping(target = "dueDate", source = "dueDate"),
            @Mapping(target = "status", source = "status")
    })
    TaskDto toDto(TaskEntity taskEntity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    TaskEntity partialUpdate(TaskDto taskDto, @MappingTarget TaskEntity taskEntity);
}
