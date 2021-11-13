package com.felipesa.g_biblioteca.entities.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.felipesa.g_biblioteca.entities.Book;
import com.felipesa.g_biblioteca.entities.Section;

public class SectionDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	
	private Set<Book> books = new HashSet<>();

	public SectionDTO() {

	}

	public SectionDTO(String name) {
		this.name = name;
	}
	
	public SectionDTO(Section obj) {
		id = obj.getId();
		name = obj.getName();
		books = obj.getBooks();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Book> getBooks() {
		return books;
	}

}
