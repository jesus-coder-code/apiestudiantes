package com.example.apiestudiantes.service;

import com.example.apiestudiantes.entity.Task;
import com.example.apiestudiantes.repository.TaskRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    TaskRespository taskRespository;

    public List<Task> getTasks(){
        return taskRespository.findAll();
    }

    public Optional<Task> getTaskById(Long id){
        return taskRespository.findById(id);
    }

    public void saveOrUpdateTask(Task task){
        taskRespository.save(task);
    }
    public void deleteTask(Long id){
        taskRespository.deleteById(id);
    }
}
