package com.felipesa.g_biblioteca.controllers;

import java.util.ArrayList;
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
	
	//TODO: O MÉTODO NÃO ESTÁ INSERINDO CORRETAMENTE OS VALORES PARA A ENTIDADE LOAN
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Loan loan){
		List<BookLoan> bookLoan = new ArrayList<>();
		bookLoan = loan.getBookLoan();
		loanService.insertLoan(loan, bookLoan);
		return ResponseEntity.noContent().build();
	}
	
}
