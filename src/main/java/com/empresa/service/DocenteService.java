package com.empresa.service;

import java.util.List;

import com.empresa.entity.Docente;

public interface DocenteService {

	public abstract List<Docente> listaDocentePorNombre(String nombre);
	
	public abstract List<Docente> listaDocentePorDni(String dni);
	
	public abstract Docente insertaDocente(Docente objDocente);
	
	
}
