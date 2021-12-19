package com.felipesa.g_biblioteca.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipesa.g_biblioteca.entities.Student;
import com.felipesa.g_biblioteca.entities.dto.LoanDTO;
import com.felipesa.g_biblioteca.enumtype.StatusEnum;
import com.felipesa.g_biblioteca.service.CarService;
import com.felipesa.g_biblioteca.service.LoanService;
import com.felipesa.g_biblioteca.service.exceptions.ResourceNotFoundException;
import com.felipesa.g_biblioteca.service.exceptions.ValidationErroException;
import com.felipesa.g_biblioteca.util.UriUtil;

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
		if(std == null) throw new ValidationErroException("Erro ao validar o obj student");
		if(carService.findAll().isEmpty()) 
			throw new ResourceNotFoundException(std.getId());
		
		loanService.createLoan(std);
		return ResponseEntity.created(UriUtil.of(std)).build();
	}
	
	@PutMapping(path = "/loan/update/{id}")
	@ApiOperation(value = "Atualiza o stado dos emprestimos que foram finalizados com a devolução dos livros")
	public ResponseEntity<LoanDTO> updateLoan(@PathVariable Long id, StatusEnum status){
		LoanDTO obj = loanService.update(id, status);
		return ResponseEntity.ok().body(obj);
	}
	
}
