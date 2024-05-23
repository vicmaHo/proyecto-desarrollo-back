package com.victor.proyectofinal.proyectodesarrolloback.service;

import java.util.List;

import com.victor.proyectofinal.proyectodesarrolloback.controller.dto.PrestamoRequest;
import com.victor.proyectofinal.proyectodesarrolloback.controller.dto.PrestamoResponse;

public interface PrestamoService {

	
	List<PrestamoResponse> obtenerTodos();
	
	PrestamoResponse obtenerPorId(int id);
	
	PrestamoResponse actualizar(PrestamoRequest prestamo, int id);
	
	PrestamoResponse registrarPrestamo(int clienteId, int libroId);
	
	String registrarDevolucion(int prestamoId);
	
	
	
}
