package com.felipesa.g_biblioteca.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipesa.g_biblioteca.entities.BookLoan;
import com.felipesa.g_biblioteca.entities.Loan;
import com.felipesa.g_biblioteca.entities.dto.LoanDTO;
import com.felipesa.g_biblioteca.service.LoanService;

@RestController
@RequestMapping(value = "/loan")
public class LoanController {
	
	@Autowired
	private LoanService loanService;
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<LoanDTO> findById(@PathVariable Long id){
		LoanDTO obj = loanService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Loan loan,@RequestBody List<BookLoan> bookLoan){
		loanService.insertLoan(loan, bookLoan);
		return ResponseEntity.noContent().build();
	}
	
}
