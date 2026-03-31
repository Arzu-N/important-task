package org.example.importanttask.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.importanttask.util.Difficulty;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TaskRequestDto {
    private String title;
    private String description;
    private LocalDateTime deadline;
    private Difficulty difficulty;

}
