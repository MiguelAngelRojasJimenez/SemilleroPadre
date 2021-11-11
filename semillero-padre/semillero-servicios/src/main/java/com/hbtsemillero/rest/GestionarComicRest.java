package com.hbtsemillero.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.hbt.semillero.dto.ActualizarComicDTO;
import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.dto.ConsultaComicTamanioNombreDTO;
import com.hbt.semillero.dto.ConsultaNombrePrecioComicDTO;
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.ejb.IGestionarComicLocal;

@Path("/gestionarComic")
public class GestionarComicRest {
	
	@EJB
	private IGestionarComicLocal gestionarComicLocal;
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 
	 * Metodo encargado de eliminar comic 
	 * <b>Caso de Uso</b>
	 * @author MiguelAngel
	 * 
	 * @param idComic
	 * @return
	 */
	@POST
	@Path("/eliminarComic")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResultadoDTO eliminarComic(@QueryParam("idComic") Long idComic) {
		return this.gestionarComicLocal.eliminarComic(idComic);
	}
	
	
	
	@POST
	@Path("/actualizarComic")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ActualizarComicDTO actualizarComic() {
		return this.gestionarComicLocal.actualizarComic();
	}
	
	
	/**
	 * 
	 * Metodo encargado de consultar todos los comic 
	 * <b>Caso de Uso</b>
	 * @author MiguelAngel
	 * 
	 * @return
	 */
	@GET
	@Path("/consultarComic")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ComicDTO> consultarComic () {
		return this.gestionarComicLocal.consultarComicDTO();
		
	}
	
	@GET
	@Path("/consultaComicTamanioNombre")
	@Produces(MediaType.APPLICATION_JSON)
	public ConsultaComicTamanioNombreDTO consultaComicTamanioNombre(@QueryParam("lengthComic") Short lengthComic) {
		return this.gestionarComicLocal.consultarTamanoComic(lengthComic);
	}
	
	
	@GET
	@Path("/consultarNombrePrecioComic")
	@Produces(MediaType.APPLICATION_JSON)
	public ConsultaNombrePrecioComicDTO consultarNombrePrecioComic(@QueryParam("idComic") Long idComic) {
		return this.gestionarComicLocal.consultarNombrePrecioComic(idComic);
	}
	
	@POST
	@Path("/crearComic")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ComicDTO crearComic(ComicDTO comicDTO) {
		ComicDTO comicDTOResult = new ComicDTO();
		try {
			comicDTOResult = this.gestionarComicLocal.crearComic(comicDTO);
		}  catch (Exception e) {
			
			comicDTOResult.setExitoso(false);
			comicDTOResult.setMensajeEjecucion("Se ha presentado un error tecnico, causa: " + e.getMessage());
		}
		return comicDTOResult;
	} 
	
}
