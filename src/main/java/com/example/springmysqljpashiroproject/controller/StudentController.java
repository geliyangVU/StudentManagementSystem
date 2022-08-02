package com.example.springmysqljpashiroproject.controller;


import com.example.springmysqljpashiroproject.exceptions.StudentEmptyNameException;
import com.example.springmysqljpashiroproject.model.Student;
import com.example.springmysqljpashiroproject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }


    @PostMapping("/register")
    public ResponseEntity<String> registerStudent(@RequestBody Student student){
        try{
           Student savedStudent = studentService.addStudent(student);
           return ResponseEntity.ok("Registered Student"+student.toString());
        }catch (StudentEmptyNameException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }


}
