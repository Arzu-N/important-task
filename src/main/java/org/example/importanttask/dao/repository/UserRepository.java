package org.example.importanttask.dao.repository;

import org.example.importanttask.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
