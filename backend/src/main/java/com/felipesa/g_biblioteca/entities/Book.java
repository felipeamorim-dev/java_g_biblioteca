package com.felipesa.g_biblioteca.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_books")
public class Book implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(nullable = false, unique = true)
	private String isbn; // Será utilizado o isbn de 10 digitos para identificar os livros
	private String name;
	private Integer numberEdition;
	private Integer copyright;
	private String author;

	@OneToMany(mappedBy = "id.book", cascade = CascadeType.ALL)
	private Set<BookManagement> manager = new HashSet<>();

	@OneToMany(mappedBy = "id.loan", cascade = CascadeType.ALL)
	private Set<BookLoan> bookLoan = new HashSet<>();

	public Book() {
	}

	public Book(String isbn, String name, Integer numberEdition, Integer copyright, String author) {
		this.isbn = isbn;
		this.name = name;
		this.numberEdition = numberEdition;
		this.copyright = copyright;
		this.setAuthor(author);
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNumberEdition() {
		return numberEdition;
	}

	public void setNumberEdition(Integer numberEdition) {
		this.numberEdition = numberEdition;
	}

	public Integer getCopyright() {
		return copyright;
	}

	public void setCopyright(Integer copyright) {
		this.copyright = copyright;
	}

	@JsonIgnore
	public Set<BookManagement> getManager() {
		return manager;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	@JsonIgnore
	public Set<BookLoan> getBookLoan() {
		return bookLoan;
	}

	@Override
	public int hashCode() {
		return Objects.hash(isbn);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(isbn, other.isbn);
	}

}
