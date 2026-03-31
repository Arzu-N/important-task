package org.example.importanttask.mapper;

import org.example.importanttask.dao.entity.Task;
import org.example.importanttask.dao.entity.User;
import org.example.importanttask.dto.TaskRequestDto;
import org.example.importanttask.dto.TaskResponseDto;
import org.example.importanttask.dto.UserRequestDto;
import org.example.importanttask.dto.UserResponseDto;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    public Task toEntity(TaskRequestDto dto){
        Task task = new Task();
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setDeadline(dto.getDeadline());
        task.setDifficulty(dto.getDifficulty());
        return task;
    }

    public TaskResponseDto toDto(Task entity){
        TaskResponseDto taskResponseDto = new TaskResponseDto();
        taskResponseDto.setId(entity.getId());
        taskResponseDto.setTitle(entity.getTitle());
        taskResponseDto.setDescription(entity.getDescription());
        taskResponseDto.setDeadline(entity.getDeadline());
        taskResponseDto.setDifficulty(entity.getDifficulty());
        taskResponseDto.setCreatedAt(entity.getCreatedAt());
        taskResponseDto.setPriorityScore(entity.getPriorityScore());
        taskResponseDto.setStatus(entity.getStatus());
return taskResponseDto;
}

}
