package com.victor.proyectofinal.proyectodesarrolloback.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.victor.proyectofinal.proyectodesarrolloback.model.entity.Usuario;

import jakarta.transaction.Transactional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

    Optional<Usuario> findByUsername(String username);

    @Modifying
    @Transactional
    @Query("update Usuario u set u.username = :username where u.id = :id")
    void updateUser(@Param("id") Integer id, @Param("username") String username);
}
