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

import com.felipesa.g_biblioteca.entities.dto.SectionDTO;
import com.felipesa.g_biblioteca.service.SectionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "Endpoint da API REST recuperar dados sobres as seções dos livros")
@CrossOrigin(origins = "*")
public class SectionController {
	
	@Autowired
	private SectionService service;
	
	@GetMapping(value = "/sections")
	@ApiOperation(value = "Recupera todas as seções de livros disponíveis")
	public ResponseEntity<Page<SectionDTO>> findAll(
			@RequestParam(name = "page", defaultValue = "0") Integer page,
			@RequestParam(name = "size", defaultValue = "3") Integer size){
		
		PageRequest pageRequest = PageRequest.of(page, size);
		Page<SectionDTO> list = service.findAll(pageRequest);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/sections/{id}")
	@ApiOperation(value = "Recupera um seção baseada em seu id")
	public ResponseEntity<SectionDTO> findById(@PathVariable Long id){
		SectionDTO obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
