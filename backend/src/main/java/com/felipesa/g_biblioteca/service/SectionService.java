package com.felipesa.g_biblioteca.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.felipesa.g_biblioteca.entities.Section;
import com.felipesa.g_biblioteca.entities.dto.SectionDTO;
import com.felipesa.g_biblioteca.repository.SectionRepository;
import com.felipesa.g_biblioteca.service.exceptions.ResourceNotFoundException;

@Service
public class SectionService {
	
	@Autowired
	private SectionRepository repository;
	
	@Transactional(readOnly = true)
	public Page<SectionDTO> findAll(PageRequest pageRequest){
		Page<Section> listSections = repository.findAll(pageRequest);
		return listSections.map(x -> new SectionDTO(x));
	}
	
	public SectionDTO findById(Long id) {
		Optional<Section> obj =  repository.findById(id);
		return new SectionDTO(obj.orElseThrow(() -> new ResourceNotFoundException(id)));
	}
		
}
