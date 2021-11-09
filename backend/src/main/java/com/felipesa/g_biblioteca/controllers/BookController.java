package com.felipesa.g_biblioteca.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipesa.g_biblioteca.entities.Book;
import com.felipesa.g_biblioteca.service.BookService;

@RestController
@RequestMapping(value = "/books")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping
	public ResponseEntity<List<Book>> findAll(){
		List<Book> list = bookService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{isbn}")
	public ResponseEntity<Book> findAById(@PathVariable String isbn){
		Book obj = bookService.findById(isbn);
		return ResponseEntity.ok().body(obj);
	}
	
}
