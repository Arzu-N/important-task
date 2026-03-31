package org.example.importanttask.controller;

import lombok.RequiredArgsConstructor;
import org.example.importanttask.dto.UserRequestDto;
import org.example.importanttask.dto.UserResponseDto;
import org.example.importanttask.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user/api/v1")
public class UserController {
    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserResponseDto>create(@RequestBody UserRequestDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>>getAll(){
        return ResponseEntity.ok(userService.getAll());
    }
}
