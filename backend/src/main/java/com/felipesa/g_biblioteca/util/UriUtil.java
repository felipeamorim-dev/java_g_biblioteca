package com.felipesa.g_biblioteca.util;

import java.net.URI;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.felipesa.g_biblioteca.entities.Book;
import com.felipesa.g_biblioteca.entities.Student;
import com.felipesa.g_biblioteca.entities.dto.BookLoanDTO;

public class UriUtil {
	
	public static URI of() {
		return ServletUriComponentsBuilder.fromCurrentRequest()
				.build()
				.toUri();
	}
	
	public static URI of(Student obj) {
		return ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(obj.getId())
				.toUri();
	}
	
	public static URI of(Book obj) {
		return ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(obj.getIsbn())
				.toUri();
	}
	
	public static URI of(BookLoanDTO obj) {
		return ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(obj.getBook().getIsbn())
				.toUri();
	}
}
