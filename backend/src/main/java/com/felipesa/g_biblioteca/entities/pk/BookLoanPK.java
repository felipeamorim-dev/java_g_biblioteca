package com.felipesa.g_biblioteca.entities.pk;

import java.io.Serializable;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.felipesa.g_biblioteca.entities.Book;
import com.felipesa.g_biblioteca.entities.Loan;

public class BookLoanPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "book_isbn")
	private Book book;

	@ManyToOne
	@JoinColumn(name = "loan_id")
	private Loan loan;

	public BookLoanPK() {

	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Loan getLoan() {
		return loan;
	}

	public void setLoan(Loan loan) {
		this.loan = loan;
	}

}
