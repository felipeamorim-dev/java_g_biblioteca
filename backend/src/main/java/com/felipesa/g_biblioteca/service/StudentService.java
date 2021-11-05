package com.felipesa.g_biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipesa.g_biblioteca.entities.Student;
import com.felipesa.g_biblioteca.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repository;
	
	public List<Student> findAll() {
		return repository.findAll();
	}
}
