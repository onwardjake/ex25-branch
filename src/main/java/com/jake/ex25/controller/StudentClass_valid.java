package com.jake.ex25.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jake.ex25.dto.Student;
import com.jake.ex25.service.StudentService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/students/valid")
@RequiredArgsConstructor
public class StudentClass_valid {
	private final StudentService studentService;
	
	@GetMapping
	public String list(Model model) {
		model.addAttribute("students", studentService.selectAll());
		return "student/list_validtest";
	}

	/*
	// 등록 form
	@GetMapping("/new")
	public String createForm(Model model) {
		model.addAttribute("student", new Student());
		return "student/form";
	}
	*/
	
	// 등록 form (validation check form)
	@GetMapping("/new")
	public String createFormValid(Model model) {
		model.addAttribute("student", new Student());
		return "student/form_validtest";
	}
	
	// 등록 처리
	@PostMapping
	public String create(@Valid @ModelAttribute Student student, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			// 입력값이 valid하지 않으면 다시 입력 화면으로 돌아간다 
			return "student/form_validtest";
		}
		
		// DB에 데이터를 insert한다
		studentService.create(student);
		
		return "redirect:/students/valid";
	}
	
	// 수정 form
	@GetMapping("/{id}/edit")
	public String updateForm(@PathVariable Long id, Model model) {
		model.addAttribute("student", studentService.selectOne(id));
		return "student/form_validtest";
	}
	
	// 수정 처리
	@PostMapping("/{id}")
	public String update(@PathVariable Long id, @Valid @ModelAttribute Student student, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			// 입력값이 valid하지 않으면 다시 입력 화면으로 돌아간다
			return "student/form_validtest";
		}
		
		// DB에 데이터를 update한다
		student.setId(id);
		studentService.update(student);
		
		return "redirect:/students/valid";
	}
	
	// 삭제
	@PostMapping("/{id}/delete")
	public String delete(@PathVariable Long id) {
		studentService.delete(id);
		return "redirect:/students/valid";
	}
}
