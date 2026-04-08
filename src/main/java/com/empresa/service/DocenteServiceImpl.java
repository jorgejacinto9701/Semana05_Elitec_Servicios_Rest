package com.empresa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Docente;
import com.empresa.repository.DocenteRepository;

@Service
public class DocenteServiceImpl implements DocenteService {

	@Autowired
	private DocenteRepository docenteRepository;
	
	@Override
	public List<Docente> listaDocentePorNombre(String nombre) {
		return docenteRepository.listaPoNombre(nombre);
	}

	@Override
	public List<Docente> listaDocentePorDni(String dni) {
		return docenteRepository.findByDni(dni);
	}

	@Override
	public Docente insertaDocente(Docente objDocente) {
		return docenteRepository.save(objDocente);
	}
	
}
