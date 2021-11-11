package com.hbt.semillero.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ActualizarComicDTO extends ResultadoDTO {

	
	/**
	 * Atributo que determina  
	 */
	private static final long serialVersionUID = 1L;
	private  BigDecimal precio,iva;
	
	

	public ActualizarComicDTO()  {
		//constructor vacio
	}


	public BigDecimal incremento() {
		BigDecimal incrementoIva = new BigDecimal(1000);
		
		return incrementoIva;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo iva
	 * @return El iva asociado a la clase
	 */
	public BigDecimal getIva() {
		return iva;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo iva
	 * @param iva El nuevo iva a modificar.
	 */
	public void setIva(BigDecimal iva) {
		this.iva = iva;
	}

	private  List<BigDecimal> listaNuevosPrecios = new ArrayList<BigDecimal>();
	
	/**
	 * Metodo encargado de retornar el valor del atributo listaNuevosPrecios
	 * @return El listaNuevosPrecios asociado a la clase
	 */
	public List<BigDecimal> getListaNuevosPrecios() {
		return listaNuevosPrecios;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo listaNuevosPrecios
	 * @param listaNuevosPrecios El nuevo listaNuevosPrecios a modificar.
	 */
	public void setListaNuevosPrecios(List<BigDecimal> listaNuevosPrecios) {
		this.listaNuevosPrecios = listaNuevosPrecios;
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
	
	
}
