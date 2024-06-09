package com.victor.proyectofinal.proyectodesarrolloback.model.entity;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity // Indico que sera una entidad -> Tabla de base de datos
@Builder
@Data // Genero setters y getters
@AllArgsConstructor // Genero constructor
@NoArgsConstructor // Genero constructor vacio
public class Usuario implements UserDetails{
	
	// Atributos - Mapeo con JPA directo de objetos Java a una base de datos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 60, nullable = false, unique = true) // indico restriccion de nulidad y tamaño de cadena
	private String username;
	
	@Column(length = 60, nullable = false)
	private String password;
	
	@Enumerated(EnumType.STRING) // indico que el valor del enum se almacenara como string en la bd
	@Column(nullable = false)
	private Rol rol;

	// Metodos de UserDetails
	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority((rol.name()))); // lista que contiene un unico objeto, representa la autoridad otorgada al usuario
    }

    // Existen otros metodos de la interface UserDetails, pero no se usaran ya que se estara trabajando con un token
    // y este token contendra la informacion necesaria, por tanto estas funciones no seran necesarias

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
