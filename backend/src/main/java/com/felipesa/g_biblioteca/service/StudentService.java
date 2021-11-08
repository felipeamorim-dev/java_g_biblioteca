package com.felipesa.g_biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipesa.g_biblioteca.entities.Student;
import com.felipesa.g_biblioteca.repository.StudentRepository;
import com.felipesa.g_biblioteca.service.exceptions.ResourceNotFoundException;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repository;
	
	public List<Student> findAll() {
		return repository.findAll();
	}
	
	public Student findById(Long id) {
		Optional<Student> obj =  repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Student findByRegistration(Integer registration) {
		return repository.findByRegistration(registration);
	}
	
	public void insert(Student obj) throws IllegalArgumentException{
		repository.save(obj);
	}
}
