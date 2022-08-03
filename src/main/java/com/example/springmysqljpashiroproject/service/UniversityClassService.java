package com.example.springmysqljpashiroproject.service;


import com.example.springmysqljpashiroproject.dao.UniversityClassDao;
import com.example.springmysqljpashiroproject.exceptions.InvalidUniversityClassException;
import com.example.springmysqljpashiroproject.model.UniversityClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
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


    public UniversityClass addClass(UniversityClass universityClass){
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        if(universityClass.getYear()<currentYear){
            throw new InvalidUniversityClassException("Can not add class for past year");
        }
        if(universityClass.getYear()>currentYear+4){
            throw new InvalidUniversityClassException("Can not add class for years in future ");
        }

        return universityClassDao.save(universityClass);
    }

}
