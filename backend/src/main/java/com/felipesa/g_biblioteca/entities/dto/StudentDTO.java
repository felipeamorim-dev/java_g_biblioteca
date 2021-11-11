package com.felipesa.g_biblioteca.entities.dto;

import java.io.Serializable;

import com.felipesa.g_biblioteca.entities.Student;

public class StudentDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Integer registration;
	private String name;
	private String course;
	private Integer period;

	public StudentDTO() {

	}

	public StudentDTO(Integer registration, String name, String course, Integer period) {
		this.registration = registration;
		this.name = name;
		this.course = course;
		this.period = period;
	}

	public StudentDTO(Student obj) {
		id = obj.getId();
		registration = obj.getRegistration();
		name = obj.getName();
		course = obj.getCourse();
		period = obj.getPeriod();
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
