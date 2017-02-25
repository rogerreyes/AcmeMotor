package co.com.uni5d.domain;

import java.time.LocalDate;

import lombok.Data;

@Data
public class funcionPrecio {

	
	private LocalDate fechaInicial;
	private LocalDate fechafinal;
	private double precio;
	
	
	public funcionPrecio(LocalDate fechaInicial, LocalDate fechafinal, double precio) {
		super();
		this.fechaInicial = fechaInicial;
		this.fechafinal = fechafinal;
		this.precio = precio;
	}
	
	
	
	
}
