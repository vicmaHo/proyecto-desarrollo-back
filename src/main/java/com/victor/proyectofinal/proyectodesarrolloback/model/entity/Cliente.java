package com.victor.proyectofinal.proyectodesarrolloback.model.entity;

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
public class Cliente {

	// Atributos - mapeo a una base de datosd
	@Id // indico primarykey
	@GeneratedValue(strategy = GenerationType.IDENTITY) // valor autogenerado
	private int id;
	
	@Column(length = 60, nullable = false) // indico restriccion de nulidad y tamaño de cadena
	private String identificacion;
	
	@Column(length = 60, nullable = false)
	private String nombreCompleto;
	
	@Column(length = 60, nullable = false)
	private String numeroTelefono;
	
	@Column(length = 60)
	private String correoElectronico;
	
}
