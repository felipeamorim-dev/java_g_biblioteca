package com.felipesa.g_biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.felipesa.g_biblioteca.entities.BookManagement;

public interface BookManagementRepository extends JpaRepository<BookManagement, String>{
	
	@Query("SELECT u FROM BookManagement u JOIN u.id x WHERE x.book.isbn = ?1 ")
	BookManagement findByIsbn(String isbn);
}
