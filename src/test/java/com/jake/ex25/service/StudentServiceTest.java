package com.jake.ex25.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import com.jake.ex25.dto.StudentTest;
import com.jake.ex25.mapper.StudentMapperTest;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class StudentServiceTest {
	@Autowired
	private StudentMapperTest studentMapperTest;
	
	@Test
	@DisplayName("학생 등록 후 조회 (TDD)")
	void testRegisterAndFind() {
		// given
		StudentTest s3 = StudentTest.builder()
				.name("홍길동3")
				.email("h3@test.com")
				.age(33)
				.build();

		StudentTest s4 = StudentTest.builder()
				.name("홍길동4")
				.email("h4@test.com")
				.age(44)
				.build();

		//studentMapperTest.insert(s4);
		
		// when
		int result = studentMapperTest.insert(s3);
		
		
		// then
		assertEquals(1, result, "등록은 1건 성공해야 한다.");
		assertNotNull(s3.getId(), "등록 후 id가 자동 생성되어야 한다.");
		
		StudentTest findStudent = studentMapperTest.findById(s3.getId());
		assertEquals("홍길동3", findStudent.getName());
		assertEquals("h3@test.com", findStudent.getEmail());
		assertEquals(33, findStudent.getAge());
	}
	
	@Test
	@DisplayName("전체 학생 조회 (TDD)")
	void testFindAll() {
		// given
		/*
		StudentTest s3 = StudentTest.builder()
				.name("홍길동3")
				.email("h3@test.com")
				.age(33)
				.build();

		StudentTest s4 = StudentTest.builder()
				.name("홍길동4")
				.email("h4@test.com")
				.age(44)
				.build();
		studentMapperTest.insert(s3);
		studentMapperTest.insert(s4);
		*/
		
		// when
		List<StudentTest> students = studentMapperTest.selectAll();
		
		// then
		assertTrue(students.size() >= 2);
	}
}
