package com.victor.proyectofinal.proyectodesarrolloback.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.victor.proyectofinal.proyectodesarrolloback.controller.dto.PrestamoRequest;
import com.victor.proyectofinal.proyectodesarrolloback.controller.dto.PrestamoResponse;
import com.victor.proyectofinal.proyectodesarrolloback.model.entity.Cliente;
import com.victor.proyectofinal.proyectodesarrolloback.model.entity.Libro;
import com.victor.proyectofinal.proyectodesarrolloback.model.entity.Prestamo;
import com.victor.proyectofinal.proyectodesarrolloback.model.repository.ClienteRepository;
import com.victor.proyectofinal.proyectodesarrolloback.model.repository.LibroRepository;
import com.victor.proyectofinal.proyectodesarrolloback.model.repository.PrestamoRepository;
import com.victor.proyectofinal.proyectodesarrolloback.service.PrestamoService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PrestamoServiceImpl implements PrestamoService{

	private final PrestamoRepository repository;
	private final LibroRepository libroRepository;
	private final ClienteRepository clienteRepository;

	@Override
	public List<PrestamoResponse> obtenerTodos() {
		
		List<Prestamo> listaPrestamos = repository.findAll();
		List<PrestamoResponse> listaPrestamosResponse = new ArrayList<>();
	

		for (Prestamo prestamo : listaPrestamos) {
			
			PrestamoResponse prestamoResponse = PrestamoResponse.builder()
			.id(prestamo.getId())
			.fechaPrestamo(prestamo.getFechaPrestamo())
			.fechaDevolucion(prestamo.getFechaDevolucion())
			.valorMulta(prestamo.getValorMulta())
			.libroPrestadoId(prestamo.getLibroPrestado().getId())
			.clienteId(prestamo.getCliente().getId())
			.build();

			listaPrestamosResponse.add(prestamoResponse);
			
		}

		return listaPrestamosResponse;
	}

	@Override
	public PrestamoResponse obtenerPorId(int id) {

		Prestamo prestamo = repository.findById(id).orElse(null);
		PrestamoResponse prestamoResponse = PrestamoResponse.builder()
		.id(prestamo.getId())
		.fechaPrestamo(prestamo.getFechaPrestamo())
		.fechaDevolucion(prestamo.getFechaDevolucion())
		.valorMulta(prestamo.getValorMulta())
		.libroPrestadoId(prestamo.getLibroPrestado().getId())
		.clienteId(prestamo.getCliente().getId())
		.build();

		return prestamoResponse;
	}

	@Override
	public PrestamoResponse actualizar(PrestamoRequest prestamo, int id) {

		Prestamo oldPrestamo = repository.findById(id).orElse(null);

		System.out.println(prestamo.toString());

		Libro nuevoLibro = libroRepository.findById(prestamo.getLibroPrestadoId()).orElse(null);
		Cliente nuevoCliente = clienteRepository.findById(prestamo.getClienteId()).orElse(null);

		// construyo el prestamo nuevo
		oldPrestamo.setLibroPrestado(nuevoLibro);
		oldPrestamo.setCliente(nuevoCliente);
		// oldPrestamo.setFechaPrestamo(prestamo.getFechaPrestamo());
		// oldPrestamo.setFechaDevolucion(prestamo.getFechaDevolucion());
		// oldPrestamo.setValorMulta(prestamo.getValorMulta());
		
		// guardo el prestamo
		Prestamo nuevoPrestamo = repository.save(oldPrestamo);
		
		// construyo el prestamo response
		PrestamoResponse prestamoResponse = PrestamoResponse.builder()
		.id(nuevoPrestamo.getId())
		.fechaPrestamo(nuevoPrestamo.getFechaPrestamo())
		.fechaDevolucion(nuevoPrestamo.getFechaDevolucion())
		.valorMulta(nuevoPrestamo.getValorMulta())
		.libroPrestadoId(nuevoPrestamo.getLibroPrestado().getId())
		.clienteId(nuevoPrestamo.getCliente().getId())
		.build();
		
		return prestamoResponse;
		

	}

	//Crear un prestamo
	@Transactional
	@Override
	public PrestamoResponse registrarPrestamo(int clienteId, int libroId) {
		// modificar las copias disponibles del libro
		Prestamo prestamo = new Prestamo();
		Libro libro = libroRepository.findById(libroId).orElse(null);
		Cliente cliente = clienteRepository.findById(clienteId).orElse(null);
		
		prestamo.setLibroPrestado(libro);
		prestamo.setCliente(cliente);
		prestamo.setFechaPrestamo(LocalDateTime.now());
		prestamo.setFechaDevolucion(LocalDateTime.now().plusDays(15));
		prestamo.setValorMulta(0.0);
		
		// guardo el prestamo
		Prestamo nuevoPrestamo = repository.save(prestamo);

		// modificar las copias disponibles del libro
		libroRepository.restarCopia(libroId);
		
		// construyo el prestamo response
		PrestamoResponse prestamoResponse = PrestamoResponse.builder()
		.id(nuevoPrestamo.getId())
		.fechaPrestamo(nuevoPrestamo.getFechaPrestamo())
		.fechaDevolucion(nuevoPrestamo.getFechaDevolucion())
		.valorMulta(nuevoPrestamo.getValorMulta())
		.libroPrestadoId(nuevoPrestamo.getLibroPrestado().getId())
		.clienteId(nuevoPrestamo.getCliente().getId())
		.build();

		return prestamoResponse;
	}

	@Override
	public String registrarDevolucion(int prestamoId) {
		
		Prestamo prestamo = repository.findById(prestamoId).orElse(null);
		Libro libro = prestamo.getLibroPrestado();

		libroRepository.devolverCopia(libro.getId());
		
		repository.deleteById(prestamoId);
		return "Prestamo registrado/eliminado";
	}

	
}
