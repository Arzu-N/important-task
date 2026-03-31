package org.example.importanttask.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.importanttask.util.Difficulty;
import org.example.importanttask.util.Status;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TaskResponseDto {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime deadline;
    private Difficulty difficulty;
    private LocalDateTime createdAt;
    private Double priorityScore;
    private Status status;

}
