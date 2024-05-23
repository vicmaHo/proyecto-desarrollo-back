package com.victor.proyectofinal.proyectodesarrolloback.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class Usuario {
	
	// Atributos - Mapeo con JPA directo de objetos Java a una base de datos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 60, nullable = false) // indico restriccion de nulidad y tamaño de cadena
	private String userName;
	
	@Column(length = 60, nullable = false)
	private String password;
	
	@Enumerated(EnumType.STRING) // indico que el valor del enum se almacenara como string en la bd
	@Column(nullable = false)
	private Rol rol;
	
}
