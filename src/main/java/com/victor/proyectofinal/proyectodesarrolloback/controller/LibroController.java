package com.victor.proyectofinal.proyectodesarrolloback.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.victor.proyectofinal.proyectodesarrolloback.controller.dto.LibroRequest;
import com.victor.proyectofinal.proyectodesarrolloback.controller.dto.LibroResponse;
import com.victor.proyectofinal.proyectodesarrolloback.service.LibroService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/libros")
public class LibroController {
	
	final private LibroService service; // Inyeccion del servicio de Libro
	
	/**
	 * Cuando se hace una peticion get al endpoint del controlador devuelve todos los 
	 * datos de los libros haciendo uso del servicio
	 * @return Lista de Libros 
	 */
	@GetMapping
	public List<LibroResponse> obtenertodos() {
		return service.obtenerTodos();
	}
	
	/**
	 * Cuando se hace una peticion get al endpoint especificado, y se manda su respectivo id,
	 * devuelve los datos del libro que se encuentra por dicho id
	 * @param id
	 * @return LibroResponse
	 */
	@GetMapping("/{id}")
	public LibroResponse obtenerPorId(@PathVariable(name = "id") int id) {
		return service.obtenerPorId(id);
	}
	
	/**
	 * Cuando se hace una peticion post con un LibroRequest como body, esta funcion lo recibe
	 * y hace uso del service de libro para crear el nuevo Libro en la base de datos
	 * @param LibroRequest
	 * @return LibroResponse
	 */
	@PostMapping
	public LibroResponse crear(@RequestBody LibroRequest entity) {
		return service.crear(entity);	
	}
	
	/**
	 * Cuando se hace una peticion post con los datos actualizados de un libro y un id,
	 * la funcion hace uso del service para actualizar los datos de un libro
	 * @param LibroRequest
	 * @param id
	 * @return LibroResponse
	 */
	@PutMapping("/{id}")
	public LibroResponse actualizar(@RequestBody LibroRequest entity, @PathVariable("id") int id) {
		
		return service.actualizar(entity, id);
	}
	
	/**
	 * Cuando se hace una peticion delete al endpoint especificado, y se manda su respectivo id,
	 * se hace uso del service para eliminar al libro con dicho id
	 * @param id
	 * @return LibroResponse
	 */
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable("id") int id) {
		service.eliminar(id);
	}

}
