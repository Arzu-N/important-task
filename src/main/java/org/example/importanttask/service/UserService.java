package org.example.importanttask.service;

import lombok.RequiredArgsConstructor;
import org.example.importanttask.dao.entity.Task;
import org.example.importanttask.dao.entity.User;
import org.example.importanttask.dao.repository.TaskRepository;
import org.example.importanttask.dao.repository.UserRepository;
import org.example.importanttask.dto.TaskResponseDto;
import org.example.importanttask.dto.UserRequestDto;
import org.example.importanttask.dto.UserResponseDto;
import org.example.importanttask.mapper.TaskMapper;
import org.example.importanttask.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public UserResponseDto create(UserRequestDto dto){
        User user = userMapper.toUserEntity(dto);
     /*  List<Task> tasks = taskRepository.findByUser_IdOrderByPriorityScoreDesc(user.getId());
        user.setTasks(tasks);*/

        return userMapper.toUserDto(userRepository.save(user));
    }

    public List<UserResponseDto>getAll(){
        return userRepository.findAll()
                .stream()
                .map(userMapper::toUserDto)
                .toList();
    }
}
