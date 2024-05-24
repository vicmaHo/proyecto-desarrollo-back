package com.victor.proyectofinal.proyectodesarrolloback.service;

import java.util.List;
import com.victor.proyectofinal.proyectodesarrolloback.controller.dto.LibroRequest;
import com.victor.proyectofinal.proyectodesarrolloback.controller.dto.LibroResponse;

public interface LibroService {
	
	/**
	 * Hace uso del repository de libros para obtener todos los libros, posteriormente
	 * a cada libro se le hace su transfomacion a un libro response
	 * @return Lista de LibroResponse
	 */
	List<LibroResponse> obtenerTodos();
	
	
	/**
	 * Hace uso del repository de libros para obtener un libro por su id, posteriormente
	 * este libro se transforma en un libro response y se devuelve al controlador
	 * @param int id de libro a obtener
	 * @return LibroResponse
	 */
	LibroResponse obtenerPorId(int id);
	
	/**
	 * Hace uso del repository de libros para crear un nuevo libro en la base de datos, se recibe un LibroRequest
	 * este se mapea a un Libro y se agrega a la base de datos
	 * @param LibroRequest Body json como payload
	 * @return Lista de LibroResponse
	 */
	LibroResponse crear(LibroRequest nuevoLibro);
	
	/**
	 * Hace uso del repository de libros para actualizar la informacion de un libro en la base de datos,
	 * se recibe un LibroRequest con los nuevos datos y el id del Libro a actualizar, a continuación se extrae
	 * el Libro a traves del repository con el id, y a este libro se le asignan los nuevos atributos con sus funciones 
	 * set, posteriormente este Libro actualizado se guarda en la base de datos y se devuelve un mapeo a LibroResponse
	 * @param LibroRequest 
	 * @param id 
	 * @return LibroResponse
	 */
	LibroResponse actualizar(LibroRequest libro, int id);

	/**
	 * Hace uso del respository de libro para eliminar mediante el id el Libro especificado
	 * @param id
	 * @return void
	 */
	void eliminar(int id);
}
