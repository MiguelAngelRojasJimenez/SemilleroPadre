package com.hbt.semillero.entidad;

import java.math.BigDecimal;

import com.hbt.semillero.enums.TipoVehiculoEnum;

/**
 * descripcion   Clase que determina el color de un vehiculo 
 * @author MiguelAngel
 *
 */
public class Vehiculo {
	private String color;
	private TipoVehiculoEnum tipovehiculo;
	private int numeroLlantas;
	private int numeroasientos;
	private boolean requiereLicencia;
	private BigDecimal precio; //para manejar precios es mejor por los grandes calculos  
	
	public Vehiculo() {
		// Constructor vacio
	}
	
	//Constructor clase
	public Vehiculo(String color, Integer precio) {
		this.color = color;
		this.precio = new BigDecimal(precio);
	}
	
	/**
	 * Metodo encargado de retornar el valor del atributo color
	 * @return El color asociado a la clase
	 */
	public String getColor() {
		return color;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo color
	 * @param color El nuevo color a modificar.
	 */
	public void setColor(String color) {
		this.color = color;
	}
	
	/**
	 * Metodo encargado de retornar el valor del atributo tipovehiculo
	 * @return El tipovehiculo asociado a la clase
	 */
	public TipoVehiculoEnum getTipovehiculo() {
		return tipovehiculo;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo tipovehiculo
	 * @param tipovehiculo El nuevo tipovehiculo a modificar.
	 */
	public void setTipovehiculo(TipoVehiculoEnum tipovehiculo) {
		this.tipovehiculo = tipovehiculo;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo numeroLlantas
	 * @return El numeroLlantas asociado a la clase
	 */
	public int getNumeroLlantas() {
		return numeroLlantas;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo numeroLlantas
	 * @param numeroLlantas El nuevo numeroLlantas a modificar.
	 */
	public void setNumeroLlantas(int numeroLlantas) {
		this.numeroLlantas = numeroLlantas;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo numeroasientos
	 * @return El numeroasientos asociado a la clase
	 */
	public int getNumeroasientos() {
		return numeroasientos;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo numeroasientos
	 * @param numeroasientos El nuevo numeroasientos a modificar.
	 */
	public void setNumeroasientos(int numeroasientos) {
		this.numeroasientos = numeroasientos;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo requiereLicencia
	 * @return El requiereLicencia asociado a la clase
	 */
	public boolean isRequiereLicencia() {
		return requiereLicencia;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo requiereLicencia
	 * @param requiereLicencia El nuevo requiereLicencia a modificar.
	 */
	public void setRequiereLicencia(boolean requiereLicencia) {
		this.requiereLicencia = requiereLicencia;
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
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Vehiculo [color=" + color + ", tipovehiculo=" + tipovehiculo + ", numeroLlantas=" + numeroLlantas
				+ ", numeroasientos=" + numeroasientos + ", requiereLicencia=" + requiereLicencia + ", precio=" + precio
				+ "]";
	}
	
	}
