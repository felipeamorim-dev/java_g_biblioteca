package com.felipesa.g_biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felipesa.g_biblioteca.entities.Book;

public interface BookRepository extends JpaRepository<Book, String>{
	
}
