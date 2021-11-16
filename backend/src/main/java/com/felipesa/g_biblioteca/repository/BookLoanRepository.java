package com.felipesa.g_biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felipesa.g_biblioteca.entities.BookLoan;

public interface BookLoanRepository extends JpaRepository<BookLoan, Long>{

}
