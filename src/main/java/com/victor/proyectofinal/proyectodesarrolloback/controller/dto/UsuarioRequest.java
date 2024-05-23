package com.victor.proyectofinal.proyectodesarrolloback.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRequest {

	private String userName;

	private String password;
	
	private String rol;
}
