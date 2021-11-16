package com.felipesa.g_biblioteca.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
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
	
	@MapsId("book")
	@ManyToOne
	@JoinColumn(name = "book_isbn")
	private Book book;
	
	@MapsId("loan")
	@ManyToOne
	@JoinColumn(name = "loan_id")
	private Loan loan;

	@Temporal(value = TemporalType.DATE)
	@Column(nullable = false)
	private Date loanDate;

	@Temporal(value = TemporalType.DATE)
	@Column(nullable = false)
	private Date returnDate;

	public BookLoan() {

	}

	public BookLoan(Date loanDate, Date returnDate) {
		this.loanDate = loanDate;
		this.returnDate = returnDate;
	}

	public BookLoanPK getId() {
		return id;
	}

	public void setId(BookLoanPK id) {
		this.id = id;
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
