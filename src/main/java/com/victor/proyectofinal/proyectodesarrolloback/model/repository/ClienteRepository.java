package com.victor.proyectofinal.proyectodesarrolloback.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.victor.proyectofinal.proyectodesarrolloback.model.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
