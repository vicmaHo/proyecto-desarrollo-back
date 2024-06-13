package com.victor.proyectofinal.proyectodesarrolloback.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.victor.proyectofinal.proyectodesarrolloback.controller.dto.PrestamoRequest;
import com.victor.proyectofinal.proyectodesarrolloback.controller.dto.PrestamoResponse;
import com.victor.proyectofinal.proyectodesarrolloback.model.entity.Cliente;
import com.victor.proyectofinal.proyectodesarrolloback.model.entity.Estado;
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
			.valorMulta(prestamo.calcularMulta())
			.estado(prestamo.getEstado().name()) // agrego estado
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
		.valorMulta(prestamo.calcularMulta())
		.estado(prestamo.getEstado().name()) // agrego estado
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
		.valorMulta(nuevoPrestamo.calcularMulta())
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
		
		//Asigno estado pendiente a la hora de crear
		prestamo.setEstado(Estado.PENDIENTE);
		
		// guardo el prestamo
		Prestamo nuevoPrestamo = repository.save(prestamo);

		// modificar las copias disponibles del libro
		libroRepository.restarCopia(libroId);
		
		// construyo el prestamo response
		PrestamoResponse prestamoResponse = PrestamoResponse.builder()
		.id(nuevoPrestamo.getId())
		.fechaPrestamo(nuevoPrestamo.getFechaPrestamo())
		.fechaDevolucion(nuevoPrestamo.getFechaDevolucion())
		.valorMulta(nuevoPrestamo.calcularMulta())
		.estado(prestamo.getEstado().name())
		.libroPrestadoId(nuevoPrestamo.getLibroPrestado().getId())
		.clienteId(nuevoPrestamo.getCliente().getId())
		.build();

		return prestamoResponse;
	}
	
	/**
	 * Auxiliar para crear prestamos con fechas modificadas, a fines de introduccion de datos de prueba
	 * con fechas anteriores y expiradas
	 */
	@Transactional
	@Override
	public PrestamoResponse registrarPrestamo(int clienteId, int libroId, 
			LocalDateTime fechaPrestamo, LocalDateTime fechaDevolucion) {
		
		Prestamo prestamo = new Prestamo();
		Libro libro = libroRepository.findById(libroId).orElse(null);
		Cliente cliente = clienteRepository.findById(clienteId).orElse(null);
		
		prestamo.setLibroPrestado(libro);
		prestamo.setCliente(cliente);
		prestamo.setFechaPrestamo(fechaPrestamo);
		prestamo.setFechaDevolucion(fechaDevolucion); 
		
		prestamo.setEstado(Estado.PENDIENTE);
		
		// guardo el prestamo
		Prestamo nuevoPrestamo = repository.save(prestamo);
		
		// modificar las copias disponibles del libro
		libroRepository.restarCopia(libroId);
		
		
		// Construyo la respuesta
		PrestamoResponse prestamoResponse = PrestamoResponse.builder()
				.id(nuevoPrestamo.getId())
				.fechaPrestamo(nuevoPrestamo.getFechaPrestamo())
				.fechaDevolucion(nuevoPrestamo.getFechaDevolucion())
				.valorMulta(nuevoPrestamo.calcularMulta())
				.estado(prestamo.getEstado().name())
				.libroPrestadoId(nuevoPrestamo.getLibroPrestado().getId())
				.clienteId(nuevoPrestamo.getCliente().getId())
				.build();

		return prestamoResponse;

	}
	

	@Override
	public String registrarDevolucion(int prestamoId) {
		
		
		// Obtengo el prestamo
		Prestamo prestamo = repository.findById(prestamoId).orElse(null);
		//Verifico si esta devuelto
		if(prestamo.getEstado().equals(Estado.DEVUELTO)) {
			return "Prestamo ya duevuelto";
		}
		
		// modifico la cantidad de libros disponibles
		Libro libro = prestamo.getLibroPrestado();
		libroRepository.devolverCopia(libro.getId());
		

		// Actualizar estado a DEVUELTO
		prestamo.setEstado(Estado.DEVUELTO);
		
		// guardo el prestamo
		Prestamo prestamoActualizado = repository.save(prestamo);
		System.out.println(prestamoActualizado.toString());

		return "Prestamo registrado/eliminado";
	}

	
}
