package com.felipesa.g_biblioteca.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipesa.g_biblioteca.entities.BookLoan;
import com.felipesa.g_biblioteca.entities.BookManagement;
import com.felipesa.g_biblioteca.entities.Loan;
import com.felipesa.g_biblioteca.entities.dto.LoanDTO;
import com.felipesa.g_biblioteca.enumtype.StatusEnum;
import com.felipesa.g_biblioteca.repository.BookLoanRepository;
import com.felipesa.g_biblioteca.repository.BookManagementRepository;
import com.felipesa.g_biblioteca.repository.LoanRepository;


@Service
@Transactional
public class LoanService {
	
	@Autowired
	private LoanRepository loanRepository;
	
	@Autowired
	private BookLoanRepository blRepository;
	
	@Autowired
	private BookManagementRepository bmRepository;
	
	
	public LoanDTO findById(Long id) {
		Loan loan = loanRepository.getById(id);
		return new LoanDTO(loan);
	}
	
	
	public void insertLoan(Loan loan, List<BookLoan> bookLoan) {
		BookManagement bmanager = new BookManagement();
		
		loanRepository.save(loan);
		
		blRepository.saveAll(bookLoan);
		
		for (BookLoan bl : bookLoan) {
			bmanager = bl.getBook().getManager().stream().filter(x -> x.getBook().getIsbn().contains(bl.getBook().getIsbn())).findFirst().get();
			int amount = bmanager.getAvailableQuantity() - 1;
			bmanager.setAvailableQuantity(amount);
			bmRepository.save(bmanager);
		}
	}
	
	
	public Loan update(Long id, StatusEnum status) {
		BookManagement bmanager = new BookManagement();
		Loan loan = loanRepository.getById(id);
		loan.setStatus(status);
		try {
			
		if(status == StatusEnum.RETURNED) {
			for(BookLoan bl : loan.getBookLoan()) {
				bmanager = bmRepository.getById(bl.getBook().getIsbn());
				int amount = bmanager.getAvailableQuantity() + 1;
				bmanager.setAvailableQuantity(amount);
				bmRepository.save(bmanager);
			}
		}
		
		loanRepository.save(loan);
			
		} catch (RuntimeException e) {
			e.getStackTrace();
		}
		return loan;
	}
}
