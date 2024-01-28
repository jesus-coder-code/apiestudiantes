package com.example.apiestudiantes.controller;

import com.example.apiestudiantes.entity.Student;
import com.example.apiestudiantes.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Student> result;
        String message = "no students found";
        Map<String, String> response = new HashMap<>();
        try {
            result = studentService.getStudents();
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
    public ResponseEntity<?> save(@Valid @RequestBody Student student) {
        //Student result = studentService.saveOrUpdate(student);
        String message = "student was created";
        Map<String, String> response = new HashMap<>();
        response.put("message", message);
        try {
            studentService.saveOrUpdate(student);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }catch (Exception e){
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("an error was ocurred");
        }
    }

    @PutMapping
    public ResponseEntity<?> update(@Valid @RequestBody Student student) {
        String message = "student was updated";
        Map<String, String> response = new HashMap<>();
        response.put("message", message);
        try {
            studentService.saveOrUpdate(student);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("internal error");
        }
    }

    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        String message = "student was deleted";
        Map<String, String> response = new HashMap<>();
        response.put("message",message);
        try {
            studentService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("internal error");
        }
    }

    @GetMapping("getStudent/{id}")
    public Optional<Student> getById(@PathVariable("id") Long id) {
        return studentService.getStudentById(id);
    }
}
