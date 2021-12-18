package com.felipesa.g_biblioteca.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.felipesa.g_biblioteca.entities.dto.BookLoanDTO;
import com.felipesa.g_biblioteca.entities.dto.ViewCarDTO;
import com.felipesa.g_biblioteca.service.CarService;
import com.felipesa.g_biblioteca.service.LoanService;
import com.felipesa.g_biblioteca.service.exceptions.ValidationErroException;

@RestController
@RequestMapping("/car")
public class CarController {
	
	@Autowired
	private CarService carService;
	
	@Autowired
	private LoanService loanService;
	
	@GetMapping
	public ResponseEntity<List<ViewCarDTO>> getAllCarItens(){
		List<ViewCarDTO> list = carService.getViewAllCar();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping("/insert")
	public ResponseEntity<Void> insertCar(@RequestBody BookLoanDTO bookloanDto){
		if(bookloanDto == null) {
			throw new ValidationErroException("Erro de validação");	
		}
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(bookloanDto.getBook().getIsbn())
				.toUri();
		loanService.insertCar(bookloanDto);
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteCar(@PathVariable Long id){
		carService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/delete/all")
	public ResponseEntity<Void> deleteAllCar(){
		carService.deleteAll();
		return ResponseEntity.noContent().build();
	}
	
}
