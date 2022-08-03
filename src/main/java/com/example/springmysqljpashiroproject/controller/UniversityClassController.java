package com.example.springmysqljpashiroproject.controller;


import com.example.springmysqljpashiroproject.model.UniversityClass;
import com.example.springmysqljpashiroproject.service.UniversityClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    


}
