package com.victor.proyectofinal.proyectodesarrolloback.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.victor.proyectofinal.proyectodesarrolloback.model.entity.Libro;

public interface LibroRepository extends JpaRepository<Libro, Integer>{

}
