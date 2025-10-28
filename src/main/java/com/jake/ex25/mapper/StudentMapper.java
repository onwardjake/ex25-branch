package com.jake.ex25.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jake.ex25.dto.Student;

@Mapper
public interface StudentMapper {
    List<Student> selectAll();

    
    void create(Student student);
    void update(Student student);
    Student selectById(long id);
    void delete(long id);
}
