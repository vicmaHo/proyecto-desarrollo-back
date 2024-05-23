package com.victor.proyectofinal.proyectodesarrolloback.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.victor.proyectofinal.proyectodesarrolloback.model.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}
