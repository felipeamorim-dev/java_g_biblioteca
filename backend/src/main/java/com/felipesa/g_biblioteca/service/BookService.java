package com.felipesa.g_biblioteca.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.felipesa.g_biblioteca.entities.Book;
import com.felipesa.g_biblioteca.entities.dto.BookDTO;
import com.felipesa.g_biblioteca.repository.BookRepository;
import com.felipesa.g_biblioteca.service.exceptions.ResourceNotFoundException;

@Service
public class BookService {
	
	@Autowired
	private BookRepository repository;
	
	public Page<BookDTO> findAll(Pageable pageable){
		Page<Book> listBooks = repository.findAll(pageable);
		return listBooks.map(x -> new BookDTO(x));
	}
	
	public BookDTO findById(String isbn) {
		Optional<Book> obj =  repository.findById(isbn);
		return new BookDTO(obj.orElseThrow(() -> new ResourceNotFoundException(isbn)));
	}
	
}
