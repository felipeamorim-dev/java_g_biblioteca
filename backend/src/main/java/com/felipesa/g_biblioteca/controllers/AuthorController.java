package com.felipesa.g_biblioteca.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipesa.g_biblioteca.entities.Author;
import com.felipesa.g_biblioteca.service.AuthorService;

@RestController
@RequestMapping(value = "/authors")
public class AuthorController {
	
	@Autowired
	private AuthorService authorService;
	
	@GetMapping
	public ResponseEntity<List<Author>> findAll(){
		List<Author> list = authorService.findAll();
		return ResponseEntity.ok(list);
	}
}
