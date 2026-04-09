package com.empresa.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Cliente;
import com.empresa.service.ClienteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/rest/cliente")
@Tag(name = "Cliente", description = "Operaciones sobre Cliente")
public class ClienteController {

	@Autowired
	private ClienteService ClienteService;
	
	
	@PostMapping
	@ResponseBody
	@Operation(summary = "Registrar un nuevo cliente", description = "Registra un nuevo cliente en el sistema y devuelve un mensaje de éxito o error")
	@Parameter(name = "objCliente", description = "Objeto Cliente a registrar", required = true)
	public ResponseEntity<?> insertaCliente(@RequestBody Cliente objCliente){
		HashMap<String, String> mensaje = new HashMap<>();
		Cliente objSalida = ClienteService.insertaCliente(objCliente);
		if (objSalida == null) {
			mensaje.put("mensaje", "Error en el registro");
		}else {
			mensaje.put("mensaje", "Se ha registrado el Cliente de ID " + objSalida.getIdCliente());
		}
		return ResponseEntity.ok(mensaje);
	}
	
	
}
