package com.empresa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Docente;
import com.empresa.service.DocenteService;

@RestController
@RequestMapping("/rest/docente")
public class DocenteController {

	@Autowired
	private DocenteService docenteService;
	
	@GetMapping("/listaDocentePorNombre/{filtro}")
	public List<Docente> listaDocentePorNombre(@PathVariable String filtro) {
		return docenteService.listaDocentePorNombre(filtro);
	}
}
