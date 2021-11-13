package com.felipesa.g_biblioteca.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.felipesa.g_biblioteca.entities.pk.BookLoanPK;

@Entity
@Table(name = "tb_book_loan")
public class BookLoan implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private BookLoanPK id = new BookLoanPK();

	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date loanDate;

	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date returnDate;

	public BookLoan() {

	}

	public BookLoan(Long id, Date loanDate, Date returnDate, Book book) {
		this.loanDate = loanDate;
		this.returnDate = returnDate;
		
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
