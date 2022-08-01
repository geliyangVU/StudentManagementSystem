package com.example.springmysqljpashiroproject.controller;


import com.example.springmysqljpashiroproject.model.Student;
import com.example.springmysqljpashiroproject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/student")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    @RequestMapping("/h1")
    public List<Student> getAllStudents(){
        Student student = new Student(UUID.randomUUID(), "test name");
        return studentService.getAllStudents();
    }


}
