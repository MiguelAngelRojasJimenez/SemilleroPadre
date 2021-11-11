package com.hbtsemillero.rest;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.ejb.IGestionarCompraComicLocal;

@Path("/gestionarCompraComic")
public class GestionarCompraComicRest {
	
	@EJB
	private IGestionarCompraComicLocal gestionarCompraComicLocal;

	/**
	 * 
	 * Metodo encargado de comprar "n" cantidad de comic identificado por el id   
	 * <b>Caso de Uso</b>
	 * @author MiguelAngel
	 * 
	 * @param idComic
	 * @param cantidadComprada
	 * @return
	 */
	@POST
	@Path("/comprarComic")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ComicDTO comprarComic(@QueryParam("idComic") Long idComic, @QueryParam("cantidadComprada") Integer cantidadComprada ) {
		return this.gestionarCompraComicLocal.comprarComic(idComic, cantidadComprada);
	}
}
