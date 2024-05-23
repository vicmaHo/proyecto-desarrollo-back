package com.victor.proyectofinal.proyectodesarrolloback.service;

import java.util.List;

import com.victor.proyectofinal.proyectodesarrolloback.controller.dto.ClienteRequest;
import com.victor.proyectofinal.proyectodesarrolloback.controller.dto.ClienteResponse;

public interface ClienteService {
	
	List<ClienteResponse> obtenerTodos();
	
	ClienteResponse obtenerPorId(int id);
	
	ClienteResponse crear(ClienteRequest nuevoUsuario);
	
	ClienteResponse actualizar(ClienteRequest usuario, int id);
	
	void eliminar(int id);
	
}
