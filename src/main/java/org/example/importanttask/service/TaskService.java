package org.example.importanttask.service;

import lombok.RequiredArgsConstructor;
import org.example.importanttask.dao.entity.Task;
import org.example.importanttask.dao.entity.User;
import org.example.importanttask.dao.repository.TaskRepository;
import org.example.importanttask.dao.repository.UserRepository;
import org.example.importanttask.dto.TaskRequestDto;
import org.example.importanttask.dto.TaskResponseDto;
import org.example.importanttask.exception.TaskNotFound;
import org.example.importanttask.exception.UserNotFound;
import org.example.importanttask.mapper.TaskMapper;
import org.example.importanttask.util.Status;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskMapper taskMapper;
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public TaskResponseDto create(TaskRequestDto dto, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFound("User not found"));
        Task task = taskMapper.toEntity(dto);
        task.setUser(user);
        task.setCreatedAt(LocalDateTime.now());
        task.setStatus(Status.UNDONE);
        task.setPriorityScore(calculatePriorityScore(task));
        List<Task>tasks=new ArrayList<>();
        tasks.add(task);
        user.setTasks(tasks);
        return taskMapper.toDto(taskRepository.save(task));
    }

    public List<TaskResponseDto> getAll(Long userId) {
        return taskRepository.findByUser_IdOrderByPriorityScoreDesc(userId)
                .stream()
                .map(taskMapper::toDto).toList();
    }


    public TaskResponseDto getById(Long id) {
        return taskRepository.findById(id).map(taskMapper::toDto)
                .orElseThrow(() -> new TaskNotFound("Task not found"));
    }

    public TaskResponseDto getRandom(Long userId) {
        List<Task> tasks = taskRepository
                .findByUser_IdOrderByPriorityScoreDesc(userId);
        Random random = new Random();
        if(tasks.isEmpty()) return null;
        Task task = tasks.get(random.nextInt(tasks.size()));
        return taskMapper.toDto(task);
    }

    public void delete(Long id) {
        if (!taskRepository.existsById(id))
            throw new TaskNotFound("Task not found");
        taskRepository.deleteById(id);
    }


    public  double calculatePriorityScore(Task task) {
        long hour = ChronoUnit.HOURS.between(LocalDateTime.now(), task.getDeadline());
        if(hour<0)
            return 0;
        double score = 0;
        switch (task.getDifficulty()) {
            case HARD -> score += 50;
            case MEDIUM -> score += 30;
            case EASY -> score += 10;
        }


        if (hour <= 24)
            score += 100;
        else if (hour <= 72)
            score += 70;
        else if (hour <= 168)
            score += 40;
        else
            score += 10;

        return score;
    }
}


