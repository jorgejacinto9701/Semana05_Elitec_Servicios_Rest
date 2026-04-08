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

@RestController
@RequestMapping("/rest/Cliente")
public class ClienteController {

	@Autowired
	private ClienteService ClienteService;
	
	
	@PostMapping
	@ResponseBody
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
