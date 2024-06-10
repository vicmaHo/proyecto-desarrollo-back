package com.victor.proyectofinal.proyectodesarrolloback.controller.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrestamoRequest {
	
	private int libroPrestadoId;
	
	private int clienteId;

}
