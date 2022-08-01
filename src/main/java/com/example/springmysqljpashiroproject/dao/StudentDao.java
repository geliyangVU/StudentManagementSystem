package com.example.springmysqljpashiroproject.dao;

import com.example.springmysqljpashiroproject.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface StudentDao extends CrudRepository<Student, Long> {

}
