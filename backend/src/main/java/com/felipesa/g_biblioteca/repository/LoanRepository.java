package com.felipesa.g_biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felipesa.g_biblioteca.entities.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long>{
	
}
