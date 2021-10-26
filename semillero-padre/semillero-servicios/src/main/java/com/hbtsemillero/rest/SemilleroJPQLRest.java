package com.hbtsemillero.rest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.hbt.semillero.entidad.Comic;

public class SemilleroJPQLRest {

	@PersistenceContext
	private EntityManager em;
	
	@GET
	@Path("/test")
	@Produces(MediaType.APPLICATION_JSON)
	public String obtenerUnComic() {
		// obtencion de un registro de la tabla comic haciendo uso del metodo fin de la clase 
		//entytimanger, esto es analogo a realizar la cnsulta SELECT * FROM COMIC WHERE ID = 24;
		//Comic comic = em.find(Comic.class, 9L);// simpre se debe usar la llave primaria 
		//return comic.toString();
		
		//consult de JPQL paraobtener un comic con el id 24 pero quemado haciendo uso del meto getsingle
		//String consultaUnComic = " SELECT c FROM Comic c WHERE c.id = 24 ";// c es un alias se puede usar cualquier nombre cualquier letra
		//Query queryUnComic = em.createQuery(consultaUnComic);
		//Comic comic = (Comic) queryUnComic.getSingleResult(); //se castea solamente con el single result
		
		
		//consult de JPQL paraobtener un comic con el id 24 pero quemado haciendo uso del meto getsingleresult y setParameter
		String consultaComicConParametros = " SELECT c FROM Comic c WHERE c.id = :idComic ";// c es un alias se puede usar cualquier nombre cualquier letra
		Query queryUnComicConParametro = em.createQuery(consultaComicConParametros);
		queryUnComicConParametro.setParameter("idComic", 24L);
		Comic comic2 = (Comic) queryUnComicConParametro.getSingleResult(); //se castea solamente con el single result
		
		String findAllComic = "SELECT cm FROM Comic cm "
		List<Comic> listaComics = em.find(null, comic2)
		
		
		
	}
}
