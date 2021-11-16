package com.felipesa.g_biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felipesa.g_biblioteca.entities.BookManagement;

public interface BookManagementRepository extends JpaRepository<BookManagement, String>{
	
}
