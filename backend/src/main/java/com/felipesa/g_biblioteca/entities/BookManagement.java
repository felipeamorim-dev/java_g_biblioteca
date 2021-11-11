package com.felipesa.g_biblioteca.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.felipesa.g_biblioteca.entities.pk.BookSectionPK;

@Entity
@Table(name = "tb_book_management")
public class BookManagement implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private BookSectionPK id = new BookSectionPK();
	
	private Integer availableQuantity;
	private Integer totalAmount;

	
	public BookManagement() {

	}

	public BookManagement(Book book, Section section, Integer availableQuantity, Integer totalAmount) {
		this.availableQuantity = availableQuantity;
		this.totalAmount = totalAmount;
		id.setBook(book);
		id.setSection(section);
	}
	
	public Book getBook() {
		return id.getBook();
	}
	
	public void setBook(Book book) {
		id.setBook(book);
	}

	public Integer getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(Integer availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	public Integer getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}

}
