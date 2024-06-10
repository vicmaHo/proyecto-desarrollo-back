package com.victor.proyectofinal.proyectodesarrolloback.controller.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PrestamoResponse {

	private int id;
	
	private LocalDateTime fechaPrestamo;

	private LocalDateTime fechaDevolucion;
	
	private double valorMulta;
	
	//la respuesta sera solo el tipo de dato que relaciona a las entidades
	private int libroPrestadoId;
	
	private int clienteId;
}
