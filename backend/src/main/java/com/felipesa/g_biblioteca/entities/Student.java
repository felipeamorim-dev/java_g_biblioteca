package com.felipesa.g_biblioteca.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "tb_student")
@ApiModel(description = "Modelo base da estrutura de dados para persistenicia na tabela de estudantes")
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "Id do Estudante")
	private Long id;

	@Column(nullable = false)
	@ApiModelProperty(value = "Número de registro do Estudante")
	private Integer registration;

	@NonNull
	@ApiModelProperty(value = "Nome do Estudante")
	private String name;
	
	@NonNull
	@ApiModelProperty(value = "Curso do Estudante")
	private String course;
	
	@NonNull
	@ApiModelProperty(value = "Período que está cursando o Estudante")
	private Integer period;
	
	@OneToMany(mappedBy = "student", cascade = { CascadeType.PERSIST, CascadeType.MERGE }, 
			fetch = FetchType.LAZY)
	@Fetch(FetchMode.JOIN)
	@ApiModelProperty(value = "Lista de emprestimos que esse estudante possui")
	private List<Loan> loan = new ArrayList<>();

	public Student() {

	}

	public Student(Long id, Integer registration, String name, String course, Integer period) {
		super();
		this.id = id;
		this.registration = registration;
		this.name = name;
		this.course = course;
		this.period = period;
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
	
	@JsonIgnore
	public List<Loan> getLoan() {
		return loan;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(id, other.id);
	}
}
