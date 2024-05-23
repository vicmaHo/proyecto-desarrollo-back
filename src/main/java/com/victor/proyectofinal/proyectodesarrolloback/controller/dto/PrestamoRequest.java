package com.victor.proyectofinal.proyectodesarrolloback.controller.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrestamoRequest {
	
	private LocalDateTime fechaPrestamo;

	private LocalDateTime fechaDevolucion;
	
	private double valorMulta;
	
	private int libroPrestadoId;
	
	private int clienteId;

}
