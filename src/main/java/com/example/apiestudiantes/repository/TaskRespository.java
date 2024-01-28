package com.example.apiestudiantes.repository;

import com.example.apiestudiantes.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRespository extends JpaRepository<Task, Long> {
}
