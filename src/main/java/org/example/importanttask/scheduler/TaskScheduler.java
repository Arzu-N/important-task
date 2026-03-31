package org.example.importanttask.scheduler;

import lombok.RequiredArgsConstructor;
import org.example.importanttask.dao.entity.Task;
import org.example.importanttask.dao.repository.TaskRepository;
import org.example.importanttask.service.TaskService;
import org.example.importanttask.util.Status;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component("myTaskScheduler")
@RequiredArgsConstructor
public class TaskScheduler {

    private final TaskRepository taskRepository;
    private final TaskService taskService;

    @Scheduled(fixedRate = 3600000)
    public void updatePriorityScore(){
         taskRepository.findAll()
                 .stream()
                 .filter(t->t.getStatus()!=Status.DONE)
                 .forEach(t->{
                     t.setPriorityScore(taskService.calculatePriorityScore(t));
                     taskRepository.save(t);
                 });

    }
}
