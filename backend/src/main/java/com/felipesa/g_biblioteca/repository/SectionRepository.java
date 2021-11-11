package com.felipesa.g_biblioteca.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.felipesa.g_biblioteca.entities.Section;

public interface SectionRepository extends JpaRepository<Section, Long>{
	
	Page<Section> findAll(Pageable pageable);
}
