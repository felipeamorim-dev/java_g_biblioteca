package com.felipesa.g_biblioteca;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.PersistenceContext;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.felipesa.g_biblioteca.repository.SectionRepository;

@PersistenceContext
@SpringBootTest
public class SectionRepositoryTest {
	
	private SectionRepository repo;
	
	
	@Test
	public void findAll() {
		assertNotNull(repo.findById(1L));
	}
}
