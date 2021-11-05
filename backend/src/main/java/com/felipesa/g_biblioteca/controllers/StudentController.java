package com.felipesa.g_biblioteca.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipesa.g_biblioteca.entities.Student;
import com.felipesa.g_biblioteca.service.StudentService;

@RestController
@RequestMapping(value = "/students")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping
	public ResponseEntity<List<Student>> findAll() {
		List<Student> list = studentService.findAll();
		return ResponseEntity.ok(list);
	}
}
