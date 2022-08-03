package com.example.springmysqljpashiroproject.controller;


import com.example.springmysqljpashiroproject.exceptions.InvalidUniversityClassException;
import com.example.springmysqljpashiroproject.model.UniversityClass;
import com.example.springmysqljpashiroproject.service.UniversityClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/university")
public class UniversityClassController {

    private UniversityClassService universityClassService;

    @Autowired
    public UniversityClassController(UniversityClassService universityClassService) {
        this.universityClassService = universityClassService;
    }

    @GetMapping("/getAllClasses")
    List<UniversityClass> getAllClasses(){
        return universityClassService.getAllClasses();
    }

    @PostMapping("/add")
    public ResponseEntity<String> addClass(@RequestBody UniversityClass universityClass){
        try{
            UniversityClass savedClass= universityClassService.addClass(universityClass);
            return ResponseEntity.ok("Added class."+savedClass.toString());
        }catch (InvalidUniversityClassException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());

        }
    }



}
