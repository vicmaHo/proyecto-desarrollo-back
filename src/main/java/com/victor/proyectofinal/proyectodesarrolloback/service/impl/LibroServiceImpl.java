package com.victor.proyectofinal.proyectodesarrolloback.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.victor.proyectofinal.proyectodesarrolloback.controller.dto.LibroRequest;
import com.victor.proyectofinal.proyectodesarrolloback.controller.dto.LibroResponse;
import com.victor.proyectofinal.proyectodesarrolloback.model.entity.Libro;
import com.victor.proyectofinal.proyectodesarrolloback.model.repository.LibroRepository;
import com.victor.proyectofinal.proyectodesarrolloback.service.LibroService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LibroServiceImpl implements LibroService{

	final private LibroRepository repository;
	final private ModelMapper modelMapper;
	
	@Override
	public List<LibroResponse> obtenerTodos() {
		
		List<LibroResponse> listaLibros = repository.findAll()
				.stream()
				.map(libro -> modelMapper.map(libro, LibroResponse.class))
				.toList();
		
		return listaLibros;
		
	}

	@Override
	public LibroResponse obtenerPorId(int id) {
		
		if (id == 0) {
			throw new IllegalArgumentException("Mensaje 1, 0 no es valido");
		}
		
		var libro = repository.findById(id)
				.map((element) -> modelMapper.map(element, LibroResponse.class))
				.orElseThrow(() -> new IllegalArgumentException("Mensaje 2, no existe: " + id));
	
		return libro;
	}

	@Override
	public LibroResponse crear(LibroRequest nuevoLibro) {
		
		Libro libro = repository.save(modelMapper.map(nuevoLibro, Libro.class));
		
		return modelMapper.map(libro, LibroResponse.class);
	}

	@Override
	public LibroResponse actualizar(LibroRequest libro, int id) {
		
		Libro oldLibro = repository.findById(id).get();
		
		oldLibro.setAutor(libro.getAutor());
		oldLibro.setCopiasDisponibles(libro.getCopiasDisponibles());
		oldLibro.setCopiasTotales(libro.getCopiasTotales());
		oldLibro.setDescripcion(libro.getDescripcion());
		oldLibro.setFechaPublicacion(libro.getFechaPublicacion());
		oldLibro.setGenero(libro.getGenero());
		oldLibro.setIsbn(libro.getIsbn());
		oldLibro.setNumeroPaginas(libro.getNumeroPaginas());
		oldLibro.setTitulo(libro.getTitulo());
			
		Libro nuevoLibro = repository.save(oldLibro);
		
		return modelMapper.map(nuevoLibro, LibroResponse.class);
	}

	@Override
	public void eliminar(int id) {
		
		repository.deleteById(id);
		
	}


}
