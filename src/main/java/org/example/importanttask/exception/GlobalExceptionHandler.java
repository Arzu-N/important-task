package org.example.importanttask.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({UserNotFound.class, TaskNotFound.class})
    public ResponseEntity<Map<String,Object>>handle(RuntimeException e, HttpServletRequest request){

      Map<String,Object>map=new HashMap<>();
       map.put("message",e.getMessage());
       map.put("path",request.getRequestURI());
       map.put("status", HttpStatus.NOT_FOUND.value());
       map.put("timestamp", LocalDateTime.now());
       return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
    }
}
