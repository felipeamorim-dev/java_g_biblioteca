package com.felipesa.g_biblioteca.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.felipesa.g_biblioteca.entities_interface.BookManagerInterface;
import com.felipesa.g_biblioteca.enumtype.StatusEnum;


@Entity
@Table(name = "tb_loan")
public class Loan implements BookManagerInterface , Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student;
	
	private StatusEnum status;
	
	@OneToMany
	@JoinColumn(name = "bookLoan_id")
	private Set<BookLoan> bookLoan = new HashSet<>();
	
	public Loan() {
		
	}
	
	public Loan(Student student, StatusEnum status, Set<BookLoan> bookLoan) {
		this.student = student;
		this.status = status;
		this.bookLoan = bookLoan;
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

	public void setBookLoan(Set<BookLoan> bookLoan) {
		this.bookLoan = bookLoan;
	}

	@Override
	public void updateAmountBook() {
		//TODO: Realizar a atualização do estoque de livros
		
	}

	@Override
	public void updateStatusLoan(StatusEnum status) {
		this.status = status;
		
	}
	
}
