package com.victor.proyectofinal.proyectodesarrolloback.service;

import java.util.List;

import com.victor.proyectofinal.proyectodesarrolloback.controller.dto.ClienteRequest;
import com.victor.proyectofinal.proyectodesarrolloback.controller.dto.ClienteResponse;

public interface ClienteService {
	
	/**
	 * Hace uso del repository de clientes para obtener todos los clientes, posteriormente
	 * a cada cliente se le hace su transfomacion a un cliente response
	 * @return Lista de ClienteResponse
	 */
	List<ClienteResponse> obtenerTodos();
	
	/**
	 * Hace uso del repository de clientes para obtener un cliente por su id, posteriormente
	 * este cliente se transforma en un cliente response y se devuelve al controlador
	 * @param int id de cliente a obtener
	 * @return ClienteResponse
	 */
	ClienteResponse obtenerPorId(int id);
	
	/**
	 * Hace uso del repository de clientes para obtener un cliente por su identificacion, posteriormente
	 * este cliente se transforma en un cliente response y se devuelve al controlador
	 * @param String identificacion de cliente a obtener
	 * @return ClienteResponse
	 */
	ClienteResponse obtenerPorIdentificacion(String identificacion);
	
	/**
	 * Hace uso del repository de clientes para crear un nuevo cliente en la base de datos, se recibe un ClienteRequest
	 * este se mapea a un Cliente y se agrega a la base de datos
	 * @param ClienteRequest Body json como payload
	 * @return Lista de ClienteResponse
	 */
	ClienteResponse crear(ClienteRequest nuevoCliente);
	
	/**
	 * Hace uso del repository de clientes para actualizar la informacion de un cliente en la base de datos,
	 * se recibe un ClienteRequest con los nuevos datos y el id del Cliente a actualizar, a continuación se extrae
	 * el Cliente a traves del repository con el id, y a este cliente se le asignan los nuevos atributos con sus funciones 
	 * set, posteriormente este Cliente actualizado se guarda en la base de datos y se devuelve un mapeo a ClienteResponse
	 * @param ClienteRequest 
	 * @param id 
	 * @return ClienteResponse
	 */
	ClienteResponse actualizar(ClienteRequest cliente, int id);
	
	/**
	 * Hace uso del respository de cliente para eliminar mediante el id el Cliente especificado
	 * @param id
	 * @return void
	 */
	void eliminar(int id);
	
}
