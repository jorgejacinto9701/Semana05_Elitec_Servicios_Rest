package com.empresa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Categoria;
import com.empresa.service.CategoriaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/rest/categoria")
@Tag(name = "Categoría", description = "Operaciones sobre categoria")
public class CategoriaController {

	@Autowired
	private CategoriaService CategoriaService;
	
	
	@GetMapping("/listaTodos")
	@Operation(summary = "Lista todas las categorías", description = "Obtiene una lista de todas las categorías disponibles")
	public List<Categoria> listaCategoriaPorNombre() {
		return CategoriaService.listaTodosCategoria();
	}

	
}
