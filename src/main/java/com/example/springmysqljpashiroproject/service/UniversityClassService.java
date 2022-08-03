package com.example.springmysqljpashiroproject.service;


import com.example.springmysqljpashiroproject.dao.UniversityClassDao;
import com.example.springmysqljpashiroproject.model.UniversityClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityClassService {
    private UniversityClassDao universityClassDao;

    @Autowired
    public UniversityClassService(UniversityClassDao universityClassDao) {
        this.universityClassDao = universityClassDao;
    }
    
    public List<UniversityClass> getAllClasses(){
        return (List<UniversityClass>) universityClassDao.findAll();
    }


}
