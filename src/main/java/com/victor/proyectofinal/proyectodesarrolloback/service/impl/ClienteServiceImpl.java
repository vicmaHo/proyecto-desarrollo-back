package com.victor.proyectofinal.proyectodesarrolloback.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.victor.proyectofinal.proyectodesarrolloback.controller.dto.ClienteRequest;
import com.victor.proyectofinal.proyectodesarrolloback.controller.dto.ClienteResponse;
import com.victor.proyectofinal.proyectodesarrolloback.model.entity.Cliente;
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
		
		List<ClienteResponse> listaClientes = repository.findAll()
				.stream()
				.map(cliente -> modelMapper.map(cliente, ClienteResponse.class))
				.collect(Collectors.toList());
		
		return listaClientes;
	}


	@Override
	public ClienteResponse obtenerPorId(int id) {
		
		if (id == 0) {
			throw new IllegalArgumentException("Mensaje 1, 0 no es valido");
		}
		
		var cliente = repository.findById(id)
				.map((element) -> modelMapper.map(element, ClienteResponse.class))
				.orElseThrow(() -> new IllegalArgumentException("Mensaje 2, no existe: " + id));
	
		return cliente;
	}
	
	@Override
	public ClienteResponse obtenerPorIdentificacion(String identificacion) {
		
		ClienteResponse cliente = repository.findByIdentificacion(identificacion)
				.map((element) -> modelMapper.map(element, ClienteResponse.class))
				.orElseThrow(() -> new IllegalArgumentException("mesaje de error, no encontrado"));
		
		if (cliente.equals(null)) {
			throw new IllegalArgumentException("Mensaje, identificacion no encontrada");
		}
		
		
		
		return cliente;
		
	}


	@Override
	public ClienteResponse crear(ClienteRequest nuevoCliente) {
		
		Cliente cliente = repository.save(modelMapper.map(nuevoCliente, Cliente.class));
		
		return modelMapper.map(cliente, ClienteResponse.class);
	}


	@Override
	public ClienteResponse actualizar(ClienteRequest cliente, int id) {
		
		Cliente oldCliente = repository.findById(id).get();
		
		oldCliente.setIdentificacion(cliente.getIdentificacion());
		oldCliente.setNombreCompleto(cliente.getNombreCompleto());
		oldCliente.setCorreoElectronico(cliente.getCorreoElectronico());
		oldCliente.setNumeroTelefono(cliente.getNumeroTelefono());
			
		Cliente nuevoCliente = repository.save(oldCliente);
		
		return modelMapper.map(nuevoCliente, ClienteResponse.class);
	}

	
	@Override
	public void eliminar(int id) {
		
		repository.deleteById(id);
		
	}

}
