package com.jake.ex25.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.jake.ex25.dto.StudentTest;

@Mapper
public interface StudentMapperTest {

	@Select("SELECT * FROM student ORDER BY id DESC")
	List<StudentTest> selectAll();
	
	@Select("SELECT * FROM student WHERE id=#{id}")
	StudentTest findById(Long id);

	@Insert("INSERT INTO student (name, email, age) \r\n"
			+ "    VALUES ( #{name}, #{email}, #{age} )")
	@Options(useGeneratedKeys=true, keyProperty="id")
	int insert(StudentTest student);
}
