package com.empresa.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Proveedor;
import com.empresa.service.ProveedorService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/rest/proveedor")
@Tag(name = "Proveedor", description = "Operaciones sobre Proveedor")
public class ProveedorController {

	@Autowired
	private ProveedorService proveedorService;
	
	@PostMapping
	@ResponseBody
	@Operation(summary = "Registrar un nuevo proveedor", description = "Registra un nuevo proveedor en el sistema y devuelve un mensaje de éxito o error")
	@Parameter(name = "objProveedor", description = "Objeto Proveedor a registrar", required = true)
	public ResponseEntity<?> insertaProveedor(@RequestBody Proveedor objProveedor){
		HashMap<String, Object> salida = new HashMap<>();
		objProveedor.setIdProveedor(0);
		objProveedor.setFechaActualizacion(LocalDateTime.now());
		objProveedor.setFechaRegistro(LocalDateTime.now());
		objProveedor.setEstado(1);
		Proveedor objSalida = proveedorService.insertaProveedor(objProveedor);
		salida.put("mensaje", "Proveedor registrado");
		salida.put("data", objSalida);
		return ResponseEntity.ok(salida);
	}
	
	@Operation(summary = "Actualizar un proveedor existente", description = "Actualiza la información de un proveedor existente en el sistema y devuelve un mensaje de éxito o error")
	@Parameter(name = "objProveedor", description = "Objeto Proveedor con la información actualizada", required = true)
	@PutMapping
	@ResponseBody
	public ResponseEntity<?> actualizaProveedor(@RequestBody Proveedor objProveedor){
		HashMap<String, Object> salida = new HashMap<>();
		objProveedor.setFechaActualizacion(LocalDateTime.now());
		Proveedor objSalida = proveedorService.insertaProveedor(objProveedor);
		salida.put("mensaje", "Proveedor actualizado");
	    salida.put("data", objSalida);
		return ResponseEntity.ok(salida);
	}
	
	@Operation(summary = "Eliminar un proveedor", description = "Elimina un proveedor del sistema utilizando su ID y devuelve un mensaje de éxito o error")
	@Parameter(name = "id", description = "ID del proveedor a eliminar", required = true)
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminaProveedor(@PathVariable int id){
		HashMap<String, Object> salida = new HashMap<>();
        proveedorService.eliminaProveedor(id);
        salida.put("mensaje", "Proveedor eliminado");
		return ResponseEntity.ok(salida);
	}
	
	@Operation(summary = "Listar todos los proveedores", description = "Obtiene una lista de todos los proveedores disponibles en el sistema")
	@GetMapping
	public List<Proveedor> listaTodos() {
		return proveedorService.listaTodos();
	}
	
	@Operation(summary = "Listar proveedores por nombre", description = "Obtiene una lista de proveedores cuyo nombre coincide con el filtro proporcionado")
	@Parameter(name = "filtro", description = "Filtro de búsqueda para el nombre del proveedor", required = true)
	@GetMapping("/listaPorNombre/{filtro}")
	public List<Proveedor> listaPorNombre(@PathVariable String filtro) {
		return proveedorService.listaPorNombre(filtro);
	}
	
}






