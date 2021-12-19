package com.felipesa.g_biblioteca.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipesa.g_biblioteca.entities.Student;
import com.felipesa.g_biblioteca.entities.dto.LoanDTO;
import com.felipesa.g_biblioteca.service.CarService;
import com.felipesa.g_biblioteca.service.LoanService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "Endpoint da API REST para manipular os emprestimos de livros")
@CrossOrigin(origins = "*")
public class LoanController {
	
	@Autowired
	private LoanService loanService;
	@Autowired
	private CarService carService;
	
	@GetMapping(path = "/loan/{id}")
	@ApiOperation(value = "Recupera os pedidos de emprestimos por id")
	public ResponseEntity<LoanDTO> findById(@PathVariable Long id){
		LoanDTO obj = loanService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping(path = "/loan/create")
	@ApiOperation(value = "Cria um imprestimo e o vincula ao estudante passado como parâmetro")
	public ResponseEntity<Void> createLoan(@RequestBody Student std) {
		if(std != null) loanService.createLoan(std);
		if(carService.findAll().isEmpty()) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.noContent().build();
		}
	}
	
}
