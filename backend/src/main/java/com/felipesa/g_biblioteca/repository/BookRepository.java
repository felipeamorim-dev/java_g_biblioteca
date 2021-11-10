package com.felipesa.g_biblioteca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.felipesa.g_biblioteca.entities.Book;

public interface BookRepository extends JpaRepository<Book, String>{
	
	@EntityGraph(attributePaths = "authors")
	List<Book> findAll();
}
