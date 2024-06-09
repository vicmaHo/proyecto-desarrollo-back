package com.victor.proyectofinal.proyectodesarrolloback.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Clase DTO para la construccion de una respuesta

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioResponse {


	// se dara como respuesta un mensaje
	private String message;
	// private int id;
	
	// private String userName;

	// private String password;
	
	// private String rol;
}
