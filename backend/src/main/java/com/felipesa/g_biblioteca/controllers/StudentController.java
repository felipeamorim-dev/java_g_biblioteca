package com.felipesa.g_biblioteca.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.felipesa.g_biblioteca.entities.Student;
import com.felipesa.g_biblioteca.entities.dto.StudentDTO;
import com.felipesa.g_biblioteca.entities.dto.ViewStudentDTO;
import com.felipesa.g_biblioteca.service.StudentService;

@RestController
@RequestMapping(value = "/students")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<StudentDTO> findById(@PathVariable Long id) {
		StudentDTO obj = studentService.findById(id);
		return ResponseEntity.ok(obj);
	}
	
	@GetMapping(value = "/registration/{registration}")
	public ResponseEntity<StudentDTO> findByRegistration(@PathVariable Integer registration) {
		StudentDTO obj = studentService.findByRegistration(registration);
		//obj = studentService.findById(obj.getId());
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Student obj) {
		try {
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId())
				.toUri();
		studentService.insert(obj);
		return ResponseEntity.created(uri).build();
		}catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping(path = "/registration/{registration}")
	public ResponseEntity<StudentDTO> update(@PathVariable Integer registration, @RequestBody ViewStudentDTO obj){
		StudentDTO std = studentService.update(registration, obj);
		return ResponseEntity.ok().body(std);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Student> deleteByid(@PathVariable Long id){
		studentService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(path = "/registration/{registration}")
	public ResponseEntity<Student> deleteByRegistration(@PathVariable Integer registration){
		studentService.deleteByRegistration(registration);
		return ResponseEntity.noContent().build();
	}
}
