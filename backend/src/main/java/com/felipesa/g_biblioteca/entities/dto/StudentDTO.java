package com.felipesa.g_biblioteca.entities.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.felipesa.g_biblioteca.entities.Loan;
import com.felipesa.g_biblioteca.entities.Student;

public class StudentDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Integer registration;
	private String name;
	private String course;
	private Integer period;
	private List<Loan> loan = new ArrayList<>();

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
		loan = obj.getLoan();
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

	public List<Loan> getLoan() {
		return loan;
	}

	public void setLoan(List<Loan> loan) {
		this.loan = loan;
	}

}
