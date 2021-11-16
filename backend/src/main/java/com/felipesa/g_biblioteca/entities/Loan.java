package com.felipesa.g_biblioteca.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.felipesa.g_biblioteca.enumtype.StatusEnum;

@Entity
@Table(name = "tb_loan")
public class Loan implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student;
	
	@Enumerated(EnumType.STRING)
	private StatusEnum status;
	
	@OneToMany(mappedBy = "id.loan", cascade = {CascadeType.PERSIST , CascadeType.MERGE})
	private List<BookLoan> bookLoan = new ArrayList<>();

	public Loan() {

	}

	public Loan(Student student, StatusEnum status, List<BookLoan> bookLoan) {
		this.student = student;
		this.setStatus(status);
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

	public void setStatus(StatusEnum status) {
		this.status = status;
	}
	
	public List<BookLoan> getBookLoan() {
		return bookLoan;
	}
	
	public void setBookLoan(List<BookLoan> bookLoan) {
		this.bookLoan = bookLoan;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Loan other = (Loan) obj;
		return Objects.equals(id, other.id);
	}

}
