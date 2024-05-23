package com.victor.proyectofinal.proyectodesarrolloback.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.victor.proyectofinal.proyectodesarrolloback.controller.dto.ClienteRequest;
import com.victor.proyectofinal.proyectodesarrolloback.controller.dto.ClienteResponse;
import com.victor.proyectofinal.proyectodesarrolloback.model.repository.ClienteRepository;
import com.victor.proyectofinal.proyectodesarrolloback.service.ClienteService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {
	
	final private ClienteRepository repository; // inyeccion de dependecias a traves de requerimente de argumentos para constructor
	final private ModelMapper modelMapper; // modelmapper agregado a clase de configuracion para que spring lo gestione
	
	@Override
	public List<ClienteResponse> obtenerTodos() {
		
		return null;
	}

	@Override
	public ClienteResponse obtenerPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClienteResponse crear(ClienteRequest nuevoUsuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClienteResponse actualizar(ClienteRequest usuario, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		
	}

}
