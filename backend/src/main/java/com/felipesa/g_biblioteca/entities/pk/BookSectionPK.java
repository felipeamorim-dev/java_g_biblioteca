package com.felipesa.g_biblioteca.entities.pk;

import java.io.Serializable;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.felipesa.g_biblioteca.entities.Book;
import com.felipesa.g_biblioteca.entities.Section;

public class BookSectionPK implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "isbn_id")
	private Book book;
	
	@ManyToOne
	@JoinColumn(name = "section_id")
	private Section section;
	
	public BookSectionPK() {
		
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}
	
}
