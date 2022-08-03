package com.example.springmysqljpashiroproject.service;

import com.example.springmysqljpashiroproject.dao.StudentDao;
import com.example.springmysqljpashiroproject.dao.UniversityClassDao;
import com.example.springmysqljpashiroproject.exceptions.InvalidUniversityClassException;
import com.example.springmysqljpashiroproject.exceptions.StudentEmptyNameException;
import com.example.springmysqljpashiroproject.exceptions.StudentNotExistException;
import com.example.springmysqljpashiroproject.model.Student;
import com.example.springmysqljpashiroproject.model.UniversityClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class StudentService {
    private StudentDao studentDao;
    private UniversityClassDao universityClassDao;


    @Autowired
    public StudentService(StudentDao studentDao,UniversityClassDao universityClassDao) {
        this.studentDao = studentDao;
        this.universityClassDao=universityClassDao;
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

    public Student assignClass(Long studentId, Long classId){
        if(!studentDao.existsById(studentId)){
            throw new StudentNotExistException("Cannot find student id, Student does not exist!");
        }

        if(!universityClassDao.existsById(classId)){
            throw new InvalidUniversityClassException("Cannot find class ID:"+classId);
        }

        Student student = getStudentById(studentId).get();
        UniversityClass universityClass= universityClassDao.findById(classId).get();

        student.setUniversityClass(universityClass);
        return studentDao.save(student);
    }



    public List<Student> getAllStudents(){
        return (List<Student>) studentDao.findAll();
    }



    public Optional<Student> getStudentById(Long id){
        return studentDao.findById(id);
    }



    public List<Student> getStudentsByName(String name){
        return studentDao.findByName(name);
    }

}
