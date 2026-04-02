package com.empresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.empresa.entity.Docente;

public interface DocenteRepository extends JpaRepository<Docente, Integer> {
	
	

	@Query("SELECT d FROM Docente d WHERE d.nombre LIKE %:nombre%") 
	public List<Docente> listaPoNombre(String nombre);

}
