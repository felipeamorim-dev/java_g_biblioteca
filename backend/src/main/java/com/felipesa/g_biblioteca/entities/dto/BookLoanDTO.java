package com.felipesa.g_biblioteca.entities.dto;

import java.io.Serializable;
import java.util.Date;

import com.felipesa.g_biblioteca.entities.Book;

public class BookLoanDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Book book;
	private Date loanDate;
	private Date returnDate;
	
	public BookLoanDTO() {
		
	}

	public BookLoanDTO(Book book, Date loanDate, Date returnDate) {
		this.book = book;
		this.loanDate = loanDate;
		this.returnDate = returnDate;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Date getLoanDate() {
		return loanDate;
	}

	public void setLoanDate(Date loanDate) {
		this.loanDate = loanDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	
}
