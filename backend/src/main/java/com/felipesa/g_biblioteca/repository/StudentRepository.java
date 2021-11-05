package com.felipesa.g_biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.felipesa.g_biblioteca.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
	
	@Query(value = "SELECT * FROM TB_STUDENT WHERE REGISTRATION = ?1", nativeQuery = true)
	Student findByRegistration(Integer registration);

}
