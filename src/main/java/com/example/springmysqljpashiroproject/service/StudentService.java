package com.example.springmysqljpashiroproject.service;

import com.example.springmysqljpashiroproject.dao.StudentDao;
import com.example.springmysqljpashiroproject.exceptions.StudentEmptyNameException;
import com.example.springmysqljpashiroproject.exceptions.StudentNotExistException;
import com.example.springmysqljpashiroproject.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


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

    public Student updateStudent(Student student){
        if(student.getId()==null || studentDao.existsById(student.getId())){
            throw new StudentNotExistException("Cannot find student id, Student does not exist!");
        }
        return studentDao.save(student);
    }


    public List<Student> getAllStudents(){
        return (List<Student>) studentDao.findAll();
    }



    public Optional<Student> getStudentById(Long id){
        return studentDao.findById(id);
    }

}
