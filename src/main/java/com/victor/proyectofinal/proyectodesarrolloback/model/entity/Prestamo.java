package com.victor.proyectofinal.proyectodesarrolloback.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // Indico que sera una entidad -> Tabla de base de datos
@Builder
@Data // Genero setters y getters
@AllArgsConstructor // Genero constructor
@NoArgsConstructor // Genero constructor vacio
public class Prestamo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(columnDefinition = "TIMESTAMP")
	private LocalDateTime fechaPrestamo;
	
	@Column(columnDefinition = "TIMESTAMP")
	private LocalDateTime fechaDevolucion;
	
	private double valorMulta;
	
	@ManyToOne // indico relacion de muchos a uno, el prestamo tiene u nlibro y un libro pertenece a muchos prestamos
	private Libro libroPrestado;
	
	
	@ManyToOne// indico relacion de muchos a uno
	private Cliente cliente;
	
	/**
	 * Calcular el valor de la multa, se hace uso de la fecha actuasl y se verifica si la fecha de devolucion ya ha pasado
	 * en dicho caso por cada dia que se ha pasado se aplica una multa de 4500
	 * @return valorMulta
	 */
    public Double calcularMulta() {
    	LocalDateTime hoy = LocalDateTime.now();
        if (hoy.isAfter(this.fechaDevolucion)) {
        	long diffInDays = java.time.Duration.between(this.fechaDevolucion, hoy).toDays();
            this.valorMulta = diffInDays * 4500; // multa de 4500 por dia de retraso
        } else {
            this.valorMulta = 0.0;
        }
        return this.valorMulta;
    }
	
	
}
