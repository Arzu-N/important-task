package org.example.importanttask.exception;

public class TaskNotFound extends RuntimeException{
    public TaskNotFound(String message){
        super(message);
    }
}
