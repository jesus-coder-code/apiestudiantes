package com.example.apiestudiantes.controller;

import com.example.apiestudiantes.entity.Task;
import com.example.apiestudiantes.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "api/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<?> getAllTask() {
        List<Task> result;
        String message = "no tasks found";
        Map<String, String> response = new HashMap<>();
        try {
            result = taskService.getTasks();
            if(result.isEmpty()){
                response.put("message", message);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("internal error");
        }
    }

    @PostMapping
    public ResponseEntity<?> saveTask(@Valid @RequestBody Task task) {
        String message = "task was created";
        Map<String, String> response = new HashMap<>();
        response.put("message", message);
        try {
            taskService.saveOrUpdateTask(task);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }catch (Exception e){
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("an error was ocurred");
        }
    }

    @PutMapping
    public ResponseEntity<?> updateTask(@Valid @RequestBody Task task){
        String message = "task was uptaded";
        Map<String, String> response = new HashMap<>();
        response.put("message", message);
        try{
            taskService.saveOrUpdateTask(task);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }catch (Exception e){
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("an error was ocurred");
        }
    }
}
