package com.victor.proyectofinal.proyectodesarrolloback.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.victor.proyectofinal.proyectodesarrolloback.controller.dto.PrestamoRequest;
import com.victor.proyectofinal.proyectodesarrolloback.controller.dto.PrestamoResponse;
import com.victor.proyectofinal.proyectodesarrolloback.service.PrestamoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/prestamos")
@CrossOrigin(origins = {"http://localhost:5173"})
@RequiredArgsConstructor
public class PrestamoController {

    private final PrestamoService prestamoService;

    /**
	 * Cuando se hace una peticion get al endpoint del controlador devuelve todos los 
	 * datos de los prestamos haciendo uso del servicio
	 * @return Lista de prestamos 
	 */
    @GetMapping
    public List<PrestamoResponse> obtenerTodos() {
        return prestamoService.obtenerTodos();
    }

     /**
	 * Cuando se hace una peticion get al especificado /{id} devuelve el prestamo
	 * correspondiente a ese id
	 * @return PrestamoResponse 
	 */
    @GetMapping("/{id}")
    public PrestamoResponse obtenerPorId(@PathVariable("id") int id) {
        return prestamoService.obtenerPorId(id);
    }

     /**
	 * Cuando se hace una peticion post al endpoint del controlador, junto con un body que contiene un
     * id de libro y un id de cliente, se hace uso del servicio para registrar el prestamo correspondiente
	 * @return PrestamoResponse
	 */
    @PostMapping
    public PrestamoResponse registrarPrestamo(@RequestBody PrestamoRequest prestamoRequest) {

        return prestamoService.registrarPrestamo(prestamoRequest.getClienteId(), prestamoRequest.getLibroPrestadoId());
    }
    
    /**
     * Funcion auxiliar para registrar prestamos con fechas distintas, recibe las fechas por parametros en el url
     * y los datos del prestamo como un body en formato json (funcion solo auxiliar para ingreso de datos de prueba)
     * @param prestamoRequest
     * @param entrega
     * @param devolucion
     * @return PrestamoResponse
     */
    @PostMapping(value = "/auxdata")
    public PrestamoResponse registrarPrestamo(@RequestBody PrestamoRequest prestamoRequest, 
    		@RequestParam(name = "entrega") String entrega, @RequestParam(name = "devolucion") String devolucion) {
    	
    	DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        LocalDateTime entregaFormat = LocalDateTime.parse(entrega, formatter);
        LocalDateTime devolucionFormat = LocalDateTime.parse(devolucion, formatter);
    	
    	return prestamoService.registrarPrestamo(prestamoRequest.getClienteId(), prestamoRequest.getLibroPrestadoId(),
    			entregaFormat, devolucionFormat);
    }

     /**
	 * Cuando se hace una peticion Delete al endpoint especificado /{id}, se elimina el prestamo, dando comprender
     * de que se realizo una devolucion del mismo
	 * @return String(devolucion exitosa)
	 */
    @DeleteMapping("/{id}")
    public String devolucion(@PathVariable("id") int id) {

        return prestamoService.registrarDevolucion(id);
    }


}
