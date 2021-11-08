package com.felipesa.g_biblioteca.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_books")
public class Book implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(nullable = false, unique = true)
	private String isbn; // Será utilizado o isbn de 10 digitos para identificar os livros
	private String name;
	private Integer numberEdition;
	private Integer copyright;
	
	@ManyToMany
	@JoinTable(name = "tb_books_authors", 
		joinColumns = @JoinColumn(name = "isbn"), 
		inverseJoinColumns = @JoinColumn(name = "author_id"))
	private Set<Author> authors = new HashSet<>();

	public Book() {

	}

	public Book(String isbn, String name, Integer numberEdition, Integer copyright) {
		this.isbn = isbn;
		this.name = name;
		this.numberEdition = numberEdition;
		this.copyright = copyright;
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
