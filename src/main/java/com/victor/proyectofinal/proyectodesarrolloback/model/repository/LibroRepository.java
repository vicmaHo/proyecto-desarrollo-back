package com.victor.proyectofinal.proyectodesarrolloback.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.victor.proyectofinal.proyectodesarrolloback.model.entity.Libro;

import jakarta.transaction.Transactional;

public interface LibroRepository extends JpaRepository<Libro, Integer>{

    // se agregan dos querys especificas para trabajar la transaccion de prestamos, una con la finalidad de 
    // restar las copias disponibles y la otra para devolverlas
    @Modifying
    @Transactional
    @Query("update Libro l set l.copiasDisponibles = l.copiasDisponibles - 1 where l.id = :id")
    void restarCopia(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query("update Libro l set l.copiasDisponibles = l.copiasDisponibles + 1 where l.id = :id")
    void devolverCopia(@Param("id") Integer id);

}
