package com.felipesa.g_biblioteca.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.felipesa.g_biblioteca.entities.Student;

@Transactional(readOnly = true)
public interface StudentRepository extends JpaRepository<Student, Long>{
	
	@Query(value = "SELECT * FROM TB_STUDENT WHERE REGISTRATION = ?1", nativeQuery = true)
	Student findByRegistration(Integer registration);
	
	@EntityGraph(attributePaths = {"loan", "bookLoan"})
	Page<Student> findAll(Pageable pageable);
	
	@Query("SELECT u FROM Student u")
	List<Student> findAllStudent();
}
