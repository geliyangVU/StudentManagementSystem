package com.example.springmysqljpashiroproject.controller;


import com.example.springmysqljpashiroproject.model.Student;
import com.example.springmysqljpashiroproject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @RequestMapping("/h1")
    public List<Student> getAllStudents(){
        Student student = new Student(UUID.randomUUID(), "test name");
        return studentService.getAllStudents();
    }


    @PostMapping
    public int addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }


    @PutMapping
    public String updateStudent(@RequestBody Student student){
        studentService.updateStudent(student);
        return "Updated student";
    }


    @DeleteMapping(path = "{id}")

    //localhost:8080/api/student/12345
    public String deleteStudent(@PathVariable("id") UUID id){
        studentService.deleteStudent(id);
        return "Deleted student";
    }
}
