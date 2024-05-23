package com.victor.proyectofinal.proyectodesarrolloback.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteResponse {
	
	private int id;
	
	private String identificacion;

	private String nombreCompleto;

	private String numeroTelefono;
	
	private String correoElectronico;
}
