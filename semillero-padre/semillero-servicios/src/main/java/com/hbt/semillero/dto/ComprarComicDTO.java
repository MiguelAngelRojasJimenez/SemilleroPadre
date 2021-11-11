package com.hbt.semillero.dto;

public class ComprarComicDTO extends ResultadoDTO {

	/**
	 * Atributo que determina  
	 */
	private static final long serialVersionUID = 1L;
	private Integer numeroComprado;
	
	public ComprarComicDTO() {
		//construcor vacio
	}

	/**
	 * Metodo encargado de retornar el valor del atributo numeroComprado
	 * @return El numeroComprado asociado a la clase
	 */
	public Integer getNumeroComprado() {
		return numeroComprado;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo numeroComprado
	 * @param numeroComprado El nuevo numeroComprado a modificar.
	 */
	public void setNumeroComprado(Integer numeroComprado) {
		this.numeroComprado = numeroComprado;
	} 
	
}
