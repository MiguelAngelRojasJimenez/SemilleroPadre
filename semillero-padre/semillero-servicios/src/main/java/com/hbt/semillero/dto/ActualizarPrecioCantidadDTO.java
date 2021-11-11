package com.hbt.semillero.dto;

import java.math.BigDecimal;

public class ActualizarPrecioCantidadDTO extends ResultadoDTO{

	
	/**
	 * Atributo que determina  
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal precio;
	private Integer cantidad;
	
	public ActualizarPrecioCantidadDTO() {
	//constructor vvacio
	}

	
	
	
	public ActualizarPrecioCantidadDTO(BigDecimal precio, Integer cantidad) {
		this.precio = precio;
		this.cantidad = cantidad;
	}




	/**
	 * Metodo encargado de retornar el valor del atributo precio
	 * @return El precio asociado a la clase
	 */
	public BigDecimal getPrecio() {
		return precio;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo precio
	 * @param precio El nuevo precio a modificar.
	 */
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo cantidad
	 * @return El cantidad asociado a la clase
	 */
	public Integer getCantidad() {
		return cantidad;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo cantidad
	 * @param cantidad El nuevo cantidad a modificar.
	 */
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
}
