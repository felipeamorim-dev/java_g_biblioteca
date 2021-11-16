package com.felipesa.g_biblioteca.entities.dto;

import java.io.Serializable;

import com.felipesa.g_biblioteca.entities.Section;

public class SectionDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;

	public SectionDTO() {

	}

	public SectionDTO(String name) {
		this.name = name;
	}
	
	public SectionDTO(Section obj) {
		id = obj.getId();
		name = obj.getName();
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

}
