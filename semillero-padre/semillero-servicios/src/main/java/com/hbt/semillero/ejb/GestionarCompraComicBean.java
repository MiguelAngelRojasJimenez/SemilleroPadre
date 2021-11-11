package com.hbt.semillero.ejb;

import java.time.LocalDate;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.entidad.Comic;
import com.hbt.semillero.enums.EstadoEnum;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class GestionarCompraComicBean implements IGestionarCompraComicLocal{

	
	@PersistenceContext
	public EntityManager em;

	
	/**
	 * Valida el estado de Disponibilidad del comic y su cantidad en Stock
	 * @see com.hbt.semillero.ejb.IGestionarCompraComicLocal#comprarComic(java.lang.Long, java.lang.Integer)
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ComicDTO comprarComic(Long idComic, Integer cantidadComprada) {
		
		String consulta = "SELECT  FROM Comic c WHERE c.id = :idComic";
		ComicDTO comicDTO = new ComicDTO();
		
		try {
			Query consultaComic = em.createQuery(consulta);
			Comic comic = (Comic) consultaComic.getSingleResult();
			comicDTO = this.convertirComicToComicDTO(comic);
			
			if(comicDTO.getEstadoEnum()==EstadoEnum.INACTIVO) {
				throw new Exception("El comic Seleccionado no cuenta con stock en bodega");
				
			}else {
				if(comicDTO.getCantidad()>cantidadComprada) {
					throw new Exception("La cantidad existente del comic es: " + comicDTO.getCantidad()+
							" numero de comic y supera la ingresada");
				}else if(comicDTO.getCantidad()==cantidadComprada) {
					comicDTO.setEstadoEnum(EstadoEnum.INACTIVO);
				}else {
					
				}
					Integer nuevaCantidad = comicDTO.getCantidad()-cantidadComprada;
					comicDTO.setFechaVenta(LocalDate.now());
					comicDTO.setCantidad(nuevaCantidad);
					comicDTO.setMensajeEjecucion("La compta del Comic "+comicDTO.getNombre()+"fue exitosa");
				}
				
			
		 comicDTO.setExitoso(true);
		 comicDTO.setMensajeEjecucion("Compra realizada con exito");
		} catch (Exception e) {
			comicDTO.setExitoso(false);
			comicDTO.setMensajeEjecucion("Error en la ejecucion ");
		}
		return comicDTO;
	}
	
	
	
	
	/**
	 * 
	 * Metodo encargado de transformar un comic a un comicDTO
	 * 
	 * @param comic
	 * @return
	 */
	private ComicDTO convertirComicToComicDTO(Comic comic) {
		ComicDTO comicDTO = new ComicDTO();
		comicDTO.setId(comic.getId());
		comicDTO.setNombre(comic.getNombre());
		comicDTO.setEditorial(comic.getEditorial());
		comicDTO.setTematica(comic.getTematica());
		comicDTO.setColeccion(comic.getColeccion());
		comicDTO.setNumeroPaginas(comic.getNumeroPaginas());
		comicDTO.setPrecio(comic.getPrecio());
		comicDTO.setAutores(comic.getAutores());
		comicDTO.setColor(comic.getColor());
		comicDTO.setFechaVenta(comic.getFechaVenta());
		comicDTO.setEstadoEnum(comic.getEstadoEnum());
		comicDTO.setCantidad(comic.getCantidad());
		return comicDTO;
	}

	/**
	 * 
	 * Metodo encargado de transformar un comicDTO a un comic
	 * 
	 * @param comic
	 * @return
	 */
	private Comic convertirComicDTOToComic(ComicDTO comicDTO) {
		Comic comic = new Comic();
		comic.setId(comicDTO.getId());
		comic.setNombre(comicDTO.getNombre());
		comic.setEditorial(comicDTO.getEditorial());
		comic.setTematica(comicDTO.getTematica());
		comic.setColeccion(comicDTO.getColeccion());
		comic.setNumeroPaginas(comicDTO.getNumeroPaginas());
		comic.setPrecio(comicDTO.getPrecio());
		comic.setAutores(comicDTO.getAutores());
		comic.setColor(comicDTO.getColor());
		comic.setFechaVenta(comicDTO.getFechaVenta());
		comic.setEstadoEnum(comicDTO.getEstadoEnum());
		comic.setCantidad(comicDTO.getCantidad());
		return comic;
	}



	
	
}
