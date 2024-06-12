package com.victor.proyectofinal.proyectodesarrolloback.service;

import java.time.LocalDateTime;
import java.util.List;

import com.victor.proyectofinal.proyectodesarrolloback.controller.dto.PrestamoRequest;
import com.victor.proyectofinal.proyectodesarrolloback.controller.dto.PrestamoResponse;

public interface PrestamoService {

	/**
	 * Hace uso del repository de Prestamos para obtener todos los prestamos, posteriormente
	 * a cada prestamo se le hace su transfomacion a un prestamo response
	 * @return Lista de PrestamoResponse
	 */
	List<PrestamoResponse> obtenerTodos();
	
	/**
	 * Hace uso del repository de Prestamos para obtener un prestamo por su id, posteriormente
	 * este prestamo se transforma en un Prestamo response y se devuelve al controlador
	 * @param int id de prestamo a obtener
	 * @return PrestamoResponse
	 */
	PrestamoResponse obtenerPorId(int id);
	
	/**
	 * TODO: POR IMPLEMENTAR
	 * 
	 * Hace uso del repository de Prestamos para actualizar la informacion de un Prestamo en la base de datos,
	 * se recibe un PrestamoRequest con los nuevos datos y el id del Prestamo a actualizar, a continuación se extrae
	 * el Prestamo a traves del repository con el id, y a este Prestamo se le asignan los nuevos atributos con sus funciones 
	 * set, posteriormente este Prestamo actualizado se guarda en la base de datos y se devuelve un mapeo a PrestamoResponse
	 * @param PrestamoRequest
	 * @param id 
	 * @return PrestamoResponse
	 */
	PrestamoResponse actualizar(PrestamoRequest prestamo, int id);
	
	/**
	 * Hace uso del repository de Prestamo para registrar un nuevo prestamo en la base de datos a traves de una transaccion
	 * en la que se resta el libro de los librosdisponibles, y se agrega el prestamo a la base de datos, con su respectivo id de cliente y libro
	 * @param clienteId
	 * @param PrestamoId
	 * @return PrestamoResponse
	 */
	PrestamoResponse registrarPrestamo(int clienteId, int PrestamoId);
	
	/**
	 * Hace uso del repository de Prestamo para registrar la devolucion de un prestamo, lo que elimina el prestamo de la base de datos
	 * y se suma el libro de los librosdisponibles
	 * @param prestamoId
	 * @return String
	 */
	String registrarDevolucion(int prestamoId);

	/**
	 * Auxiliar para crear prestamos con fechas modificadas, a fines de introduccion de datos de prueba
	 * con fechas anteriores y expiradas
	 */
	PrestamoResponse registrarPrestamo(int clienteId, int libroId, LocalDateTime fechaPrestamo,
			LocalDateTime fechaDevolucion);
	
	
	
}
