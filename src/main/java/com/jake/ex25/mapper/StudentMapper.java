package com.jake.ex25.mapper;

import java.util.List;
<<<<<<< HEAD
import org.apache.ibatis.annotations.Mapper;
=======

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

>>>>>>> f2/mappersql
import com.jake.ex25.dto.Student;

@Mapper
public interface StudentMapper {
    List<Student> selectAll();
<<<<<<< HEAD
    Student selectById(long id);
    void create(Student student);
    void update(Student student);
=======
    
    @Select("SELECT * FROM student WHERE id = #{id}")
    Student selectById(long id);
    
    @Insert("INSERT INTO student(name, email, age) \r\n"
    		+ "    VALUES ( #{name}, #{email}, #{age} )")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void create(Student student);
    
    @Update("UPDATE student \r\n "
    		+ "    SET name = #{name}, email = #{email}, age = #{age} \r\n"
    		+ "    WHERE id = #{id}")
    void update(Student student);
    
    @Delete("DELETE FROM student WHERE id = #{id}")
>>>>>>> f2/mappersql
    void delete(long id);
}
