package com.felipesa.g_biblioteca;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.PersistenceContext;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.felipesa.g_biblioteca.repository.BookManagementRepository;
import com.felipesa.g_biblioteca.repository.BookRepository;

@PersistenceContext
@SpringBootTest
class GBibliotecaApplicationTests {
	
	@Autowired
	private BookManagementRepository repo;
	
	@Autowired
	private BookRepository bookRepo;
	
	@Test
	void findBookManagement() {
		assertNotNull(repo.findAll());
	}
	
	@Test
	void findBookAll() {
		assertNotNull(bookRepo);
	}

}
