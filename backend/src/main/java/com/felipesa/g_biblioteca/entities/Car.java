package com.felipesa.g_biblioteca.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "tb_car")
@ApiModel(description = "Modelo base para pesistir no carrinho de emprestimos")
public class Car implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "Id do item adicionado ao carrinho")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "isbn_id")
	@ApiModelProperty(value = "Livro adicionado ao carrinho")
	private Book book;
	
	@Temporal(TemporalType.DATE)
	@ApiModelProperty(value = "Data da realização do emprestimo")
	private Date loanDate;
	
	@Temporal(TemporalType.DATE)
	@ApiModelProperty(value = "Data de devolução dos livros emprestados")
	private Date returnDate;
	
	public Car() {
		
	}

	public Car(Long id, Book book, Date loanDate, Date returnDate) {
		this.id = id;
		this.book = book;
		this.loanDate = loanDate;
		this.returnDate = returnDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
