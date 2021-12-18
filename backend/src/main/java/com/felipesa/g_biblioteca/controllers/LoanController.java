package com.felipesa.g_biblioteca.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipesa.g_biblioteca.entities.Student;
import com.felipesa.g_biblioteca.entities.dto.BookLoanDTO;
import com.felipesa.g_biblioteca.entities.dto.LoanDTO;
import com.felipesa.g_biblioteca.service.CarService;
import com.felipesa.g_biblioteca.service.LoanService;

@RestController
@RequestMapping(value = "/loan")
public class LoanController {
	
	@Autowired
	private LoanService loanService;
	@Autowired
	private CarService carService;
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<LoanDTO> findById(@PathVariable Long id){
		LoanDTO obj = loanService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Void> insertCar(@RequestBody BookLoanDTO bookloanDto){
		if(bookloanDto != null) {
			loanService.insertCar(bookloanDto);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@PostMapping(path = "/create")
	public ResponseEntity<Void> createLoan(@RequestBody Student std) {
		if(std != null) loanService.createLoan(std);
		if(carService.findAll().isEmpty()) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.noContent().build();
		}
	}
	
}
