package com.example.apiestudiantes.controller;

import com.example.apiestudiantes.entity.Student;
import com.example.apiestudiantes.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @GetMapping("/getStudents")
    @ResponseStatus(HttpStatus.OK)
    public List<Student> getAll(){
        return studentService.getStudents();
    }

    @PostMapping("/newStudent")
    @ResponseStatus(HttpStatus.CREATED)
    public Student save(@RequestBody Student student){
        return studentService.saveOrUpdate(student);
    }

    @PutMapping("/updateStudent")
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, String> update(@RequestBody Student student){
        studentService.saveOrUpdate(student);
        String message = "student was updated";
        Map<String, String> response = new HashMap<>();
        response.put("message", message);
        return response;
    }

    @DeleteMapping("/deleteStudent/{id}")
    public Map<String, String> delete(@PathVariable("id") Long id){
        boolean ok = studentService.delete(id);
        String message;
        Map<String, String> response = new HashMap<>();
        if (ok){
            message = "student was deleted";
            
        }else {
            message = "an error was occurred";
        }
        response.put("message", message);
        return response;
    }

    @GetMapping("getStudent/{id}")
    public Optional<Student> getById(@PathVariable("id") Long id){
        return studentService.getStudentById(id);
    }
}
