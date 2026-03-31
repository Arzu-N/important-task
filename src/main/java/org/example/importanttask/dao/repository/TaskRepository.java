package org.example.importanttask.dao.repository;

import org.example.importanttask.dao.entity.Task;
import org.example.importanttask.dao.entity.User;
import org.hibernate.dialect.lock.OptimisticEntityLockException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task,Long> {
    List<Task> findByUser_IdOrderByPriorityScoreDesc(Long userId);

    Long user(User user);
}
