package com.felipesa.g_biblioteca.entities.dto;

import java.io.Serializable;

import org.springframework.lang.NonNull;

public class ViewStudentDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Integer registration;
	@NonNull
	private String name;
	@NonNull
	private String course;
	@NonNull
	private Integer period;
	
	public ViewStudentDTO() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getRegistration() {
		return registration;
	}

	public void setRegistration(Integer registration) {
		this.registration = registration;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public Integer getPeriod() {
		return period;
	}

	public void setPeriod(Integer period) {
		this.period = period;
	}
	

}
