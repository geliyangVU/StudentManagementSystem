package com.example.springmysqljpashiroproject.service;

import com.example.springmysqljpashiroproject.dao.StudentDao;
import com.example.springmysqljpashiroproject.exceptions.StudentEmptyNameException;
import com.example.springmysqljpashiroproject.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class StudentService {
    private StudentDao studentDao;


    @Autowired
    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public Student addStudent(Student student){
        if(student.getName().isEmpty()){
            throw new StudentEmptyNameException("Student name cannnot be empty");
        }
        return studentDao.save(student);
    }
}
