package com.example.apiestudiantes.service;

import com.example.apiestudiantes.entity.Student;
import com.example.apiestudiantes.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Long id){
        return studentRepository.findById(id);
    }

    public Student saveOrUpdate(Student student){
        try {
            studentRepository.save(student);
        }catch (Exception e){
            System.out.println(e);
        }
        return student;
    }
    public boolean delete(Long id){
        try {
            studentRepository.deleteById(id);
        }catch (Exception e){
            System.out.println(e);
        }
        return true;
    }
}