package org.example.importanttask.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.importanttask.dto.TaskRequestDto;
import org.example.importanttask.dto.TaskResponseDto;
import org.example.importanttask.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/task/api/v1")
public class TaskController {

    private final TaskService taskService;

    @PostMapping("/create")
    public ResponseEntity<TaskResponseDto>create(@RequestBody TaskRequestDto dto, @RequestParam Long userId){
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.create(dto,userId));
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<TaskResponseDto>>getAll(@RequestParam Long userId){
        return ResponseEntity.ok(taskService.getAll(userId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDto>getById(@PathVariable Long id){
        return ResponseEntity.ok(taskService.getById(id));
    }

    @GetMapping("/random")
public ResponseEntity<TaskResponseDto>getRandom(@RequestParam Long userId){
     return ResponseEntity.ok(taskService.getRandom(userId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>delete(@PathVariable Long id){
        taskService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
