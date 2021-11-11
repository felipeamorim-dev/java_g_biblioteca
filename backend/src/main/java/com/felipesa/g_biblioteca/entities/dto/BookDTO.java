package com.felipesa.g_biblioteca.entities.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.felipesa.g_biblioteca.entities.Author;
import com.felipesa.g_biblioteca.entities.Book;

public class BookDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String isbn;
	private String name;
	private Integer numberEdition;
	private Integer copyright;
	
	private List<Author> authors = new ArrayList<>();
	
	public BookDTO() {
		
	}

	public BookDTO(String isbn, String name, Integer numberEdition, Integer copyright) {
		this.isbn = isbn;
		this.name = name;
		this.numberEdition = numberEdition;
		this.copyright = copyright;
	}
	
	public BookDTO(Book book) {
		isbn = book.getIsbn();
		name = book.getName();
		numberEdition = book.getNumberEdition();
		copyright = book.getCopyright();
		authors = book.getAuthors();
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

	public List<Author> getAuthors() {
		return authors;
	}

}
