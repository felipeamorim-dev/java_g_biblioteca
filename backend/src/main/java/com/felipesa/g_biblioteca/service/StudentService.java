package com.felipesa.g_biblioteca.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.felipesa.g_biblioteca.entities.Student;
import com.felipesa.g_biblioteca.entities.dto.StudentDTO;
import com.felipesa.g_biblioteca.repository.StudentRepository;
import com.felipesa.g_biblioteca.service.exceptions.ResourceNotFoundException;

@Service
@Transactional
public class StudentService {
	
	@Autowired
	private StudentRepository repository;
	
	
	public Page<StudentDTO> findAll(Pageable pageable) {
		Page<Student> list = repository.findAll(pageable);
		return list.map(x -> new StudentDTO(x));
	}
	
	public StudentDTO findById(Long id) {
		Optional<Student> obj =  repository.findById(id);
		obj.get().getLoan().size();
		return new StudentDTO(obj.orElseThrow(() -> new ResourceNotFoundException(id)));
	}
	
	public StudentDTO findByRegistration(Integer registration) {
		Student obj = repository.findByRegistration(registration);
		obj.getLoan().size();
		return new StudentDTO(obj);
	}
	
	public void insert(Student obj){
		repository.save(obj);
	}
	
	public StudentDTO update(Integer registration, Student student) {
		Student obj = repository.findByRegistration(registration);
		updateStudent(obj, student);
		return new StudentDTO(obj);
	}
	
	private void updateStudent(Student oldStudent, Student newStudent) {
		if(newStudent.getName() != null) oldStudent.setName(newStudent.getName());
		if(newStudent.getCourse() != null) oldStudent.setCourse(newStudent.getCourse());
		if(newStudent.getPeriod() != null && newStudent.getPeriod() > 0 && newStudent.getPeriod() <= 10) oldStudent.setPeriod(newStudent.getPeriod());
	}
	
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	
	public void deleteByRegistration(Integer registration) {
		Student obj = repository.findByRegistration(registration);
		deleteById(obj.getId());
	}
}
