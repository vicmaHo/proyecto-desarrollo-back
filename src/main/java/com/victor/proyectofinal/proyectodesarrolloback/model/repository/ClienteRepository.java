package com.victor.proyectofinal.proyectodesarrolloback.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.victor.proyectofinal.proyectodesarrolloback.model.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

	// Consulta para obtener un cliente de la bd por medio de su identificaion
	Optional<Cliente> findByIdentificacion(String identificacion);
}
