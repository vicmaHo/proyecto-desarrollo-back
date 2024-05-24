package com.victor.proyectofinal.proyectodesarrolloback.configuration;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Clase para configuracion de Beans de spring
@Configuration
public class BeanConfiguration {

	/**
	 * Creo un Bean, objeto que forma parte del contenedor y es gestionado por spring.
	 * Este Bean hace referencia al ModelMapper que nos servira para Mapear entidades 
	 * a objetos de respuesta
	 * @return Objeto ModelMapper
	 */
	@Bean
	ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
