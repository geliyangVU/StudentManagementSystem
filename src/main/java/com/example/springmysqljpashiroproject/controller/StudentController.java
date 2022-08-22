package com.example.springmysqljpashiroproject.controller;


import com.example.springmysqljpashiroproject.exceptions.InvalidUniversityClassException;
import com.example.springmysqljpashiroproject.exceptions.StudentEmptyNameException;
import com.example.springmysqljpashiroproject.exceptions.StudentNotExistException;
import com.example.springmysqljpashiroproject.model.Student;
import com.example.springmysqljpashiroproject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/student")
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
//    @RequiresPermissions("student:read")
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

    @PostMapping(path = "assignclass/{sid}/{cid}")
    public ResponseEntity<String> assignClass(@PathVariable("sid") Long studentId, @PathVariable("cid") Long classId){
        try{
            Student updatedStudent =  studentService.assignClass(studentId,classId);
            return ResponseEntity.ok("Assigned class to studnet"+updatedStudent.toString());

        }catch (StudentNotExistException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }catch (InvalidUniversityClassException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());

        }
    }


    @GetMapping("/id")
    //exp: /api/student/?id=xxx
    public Optional<Student> getStudentsById(@RequestParam Long id){
        return studentService.getStudentById(id);

    }

    @GetMapping("/name")
    //exp: /api/student/name?name=xxx
    public List<Student> getStudentsByName(@RequestParam String name){
        return studentService.getStudentsByName(name);

    }

    @GetMapping("/nameContains")
    //exp: /api/student/nameContains?name=xxx
    public List<Student> getStudentsContainsName(@RequestParam String name){
        return studentService.getStudentsContainName(name);
    }


    //example: /api/student/inClass?year=2021&number=1
    @GetMapping("/inClass")
    public List<Student> getStudentsInClass(@RequestParam int year, @RequestParam int name){
        return studentService.getStudentsInClass(year,name);
    }



}
