package com.example.springmysqljpashiroproject.controller;


import com.example.springmysqljpashiroproject.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("api/student")
public class StudentController {
    @GetMapping
    @RequestMapping("/h1")
    public Student helloWorld(){
        Student student = new Student(UUID.randomUUID(), "test name");
        return student;
    }


}
