package com.victor.proyectofinal.proyectodesarrolloback.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // Indico que sera una entidad -> Tabla de base de datos
@Data // Genero setters y getters
@AllArgsConstructor // Genero constructor
@NoArgsConstructor // Genero constructor vacio
public class Libro {
	
	// Atributos
	@Id // llave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY) //valor autogenerado
	private int id;
	
	@Column(length = 100)
	private String isbn;
	
	@Column(length = 60, nullable = false)
	private String titulo;
	
	@Column(length = 60, nullable = false)
	private String autor;
		
	@Column(columnDefinition = "TIMESTAMP")
	private LocalDateTime fechaPublicacion;

	private int numeroPaginas;
	
	@Column(length = 30)
	private String genero;
	
	@Column(length = 160)
	private String descripcion;
	
	//@Column(nullable = false)
	private int copiasTotales;
	
    //@Column(nullable = false)
	private int copiasDisponbiles;
	
}