package com.felipesa.g_biblioteca.entities.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.felipesa.g_biblioteca.entities.BookLoan;
import com.felipesa.g_biblioteca.entities.Loan;
import com.felipesa.g_biblioteca.entities.Student;
import com.felipesa.g_biblioteca.enumtype.StatusEnum;

public class LoanDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Long id;

	private Student student;
	
	private StatusEnum status;
	
	private List<BookLoan> bookLoan = new ArrayList<>();
	
	public LoanDTO() {
		
	}
	
	public LoanDTO(Loan loan) {
		id = loan.getId();
		student = loan.getStudent();
		status = loan.getStatus();
		bookLoan = loan.getBookLoan();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public List<BookLoan> getBookLoan() {
		return bookLoan;
	}

	public void setBookLoan(List<BookLoan> bookLoan) {
		this.bookLoan = bookLoan;
	}
	
	
}
