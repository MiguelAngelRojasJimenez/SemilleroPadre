package com.hbt.semillero.dto;

import java.util.ArrayList;
import java.util.List;

public class ConsultaComicTamanioNombreDTO extends ResultadoDTO {

	
	/**
	 * Atributo que determina  
	 */
	private static final long serialVersionUID = 1L;
	private  List<String> listaSuperan = new ArrayList<String>();
	private  List<String> listaNoSuperan = new ArrayList<String>();
	
	public ConsultaComicTamanioNombreDTO() {
		//constructor vacio;
	}

	public ConsultaComicTamanioNombreDTO(List<String> listaSuperan, List<String> listaNoSuperan) {
		this.listaSuperan = listaSuperan;
		this.listaNoSuperan = listaNoSuperan;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo listaSuperan
	 * @return El listaSuperan asociado a la clase
	 */
	public List<String> getListaSuperan() {
		return listaSuperan;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo listaSuperan
	 * @param listaSuperan El nuevo listaSuperan a modificar.
	 */
	public void setListaSuperan(List<String> listaSuperan) {
		this.listaSuperan = listaSuperan;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo listaNoSuperan
	 * @return El listaNoSuperan asociado a la clase
	 */
	public List<String> getListaNoSuperan() {
		return listaNoSuperan;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo listaNoSuperan
	 * @param listaNoSuperan El nuevo listaNoSuperan a modificar.
	 */
	public void setListaNoSuperan(List<String> listaNoSuperan) {
		this.listaNoSuperan = listaNoSuperan;
	}
	
}
