package com.felipesa.g_biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.felipesa.g_biblioteca.entities.Car;
import com.felipesa.g_biblioteca.repository.CarRepository;
import com.felipesa.g_biblioteca.service.exceptions.ResourceNotFoundException;

@Service
@Transactional
public class CarService {
	
	@Autowired
	private CarRepository repository;
	
	//TODO: Verificar o problema de inicialização da lista de livros emprestados
	public List<Car> findAll() {
		return repository.findAll();
	}
	
	public Car findById(Long id) {
		Optional<Car> obj =  repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public void insert(Car obj){
		try {
			repository.save(obj);
		} catch (IllegalArgumentException e) {
			throw new ResourceNotFoundException(obj.getId());
		}
	}
	
	public void deleteById(Long id) {
		try {
			repository.deleteById(id);	
		} catch (IllegalArgumentException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	public void deleteAll() {
		try {
			repository.deleteAll();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}
}
