package com.felipesa.g_biblioteca.entities.dto;

import java.io.Serializable;

import com.felipesa.g_biblioteca.entities.Book;
import com.felipesa.g_biblioteca.entities.Car;

public class ViewCarDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long id;
	private Book book;
	
	public ViewCarDTO() {
		
	}
	
	public ViewCarDTO(Car obj) {
		setId(obj.getId());
		setBook(obj.getBook());
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
	
	
}
