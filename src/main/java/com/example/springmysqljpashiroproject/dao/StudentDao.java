package com.example.springmysqljpashiroproject.dao;

import com.example.springmysqljpashiroproject.model.Student;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface StudentDao {

    List<Student> selectAllStudents();

    int insertStudent(Student student);

    int updateStudent(Student student);
}
