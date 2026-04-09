package com.empresa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Medicamento;
import com.empresa.service.MedicamentoServicelmpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/rest/medicamento")
@Tag(name = "Medicamento", description = "Operaciones sobre Medicamento")
public class MedicamentoController {
	
	@Autowired
	private MedicamentoServicelmpl medicamentoService;

	
	@Operation(summary = "Lista medicamentos por nombre", description = "Obtiene una lista de medicamentos que coinciden con el filtro de nombre proporcionado")
	@Parameter(name = "filtro", description = "Filtro de búsqueda para el nombre del medicamento", required = true)
	@GetMapping("/listaMedicamentoPorNombre/{filtro}")
	public List<Medicamento> listaMedicamentoPorNombre(@PathVariable String filtro) {
		return medicamentoService.listaMedicamentoPorNombre(filtro);
	}
	
	@Operation(summary = "Lista medicamentos por stock", description = "Obtiene una lista de medicamentos cuyo stock se encuentra entre los valores proporcionados")
	@Parameter(name = "desde", description = "Valor mínimo del stock", required = true)
	@GetMapping("/listaPorStock")
	public List<Medicamento> listaMedicamentoPorStock(@RequestParam int desde, @RequestParam int hasta) {
		return medicamentoService.listaMedicamentoPorStock(desde, hasta);
	}

}
