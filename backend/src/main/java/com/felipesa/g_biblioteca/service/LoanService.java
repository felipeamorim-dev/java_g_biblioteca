package com.felipesa.g_biblioteca.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipesa.g_biblioteca.entities.BookLoan;
import com.felipesa.g_biblioteca.entities.BookManagement;
import com.felipesa.g_biblioteca.entities.Car;
import com.felipesa.g_biblioteca.entities.Loan;
import com.felipesa.g_biblioteca.entities.Student;
import com.felipesa.g_biblioteca.entities.dto.BookLoanDTO;
import com.felipesa.g_biblioteca.entities.dto.LoanDTO;
import com.felipesa.g_biblioteca.enumtype.StatusEnum;
import com.felipesa.g_biblioteca.repository.BookLoanRepository;
import com.felipesa.g_biblioteca.repository.BookManagementRepository;
import com.felipesa.g_biblioteca.repository.LoanRepository;
import com.felipesa.g_biblioteca.repository.StudentRepository;


@Service
@Transactional
public class LoanService {
	
	@Autowired
	private LoanRepository loanRepository;
	
	@Autowired
	private BookLoanRepository blRepository;
	
	@Autowired
	private BookManagementRepository bmRepository;
	
	@Autowired
	private CarService carService;
	
	@Autowired
	private StudentRepository studentRepository;
	
	
	public LoanDTO findById(Long id) {
		Loan loan = loanRepository.getById(id);
		loan.getStudent().getLoan().size();
		return new LoanDTO(loan);
	}
	
	public void createLoan(Student std) {
		Loan loan = new Loan();
		List<BookLoan> list = new ArrayList<>();
		
		try {
			std = studentRepository.getById(std.getId());
			loan.setStudent(std);
			loan.setStatus(StatusEnum.BORROWED);
			
			List<Car> bld = carService.findAll();
			
			bld.stream().map(x -> list.add(new BookLoan(loan, x.getBook(), x.getLoanDate(), x.getReturnDate())))
						.collect(Collectors.toList());
			
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		
		insertLoan(loan, list);
		carService.deleteAll();
		
	}
	
	public void insertCar(BookLoanDTO bookLoanDTO) {
		try {
			Car car = new Car();
			car.setBook(bookLoanDTO.getBook());
			car.setLoanDate(bookLoanDTO.getLoanDate());
			car.setReturnDate(bookLoanDTO.getReturnDate());
			carService.insert(car);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}
	
	public void insertLoan(Loan loan, List<BookLoan> bookLoan) {
		BookManagement bmanager = new BookManagement();
		try {
			loanRepository.save(loan);
			blRepository.saveAll(bookLoan);
			
			for (BookLoan bl : bookLoan) {
				bmanager = bl.getBook().getManager().stream().filter(x -> x.getBook().getIsbn().contains(bl.getBook().getIsbn())).findFirst().get();
				int amount = bmanager.getAvailableQuantity() - 1;
				bmanager.setAvailableQuantity(amount);
				bmRepository.save(bmanager);
			}
			
		} catch (RuntimeException e) {
			e.getStackTrace();
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
