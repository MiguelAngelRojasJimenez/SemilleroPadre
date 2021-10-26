package com.hbtsemillero.rest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

import com.hbt.semillero.entidad.Comic;
import com.hbt.semillero.enums.EstadoEnum;
import com.hbt.semillero.enums.TematicaEnum;



public class CreacionComicRest {

	
	
	/**
	 * declaracion de array list
	 */
	static ArrayList<Comic> listaComic = new ArrayList<Comic>();
	static ArrayList<Comic> listaComicActivos = new ArrayList<Comic>();
	static ArrayList<Comic> listaComicInactivos = new ArrayList<Comic>();
	static ArrayList<EstadoEnum> listaEnumsActivos  = new ArrayList<EstadoEnum>();
	static ArrayList<EstadoEnum> listaEnumsInactivos  = new ArrayList<EstadoEnum>();
	
	
	public static void main(String args[]) {
	Comic comic1 = new Comic(1L,"superman","DC COMIC",TematicaEnum.AVENTURA,"primer",20,new BigDecimal(1000000),"malcom",true,LocalDate.parse("2021-10-25"),EstadoEnum.ACTIVO,100);
	EstadoEnum inactivo = EstadoEnum.INACTIVO;
	EstadoEnum activo = EstadoEnum.ACTIVO;
	Comic comic2 = new Comic(2L,"batman","DC COMIC",TematicaEnum.AVENTURA,"primer",20,new BigDecimal(450000),"malcom",true,LocalDate.parse("2021-10-25"),inactivo,100);
	Comic comic3 = new Comic(2L,"antman","marvel",TematicaEnum.AVENTURA,"primer",20,new BigDecimal(20000),"stan",true,LocalDate.parse("2021-10-25"),EstadoEnum.ACTIVO,100);
	Comic comic4 = new Comic(2L,"flash","DC COMIC",TematicaEnum.AVENTURA,"primer",20,new BigDecimal(27000),"malcom",true,LocalDate.parse("2021-10-25"),inactivo,100);
	Comic comic5 = new Comic(2L,"acuaman","DC COMIC",TematicaEnum.AVENTURA,"primer",20,new BigDecimal(21000),"malcom",true,LocalDate.parse("2021-10-25"),inactivo,100);
	Comic comic6 = new Comic(2L,"ironman","marvel",TematicaEnum.AVENTURA,"primer",20,new BigDecimal(28000),"stan",true,LocalDate.parse("2021-10-25"),EstadoEnum.ACTIVO,100);
	Comic comic7 = new Comic(2L,"wonderwoman","DC COMIC",TematicaEnum.AVENTURA,"primer",20,new BigDecimal(25000),"malcom",true,LocalDate.parse("2021-10-25"),EstadoEnum.ACTIVO,100);		Comic comic8 = new Comic(2L,"strange","marvel",TematicaEnum.AVENTURA,"primer",20,new BigDecimal(30000),"stan",true,LocalDate.parse("2021-10-25"),EstadoEnum.ACTIVO,100);
	Comic comic9 = new Comic(2L,"deadshot","DC COMIC",TematicaEnum.AVENTURA,"primer",20,new BigDecimal(50000),"malcom",true,LocalDate.parse("2021-10-25"),EstadoEnum.ACTIVO,100);		Comic comic10 = new Comic(2L,"loki","marvel",TematicaEnum.AVENTURA,"primer",20,new BigDecimal(30000),"stan",true,LocalDate.parse("2021-10-25"),EstadoEnum.ACTIVO,100);

		
	
	listaComic.add(comic1);
	listaComic.add(comic2);
	listaComic.add(comic3);
	listaComic.add(comic4);
	listaComic.add(comic5);
	listaComic.add(comic6);
	listaComic.add(comic7);
	listaComic.add(comic8);
	listaComic.add(comic9);
	listaComic.add(comic10);
	
	
	ComicActivos() ;
	ComicInactivos();
	//System.out.print(listaComicActivos.toString());
	int i=listaComicActivos.size();
	System.out.println(i);
	
	int j=listaComicInactivos.size();
	System.out.println(j);
	
	
	
	for (int h = 0; h<listaComicInactivos.size();h++) {
	 listaEnumsActivos.add(listaComicInactivos.get(h).getEstadoEnum());
	
	//
	}
	
	boolean contains = listaEnumsActivos.contains(inactivo);
	System.out.println(listaEnumsActivos.toString());
	System.out.println(contains);
	}
	public static ArrayList<Comic> ComicActivos() {
		//cargarLista();
		for (int i=0;i<listaComic.size();i++) {
		if(listaComic.get(i).getEstadoEnum().equals(EstadoEnum.ACTIVO)) {
			listaComicActivos.add(listaComic.get(i));
			} 
		}
		return listaComicActivos;
		
		}
	
	
	private static ArrayList<Comic> ComicInactivos() {
		//cargarLista();
		for (int i=0;i<listaComic.size();i++) {
		if(listaComic.get(i).getEstadoEnum().equals(EstadoEnum.INACTIVO)) {
			listaComicInactivos.add(listaComic.get(i));
			} 
		}
		return listaComicInactivos;		
		}
}
	
