package com.empresa.service;

import java.util.List;

import com.empresa.entity.Docente;

public interface DocenteService {

	public List<Docente> listaDocentePorNombre(String nombre);
	
}
