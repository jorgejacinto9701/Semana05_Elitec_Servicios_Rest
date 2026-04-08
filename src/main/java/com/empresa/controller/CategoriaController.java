package com.empresa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Categoria;
import com.empresa.service.CategoriaService;

@RestController
@RequestMapping("/rest/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaService CategoriaService;
	
	
	@GetMapping("/listaTodos")
	public List<Categoria> listaCategoriaPorNombre() {
		return CategoriaService.listaTodosCategoria();
	}

	
}
