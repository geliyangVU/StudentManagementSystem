package com.example.springmysqljpashiroproject.mapper;


import com.example.springmysqljpashiroproject.model.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentMapper {
    //SELECT * FROM student where name LIKE %target%;
    @Select("SELECT * FROM student WHERE name LIKE #{name}")
    List<Student> getStudentsContainStringInName(@Param("name") String name);

}
