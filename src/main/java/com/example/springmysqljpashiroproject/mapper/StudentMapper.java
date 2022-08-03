package com.example.springmysqljpashiroproject.mapper;


import com.example.springmysqljpashiroproject.model.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface StudentMapper {
    //SELECT * FROM student where name LIKE %target%;
    @Select("SELECT * FROM student WHERE name LIKE #{name}")
    List<Student> getStudentsContainStringInName(@Param("name") String name);

    //SELECT * FROM student WHERE university_class_id(fk) IN
    //(SELECT id FROM university_class where year=2021 and number = 1);
    @Select("SELECT * FROM student WHERE university_class_id IN"+
            "(SELECT id FROM university_class WHERE year=#{year} AND number = #{number})")
    List<Student> getStudentsInClass(@Param("year") int year, @Param("number") int number);


}
