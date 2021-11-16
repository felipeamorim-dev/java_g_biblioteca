package com.felipesa.g_biblioteca.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.felipesa.g_biblioteca.entities.Book;

public interface BookRepository extends JpaRepository<Book, String>{
	
	
	Page<Book> findAll(Pageable pageable);
	
	@Query(	"SELECT u FROM Book u WHERE u.isbn = ?1")
	Book findByIsbn(String isbn);
	
}
