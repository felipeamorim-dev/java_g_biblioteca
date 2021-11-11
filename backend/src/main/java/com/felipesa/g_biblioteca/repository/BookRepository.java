package com.felipesa.g_biblioteca.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.felipesa.g_biblioteca.entities.Book;

public interface BookRepository extends JpaRepository<Book, String>{
	
	@EntityGraph(attributePaths = "authors")
	Page<Book> findAll(Pageable pageable);
}
