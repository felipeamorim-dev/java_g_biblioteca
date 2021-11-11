package com.felipesa.g_biblioteca.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.felipesa.g_biblioteca.entities.dto.BookDTO;
import com.felipesa.g_biblioteca.service.BookService;

@RestController
@RequestMapping(value = "/books")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping
	public ResponseEntity<Page<BookDTO>> findAll(
			@RequestParam(name = "page", defaultValue = "0") Integer page,
			@RequestParam(name = "size", defaultValue = "10") Integer size){
		
		PageRequest pageRequest = PageRequest.of(page, size);
		Page<BookDTO> list = bookService.findAll(pageRequest);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{isbn}")
	public ResponseEntity<BookDTO> findAById(@PathVariable String isbn){
		BookDTO obj = bookService.findById(isbn);
		return ResponseEntity.ok().body(obj);
	}
	
}
