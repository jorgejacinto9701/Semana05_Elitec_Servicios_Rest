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

@RestController
@RequestMapping("/rest/docente")
public class DocenteController {

	@Autowired
	private DocenteService docenteService;
	
	
	@PostMapping
	@ResponseBody
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
	
	@GetMapping("/listaDocentePorNombre/{filtro}")
	public List<Docente> listaDocentePorNombre(@PathVariable String filtro) {
		return docenteService.listaDocentePorNombre(filtro);
	}
	
	@GetMapping("/listaDocentePorDni")
	public List<Docente> listaDocentePorDni(@RequestParam String dni) {
		return docenteService.listaDocentePorDni(dni);
	}
	
}
