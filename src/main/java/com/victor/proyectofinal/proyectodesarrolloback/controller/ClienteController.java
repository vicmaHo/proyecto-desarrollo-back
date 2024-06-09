package com.victor.proyectofinal.proyectodesarrolloback.controller;

import java.util.List;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.victor.proyectofinal.proyectodesarrolloback.controller.dto.ClienteRequest;
import com.victor.proyectofinal.proyectodesarrolloback.controller.dto.ClienteResponse;
import com.victor.proyectofinal.proyectodesarrolloback.service.ClienteService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


// Controlador restful para los clientes, los controladores manejaran las solicitudes HTTP
@RequiredArgsConstructor
@RestController
@RequestMapping("api/clientes") // endpoint
@CrossOrigin(origins = {"http://localhost:5173"})
public class ClienteController {
	
	final private ClienteService service; // Inyeccion del servicio de Cliente
	
	/**
	 * Cuando se hace una peticion get al endpoint del controlador devuelve todos los 
	 * datos de los clientes haciendo uso del servicio
	 * @return Lista de Clientes 
	 */
	@GetMapping
	public List<ClienteResponse> obtenertodos() {
		return service.obtenerTodos();
	}
	
	/**
	 * Cuando se hace una peticion get al endpoint especificado, y se manda su respectivo id,
	 * devuelve los datos del cliente que se encuentra por dicho id
	 * @param id
	 * @return ClienteResponse
	 */
	@GetMapping("/{id}")
	public ClienteResponse obtenerPorId(@PathVariable(name = "id") int id) {
		return service.obtenerPorId(id);
	}
	
	/**
	 * Cuando se hace una peticion post con un ClienteRequest como body, esta funcion lo recibe
	 * y hace uso del service de cliente para crear el nuevo Cliente en la base de datos
	 * @param ClienteRequest
	 * @return ClienteResponse
	 */
	@PostMapping
	public ClienteResponse crear(@RequestBody ClienteRequest entity) {
		return service.crear(entity);	
	}
	
	/**
	 * Cuando se hace una peticion post con los datos actualizados de un cliente y un id,
	 * la funcion hace uso del service para actualizar los datos de un cliente
	 * @param ClienteRequest
	 * @param id
	 * @return ClienteResponse
	 */
	@PutMapping("/{id}")
	public ClienteResponse actualizar(@RequestBody ClienteRequest entity, @PathVariable("id") int id) {
		
		return service.actualizar(entity, id);
	}
	
	/**
	 * Cuando se hace una peticion delete al endpoint especificado, y se manda su respectivo id,
	 * se hace uso del service para eliminar al cliente con dicho id
	 * @param id
	 * @return ClienteResponse
	 */
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable("id") int id) {
		service.eliminar(id);
	}
	
}
