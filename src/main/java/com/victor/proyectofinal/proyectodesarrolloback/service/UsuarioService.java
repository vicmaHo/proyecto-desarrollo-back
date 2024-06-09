package com.victor.proyectofinal.proyectodesarrolloback.service;

import java.util.List;

import com.victor.proyectofinal.proyectodesarrolloback.controller.dto.UsuarioDTO;
import com.victor.proyectofinal.proyectodesarrolloback.controller.dto.UsuarioRequest;
import com.victor.proyectofinal.proyectodesarrolloback.controller.dto.UsuarioResponse;

//defino las funcioens/servicios de cada entidad
public interface UsuarioService {

	UsuarioResponse updateUser(UsuarioRequest userRequest);

	UsuarioDTO getUser(Integer id);
		
	List<UsuarioResponse> obtenerTodos();
	
	UsuarioResponse obtenerPorId(int id);
	
	UsuarioResponse crear(UsuarioRequest nuevoUsuario);
	
	UsuarioResponse actualizar(UsuarioRequest usuario, int id);
	
	void eliminar(int id);
	
}
