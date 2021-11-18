package com.felipesa.g_biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felipesa.g_biblioteca.entities.Car;

public interface CarRepository extends JpaRepository<Car, Long>{
	
}
