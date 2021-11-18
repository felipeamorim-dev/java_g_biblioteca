package com.felipesa.g_biblioteca.config;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.Transactional;

import com.felipesa.g_biblioteca.entities.Book;
import com.felipesa.g_biblioteca.entities.BookLoan;
import com.felipesa.g_biblioteca.entities.Loan;
import com.felipesa.g_biblioteca.entities.Student;
import com.felipesa.g_biblioteca.enumtype.StatusEnum;
import com.felipesa.g_biblioteca.repository.BookRepository;
import com.felipesa.g_biblioteca.repository.StudentRepository;
import com.felipesa.g_biblioteca.service.LoanService;

@Transactional
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	
	
	@Autowired
	private LoanService loanService;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		Student stu = studentRepository.getById(3L);
		Book b = bookRepository.findByIsbn("0132121360");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Loan loan = new Loan();
		
		
		BookLoan bl = new BookLoan();
		bl.setBook(b);
		bl.setLoan(loan);
		bl.setLoanDate(sdf.parse("2021-05-03"));
		bl.setReturnDate(sdf.parse("2021-06-03"));
		
		List<BookLoan> list = new ArrayList<>();
		list.add(bl);
		
		loan.setStudent(stu);
		loan.setStatus(StatusEnum.BORROWED);
		
//		loanService.insertLoan(loan, list);
	}

}
