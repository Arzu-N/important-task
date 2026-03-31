package org.example.importanttask.mapper;

import lombok.RequiredArgsConstructor;
import org.example.importanttask.dao.entity.User;
import org.example.importanttask.dao.repository.TaskRepository;
import org.example.importanttask.dto.UserRequestDto;
import org.example.importanttask.dto.UserResponseDto;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;


    public User toUserEntity(UserRequestDto dto) {
        User user = new User();
        user.setUserName(dto.getUsername());
        user.setEmail(dto.getEmail());
        return user;
    }

    public UserResponseDto toUserDto(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setUsername(user.getUserName());
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setTasks(taskRepository
                .findByUser_IdOrderByPriorityScoreDesc(user.getId())
                .stream()
                .map(taskMapper::toDto)
                .toList());
        return userResponseDto;
    }
}
