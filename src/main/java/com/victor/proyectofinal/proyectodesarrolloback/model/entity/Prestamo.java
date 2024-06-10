package com.victor.proyectofinal.proyectodesarrolloback.model.entity;

import java.time.LocalDateTime;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // Indico que sera una entidad -> Tabla de base de datos
@Builder
@Data // Genero setters y getters
@AllArgsConstructor // Genero constructor
@NoArgsConstructor // Genero constructor vacio
public class Prestamo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(columnDefinition = "TIMESTAMP")
	private LocalDateTime fechaPrestamo;
	
	@Column(columnDefinition = "TIMESTAMP")
	private LocalDateTime fechaDevolucion;
	
	private double valorMulta;
	
	@ManyToOne // indico relacion de muchos a uno, el prestamo tiene u nlibro y un libro pertenece a muchos prestamos
	private Libro libroPrestado;
	
	
	@ManyToOne// indico relacion de muchos a uno
	private Cliente cliente;
	
	
}
