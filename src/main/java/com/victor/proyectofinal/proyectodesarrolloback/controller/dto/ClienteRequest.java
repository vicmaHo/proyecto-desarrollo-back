package com.victor.proyectofinal.proyectodesarrolloback.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteRequest {
	
	private String identificacion;

	private String nombreCompleto;

	private String numeroTelefono;
	
	private String correoElectronico;
}
