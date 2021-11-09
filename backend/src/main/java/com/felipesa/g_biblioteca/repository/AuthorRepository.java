package com.felipesa.g_biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felipesa.g_biblioteca.entities.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>{


}
