package com.victor.proyectofinal.proyectodesarrolloback.service.impl;


import com.victor.proyectofinal.proyectodesarrolloback.controller.dto.UsuarioDTO;
import com.victor.proyectofinal.proyectodesarrolloback.controller.dto.UsuarioRequest;
import com.victor.proyectofinal.proyectodesarrolloback.controller.dto.UsuarioResponse;
import com.victor.proyectofinal.proyectodesarrolloback.service.UsuarioService;

import org.springframework.stereotype.Service;

import com.victor.proyectofinal.proyectodesarrolloback.model.entity.Usuario;
import com.victor.proyectofinal.proyectodesarrolloback.model.repository.UsuarioRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

	private final UsuarioRepository userRepository; 

    @Transactional
    public UsuarioResponse updateUser(UsuarioRequest userRequest) {
       
        Usuario user = Usuario.builder()
        .id(userRequest.getId())
		.username(userRequest.getUsername())
        .build();
        
        userRepository.updateUser(user.getId(), user.getUsername());

        return new UsuarioResponse("El usuario se registró satisfactoriamente");
    }

    public UsuarioDTO getUser(Integer id) {
		System.out.println("ID: "+id);
        Usuario user= userRepository.findById(id).orElse(null);
       
        if (user!=null)
        {
            UsuarioDTO userDTO = UsuarioDTO.builder()
            .id(user.getId())
            .username(user.getUsername())
			.rol(user.getRol().toString())
            .build();
            return userDTO;
        }
        return null;
    }

	@Override
	public void eliminar(int id) {
		
		userRepository.deleteById(id);
	}

}
