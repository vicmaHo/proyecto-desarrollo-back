package com.victor.proyectofinal.proyectodesarrolloback.controller.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LibroRequest {
	
	private String isbn;
	
	private String titulo;

	private String autor;
		
	private LocalDateTime fechaPublicacion;

	private int numeroPaginas;
	
	private String genero;

	private String descripcion;
	
	private int copiasTotales;

	private int copiasDisponbiles;
	
}
