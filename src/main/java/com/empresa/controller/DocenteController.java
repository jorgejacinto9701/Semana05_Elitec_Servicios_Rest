package com.empresa.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Docente;
import com.empresa.service.DocenteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/rest/docente")
@Tag(name = "Docente", description = "Operaciones sobre docente")
public class DocenteController {

	@Autowired
	private DocenteService docenteService;
	
	
	@PostMapping
	@ResponseBody
	@Operation(summary = "Registrar un nuevo docente", description = "Registra un nuevo docente en el sistema y devuelve un mensaje de éxito o error")
	@Parameter(name = "objDocente", description = "Objeto Docente a registrar", required = true)
	public ResponseEntity<?> insertaDocente(@RequestBody Docente objDocente){
		HashMap<String, String> mensaje = new HashMap<>();
		Docente objSalida = docenteService.insertaDocente(objDocente);
		if (objSalida == null) {
			mensaje.put("mensaje", "Error en el registro");
		}else {
			mensaje.put("mensaje", "Se ha registrado el Docente de ID " + objSalida.getIdDocente());
		}
		return ResponseEntity.ok(mensaje);
	}
	
	@Operation(summary = "Listar docentes por nombre", description = "Obtiene una lista de docentes cuyo nombre coincide con el filtro proporcionado")
	@Parameter(name = "filtro", description = "Filtro de búsqueda para el nombre del docente", required = true)
	@GetMapping("/listaDocentePorNombre/{filtro}")
	public List<Docente> listaDocentePorNombre(@PathVariable String filtro) {
		return docenteService.listaDocentePorNombre(filtro);
	}
	
	@Operation(summary = "Listar docentes por DNI", description = "Obtiene una lista de docentes cuyo DNI coincide con el filtro proporcionado")
	@Parameter(name = "dni", description = "Filtro de búsqueda para el DNI del docente", required = true)
	@GetMapping("/listaDocentePorDni")
	public List<Docente> listaDocentePorDni(@RequestParam String dni) {
		return docenteService.listaDocentePorDni(dni);
	}
	
}
