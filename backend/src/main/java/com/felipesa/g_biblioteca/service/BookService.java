package com.felipesa.g_biblioteca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.felipesa.g_biblioteca.entities.Book;
import com.felipesa.g_biblioteca.entities.dto.BookDTO;
import com.felipesa.g_biblioteca.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository repository;
	
	@Transactional(readOnly = true)
	public Page<BookDTO> findAll(Pageable pageable){
		Page<Book> listBooks = repository.findAll(pageable);
		return listBooks.map(x -> new BookDTO(x));
	}
	
	@Transactional(readOnly = true)
	public BookDTO findByIsbn(String isbn) {
		Book obj =  repository.findByIsbn(isbn);
		obj.getManager().size(); //operação para inicializar a lista responsavél pela atribuição entre as tabelas de junção dos livros e seção.
		return new BookDTO(obj);
	}
	
}
