package com.hbt.semillero.enums;

public enum EstadoEnum {

	ACTIVO("Activo",1),
	INACTIVO("Inactivo",0),
	;
	
	private String descripcion;
	private int ident;
	
	EstadoEnum(String tipo, int ident) {
		this.descripcion =descripcion;
		this.ident =ident;
	}
	
	
	/**
	 * Metodo encargado de retornar el valor del atributo ident
	 * @return El ident asociado a la clase
	 */
	public int getIdent() {
		return ident;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo ident
	 * @param ident El nuevo ident a modificar.
	 */
	public void setIdent(int ident) {
		this.ident = ident;
	}
	EstadoEnum(String descripcion){
		this.descripcion=descripcion;
	}

}
