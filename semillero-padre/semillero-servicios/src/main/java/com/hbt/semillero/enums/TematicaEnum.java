package com.hbt.semillero.enums;

/**
 * clase que detemina la enumeracion para la tematica aceptados por un COMIC
 * @author MiguelAngel
 *
 */
public enum TematicaEnum {
	AVENTURA("enum.tematica.aventuras"),
	BELICO("enum.tematica.belico"),
	DEPORTIVO("enum.tematica.deportivo"),
	CIENCIA_FICCION("enum.tematica.cienciaFiccion"),
	HISTORICO("enum.tematica.Historico"),
	HORROR("enum.tematica.herror"),
	HUMORISTICO("enum.tematica.humoristico"),
	;
	
	private String descripcion;
	
	TematicaEnum(String descripcion){
		this.descripcion=descripcion;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo descripcion
	 * @return El descripcion asociado a la clase
	 */
	public String getDescripcion() {
		return descripcion;
	}

	
	
	


}
