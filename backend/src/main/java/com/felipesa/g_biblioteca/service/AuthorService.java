package com.felipesa.g_biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipesa.g_biblioteca.entities.Author;
import com.felipesa.g_biblioteca.repository.AuthorRepository;
import com.felipesa.g_biblioteca.service.exceptions.ResourceNotFoundException;

@Service
public class AuthorService {
	
	@Autowired
	private AuthorRepository repository;
	
	public List<Author> findAll(){
		List<Author> listAuthors = repository.findAll();
		return listAuthors;
	}
	
	public Author findById(Long id) {
		Optional<Author> obj =  repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
}
