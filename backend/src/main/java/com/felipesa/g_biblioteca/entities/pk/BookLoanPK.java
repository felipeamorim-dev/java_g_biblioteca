package com.felipesa.g_biblioteca.entities.pk;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;

public class BookLoanPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "book_isbn")
	private String book;

	@Column(name = "loan_id")
	private Long loan;

	public BookLoanPK() {

	}

	public String getBook() {
		return book;
	}

	public void setBook(String book) {
		this.book = book;
	}

	public Long getLoan() {
		return loan;
	}

	public void setLoan(Long loan) {
		this.loan = loan;
	}

	@Override
	public int hashCode() {
		return Objects.hash(book, loan);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookLoanPK other = (BookLoanPK) obj;
		return Objects.equals(book, other.book) && Objects.equals(loan, other.loan);
	}

}
