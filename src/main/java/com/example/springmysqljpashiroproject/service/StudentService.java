package com.example.springmysqljpashiroproject.service;

import com.example.springmysqljpashiroproject.dao.StudentDao;
import com.example.springmysqljpashiroproject.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentService {

    private StudentDao studentDao;

    @Autowired
    public StudentService(StudentDao studentDao){
        this.studentDao=studentDao;
    }

    public List<Student> getAllStudents(){
        return studentDao.selectAllStudents();
    }




}
