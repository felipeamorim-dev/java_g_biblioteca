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
import com.felipesa.g_biblioteca.entities.dto.SectionDTO;
import com.felipesa.g_biblioteca.service.SectionService;

@RestController
@RequestMapping(value = "/sections")
public class SectionController {
	
	@Autowired
	private SectionService SectionService;
	
	@GetMapping
	public ResponseEntity<Page<SectionDTO>> findAll(
			@RequestParam(name = "page", defaultValue = "0") Integer page,
			@RequestParam(name = "size", defaultValue = "3") Integer size){
		
		PageRequest pageRequest = PageRequest.of(page, size);
		Page<SectionDTO> list = SectionService.findAll(pageRequest);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<SectionDTO> findById(@PathVariable Long id){
		SectionDTO obj = SectionService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
