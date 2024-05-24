package com.victor.proyectofinal.proyectodesarrolloback.service;

import java.util.List;
import com.victor.proyectofinal.proyectodesarrolloback.controller.dto.LibroRequest;
import com.victor.proyectofinal.proyectodesarrolloback.controller.dto.LibroResponse;

public interface LibroService {
	
	List<LibroResponse> obtenerTodos();
	
	LibroResponse obtenerPorId(int id);
	
	LibroResponse crear(LibroRequest nuevoLibro);
	
	LibroResponse actualizar(LibroRequest libro, int id);
	
	void eliminar(int id);
}
