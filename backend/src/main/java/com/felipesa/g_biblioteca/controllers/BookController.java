package com.felipesa.g_biblioteca.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.felipesa.g_biblioteca.entities.dto.BookDTO;
import com.felipesa.g_biblioteca.service.BookService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "Endpoint da API REST para recuperar dados sobre os livros disponíveis para emprestimos")
@CrossOrigin(origins = "*")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping(value = "/books")
	@ApiOperation(value = "Recupera uma página de dados sobres os livros cadastrados")
	public ResponseEntity<Page<BookDTO>> findAll(
			@RequestParam(name = "page", defaultValue = "0") Integer page,
			@RequestParam(name = "size", defaultValue = "10") Integer size){
		
		PageRequest pageRequest = PageRequest.of(page, size);
		Page<BookDTO> list = bookService.findAll(pageRequest);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/books/{isbn}")
	@ApiOperation(value = "Recupera os dados de um livro através de seu isbn")
	public ResponseEntity<BookDTO> findByIsbn(@PathVariable String isbn){
		BookDTO obj = bookService.findByIsbn(isbn);
		return ResponseEntity.ok().body(obj);
	}
	
}
