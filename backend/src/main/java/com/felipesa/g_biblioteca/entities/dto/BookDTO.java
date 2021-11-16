package com.felipesa.g_biblioteca.entities.dto;

import java.io.Serializable;

import com.felipesa.g_biblioteca.entities.Book;

public class BookDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String isbn;
	private String name;
	private Integer numberEdition;
	private Integer copyright;
	private String author;
	private Integer availableQuantity;
	private Integer totalAmount;
	private String section;

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
		author = book.getAuthor();
		setAvailableQuantity(book.getManager().stream()
				.filter(x -> x.getBook().getIsbn() == isbn)
				.findFirst()
				.get()
				.getAvailableQuantity());
		setTotalAmount(book.getManager().stream()
				.filter(x -> x.getBook().getIsbn() == isbn)
				.findFirst()
				.get()
				.getTotalAmount());
		setSection(book.getManager().stream()
				.filter(x -> x.getBook().getIsbn() == isbn)
				.findFirst()
				.get()
				.getSection().getName());
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
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

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

}
