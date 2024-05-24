package com.victor.proyectofinal.proyectodesarrolloback.controller.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LibroResponse {

	private int id;
	
	private String isbn;
	
	private String titulo;

	private String autor;
		
	private LocalDate fechaPublicacion;

	private int numeroPaginas;
	
	private String genero;

	private String descripcion;
	
	private int copiasTotales;

	private int copiasDisponibles;
}
