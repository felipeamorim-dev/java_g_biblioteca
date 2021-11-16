package com.felipesa.g_biblioteca.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipesa.g_biblioteca.entities.BookLoan;
import com.felipesa.g_biblioteca.entities.BookManagement;
import com.felipesa.g_biblioteca.entities.Loan;
import com.felipesa.g_biblioteca.repository.BookLoanRepository;
import com.felipesa.g_biblioteca.repository.BookManagementRepository;
import com.felipesa.g_biblioteca.repository.LoanRepository;


@Service
public class LoanService {
	
	@Autowired
	private LoanRepository loanRepository;
	
	@Autowired
	private BookLoanRepository bookLoanRepository;
	
	@Autowired
	private BookManagementRepository managerRepository;
	
	@Transactional
	public void insertLoan(Loan loan, List<BookLoan> bookLoan) {
		loanRepository.save(loan);
		bookLoanRepository.saveAll(bookLoan);
		
		for(BookLoan x : bookLoan) {
			BookManagement obj = managerRepository.findByIsbn(x.getBook().getIsbn());
			int result = obj.getAvailableQuantity() - 1;
			obj.setAvailableQuantity(result);
			managerRepository.save(obj);
		}
		
	}
}
