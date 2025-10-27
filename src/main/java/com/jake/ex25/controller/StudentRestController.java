package com.jake.ex25.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jake.ex25.dto.Student;
import com.jake.ex25.service.StudentService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentRestController {
	private final StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.selectAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> selectOne(@PathVariable long id) {
        Student student = studentService.selectOne(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @PostMapping("/create")
    public ResponseEntity<Student> create(@RequestBody Student student) {
        studentService.create(student);
        return ResponseEntity.ok(student);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> update(@PathVariable long id, @RequestBody Student student) {
        student.setId(id);
        studentService.update(student);
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Student> delete(@PathVariable long id) {
        Student student = studentService.selectOne(id);
        studentService.delete(id);
        return ResponseEntity.ok(student);
    }
}
