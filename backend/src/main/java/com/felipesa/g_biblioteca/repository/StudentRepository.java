package com.felipesa.g_biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felipesa.g_biblioteca.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
