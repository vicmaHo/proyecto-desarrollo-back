package com.victor.proyectofinal.proyectodesarrolloback.service;

import java.util.List;

import com.victor.proyectofinal.proyectodesarrolloback.controller.dto.UsuarioDTO;
import com.victor.proyectofinal.proyectodesarrolloback.controller.dto.UsuarioRequest;
import com.victor.proyectofinal.proyectodesarrolloback.controller.dto.UsuarioResponse;

//defino las funcioens/servicios de cada entidad
public interface UsuarioService {

	/**
	 * Actualiza la informacion de un usuario
	 * @param userRequest
	 * return UsuarioResponse
	 */
	UsuarioResponse updateUser(UsuarioRequest userRequest);

	/**
	 * Obtiene un usuario por su id, haciendo uso del repository de usuario
	 * @param id
	 * return UsuarioDTO
	 */
	UsuarioDTO getUser(Integer id);
	
	/**
	 * Elimina un usuario por su id, haciendo uso del repository de usuario
	 * @param id
	 * return void
	 */
	void eliminar(int id);

	/**
	 * Retorna una lista de todos los usuarios de la aplicacion
	 * @param id
	 * return void
	 */
	List<UsuarioDTO> obtenerTodos();
	
}
