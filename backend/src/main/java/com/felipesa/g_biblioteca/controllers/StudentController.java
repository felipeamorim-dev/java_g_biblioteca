package com.felipesa.g_biblioteca.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipesa.g_biblioteca.entities.Student;
import com.felipesa.g_biblioteca.entities.dto.StudentDTO;
import com.felipesa.g_biblioteca.entities.dto.ViewStudentDTO;
import com.felipesa.g_biblioteca.service.StudentService;
import com.felipesa.g_biblioteca.util.UriUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "Endpoint da API REST para manipular dados dos estudantes")
@CrossOrigin(origins = "*")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping(value = "/students/{id}")
	@ApiOperation(value = "Recupera os dados dos estudantes por id")
	public ResponseEntity<StudentDTO> findById(@PathVariable Long id) {
		StudentDTO obj = studentService.findById(id);
		return ResponseEntity.ok(obj);
	}
	
	@GetMapping(value = "/students/registration/{registration}")
	@ApiOperation(value = "Recupera os dados dos estudantes através do registro")
	public ResponseEntity<StudentDTO> findByRegistration(@PathVariable Integer registration) {
		StudentDTO obj = studentService.findByRegistration(registration);
		//obj = studentService.findById(obj.getId());
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping(value = "/students")
	@ApiOperation(value = "Cadastra um estudante")
	public ResponseEntity<Void> insert(@RequestBody Student obj) {
		try {
		studentService.insert(obj);
		return ResponseEntity.created(UriUtil.of(obj)).build();
		}catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping(path = "/students/registration/{registration}")
	@ApiOperation(value = "Atualiza o registro de cadastro de um determinado estudante através do seu número de registro")
	public ResponseEntity<StudentDTO> update(@PathVariable Integer registration, @RequestBody ViewStudentDTO obj){
		StudentDTO std = studentService.update(registration, obj);
		return ResponseEntity.ok().body(std);
	}
	
	@DeleteMapping(path = "/students/{id}")
	@ApiOperation(value = "Deleta um cadastro de estudante através de id")
	public ResponseEntity<Student> deleteByid(@PathVariable Long id){
		studentService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(path = "/students/registration/{registration}")
	@ApiOperation(value = "Deleta um cadastro de estudante através de seu número de registro")
	public ResponseEntity<Student> deleteByRegistration(@PathVariable Integer registration){
		studentService.deleteByRegistration(registration);
		return ResponseEntity.noContent().build();
	}
}
