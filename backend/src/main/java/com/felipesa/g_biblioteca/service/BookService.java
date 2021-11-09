package com.felipesa.g_biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipesa.g_biblioteca.entities.Book;
import com.felipesa.g_biblioteca.repository.BookRepository;
import com.felipesa.g_biblioteca.service.exceptions.ResourceNotFoundException;

@Service
public class BookService {
	
	@Autowired
	private BookRepository repository;
	
	public List<Book> findAll(){
		List<Book> listBooks = repository.findAll();
		return listBooks;
	}
	
	public Book findById(String isbn) {
		Optional<Book> obj =  repository.findById(isbn);
		return obj.orElseThrow(() -> new ResourceNotFoundException(isbn));
	}
	
}
