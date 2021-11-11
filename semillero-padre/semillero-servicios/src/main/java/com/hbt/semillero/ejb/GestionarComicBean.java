package com.hbt.semillero.ejb;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.hbt.semillero.dto.ActualizarComicDTO;
import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.dto.ConsultaComicTamanioNombreDTO;
import com.hbt.semillero.dto.ConsultaNombrePrecioComicDTO;
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.entidad.Comic;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class GestionarComicBean implements IGestionarComicLocal {

	@PersistenceContext
	public EntityManager em;
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Eliminar Comic 
	 * @see com.hbt.semillero.ejb.IGestionarComicLocal#eliminarComic(java.lang.Long)
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ResultadoDTO eliminarComic(Long idComic) {
		String consultaEliminar = "DELETE FROM Comic WHERE c.id ";
		//String eliminar = "DELETE c FROM Comic WHERE c.id";
		ComicDTO comicDTO = new ComicDTO();
		
		
		
		try {
			Query eliminarComic = em.createQuery(consultaEliminar);
			//Query eliminarComic = em.createQuery(eliminar);
			eliminarComic.executeUpdate();
			comicDTO.setExitoso(true);
			comicDTO.setMensajeEjecucion("Correcto");
		} catch (Exception e) {
			comicDTO.setExitoso(false);
			comicDTO.setMensajeEjecucion("Incorrecto");
		}
				
		return  comicDTO;
	}

	
	
	
	
	
	/**
	 * servicio para actualzar los precios 
	 */

	@Override
	@SuppressWarnings("unchecked")
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ActualizarComicDTO actualizarComic() {
		String consulta = "SELECT c.precio From Comic c";
		
		ActualizarComicDTO resultadoDTO = new ActualizarComicDTO();
		
		try {
			Query queryConsultarPrecios = em.createQuery(consulta);
			List<BigDecimal> listaPrecios = queryConsultarPrecios.getResultList();
			for (BigDecimal precio:listaPrecios) {
				precio.add(resultadoDTO.incremento());
				resultadoDTO.getListaNuevosPrecios().add(precio);
				resultadoDTO.setExitoso(true);
				resultadoDTO.setMensajeEjecucion("Correcto");
				}
		
		} catch (Exception e) {
			resultadoDTO.setExitoso(false);
			resultadoDTO.setMensajeEjecucion("Incorrecto");
		}
		
		return resultadoDTO;
	}
	
	
	

	/**
	 * 
	 * servicio para consultar todos los comics
	 * @see com.hbt.semillero.ejb.IGestionarComicLocal#consultarComicDTO()
	 */
	@SuppressWarnings("unchecked")
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	@Override
	public List<ComicDTO> consultarComicDTO() {
			String consultaTodosComic = "SELECT cm From Comic cm";
			List<ComicDTO> listaComicDTO = new ArrayList<ComicDTO>();
			ComicDTO comicsDTO = new ComicDTO();
			
			try {
		
			Query queryConsultarComics = em.createQuery(consultaTodosComic);
						
			List<Comic> resultList = queryConsultarComics.getResultList();
			
				
				for (Comic com : resultList) {
					comicsDTO = this.convertirComicToComicDTO(com);
					comicsDTO.setExitoso(true);
					comicsDTO.setMensajeEjecucion("Compilacion");
					listaComicDTO.add(comicsDTO);
				}

			} catch (Exception e) {
				comicsDTO.setExitoso(false);
				comicsDTO.setMensajeEjecucion("Error de compilación ");
			}
						
		
		return listaComicDTO; 
	}
	
	
	
	
	
	/** 
	 * @see consultar el tamaño de los nombres y listarlos segun el wraper Short
	 */
	@SuppressWarnings("unchecked")
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	@Override
	public ConsultaComicTamanioNombreDTO consultarTamanoComic(Short lengthComic) {
		String consulta = "SELECT c.nombre FROM Comic c";
		
		ConsultaComicTamanioNombreDTO resultadoTamañoDTO = new ConsultaComicTamanioNombreDTO();
		/*
		 * validación de la variable de entrada que no supere el valor permitido por el wraper Short*
		 * revisar la 
		 * 
		 */
		
		try {
			if(lengthComic > 200) {
				throw new Exception("La longitud máxima permitida es de 200 caracteres");
			}
			Query consultaNombres = em.createQuery(consulta);
			List<String> listaNombres  = consultaNombres.getResultList();  
			for (String nombre:listaNombres) {
				if(nombre.length()>= lengthComic) {
					resultadoTamañoDTO.getListaSuperan().add(nombre);
				}else {
					resultadoTamañoDTO.getListaNoSuperan().add(nombre);
				}
				
			}
			resultadoTamañoDTO.setExitoso(true);
			resultadoTamañoDTO.setMensajeEjecucion("Consulta realiada exitosamente");
			
		} catch (Exception e) {
			resultadoTamañoDTO.setExitoso(false);
			resultadoTamañoDTO.setMensajeEjecucion("Consulta no se pudo realizar");
		}
				return resultadoTamañoDTO;
	}

	
	
	
	
/**
 * 	
 * @see com.hbt.semillero.ejb.IGestionarComicLocal#consultarNombrePrecioComic(java.lang.Long)
 * consultar el nombre y el precio segun el Id
 */
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	@Override
	public ConsultaNombrePrecioComicDTO consultarNombrePrecioComic(Long idComic) {
		String consulta = "SELECT new com.hbt.semillero.dto.ConsultaNombrePrecioComicDTO(c.nombre, c.precio)  "
						+ " FROM Comic c WHERE c.id = :idComic";
		ConsultaNombrePrecioComicDTO consultaNombrePrecioDTO = new ConsultaNombrePrecioComicDTO();
		try {
			Query consultaNativa = em.createQuery(consulta);
			consultaNativa.setParameter("idComic", idComic);
			consultaNombrePrecioDTO = (ConsultaNombrePrecioComicDTO) consultaNativa.getSingleResult();
			consultaNombrePrecioDTO.setExitoso(true);
			consultaNombrePrecioDTO.setMensajeEjecucion("Se ejecuto exitosamente la consulta");	
		} catch (Exception e) {
			consultaNombrePrecioDTO.setExitoso(false);
			consultaNombrePrecioDTO.setMensajeEjecucion("Se ha presentado un error tecnico al consultar el comic");
		}

		return consultaNombrePrecioDTO;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ComicDTO crearComic(ComicDTO comicDTO) throws Exception {
		
		if(comicDTO.getNombre() == null) {
			throw new Exception("El campo nombre es requerido");
		}
		
		ComicDTO comicDTOResult = null;
		Comic comic = this.convertirComicDTOToComic(comicDTO);
		em.persist(comic);
		comicDTOResult = this.convertirComicToComicDTO(comic);
		comicDTOResult.setExitoso(true);
		comicDTOResult.setMensajeEjecucion("El comic ha sido creado exitosamente");
		return comicDTOResult;
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








	



//	/**
//	 * Entidad para actualizar el precio y la cantidad 
//	 * 
//	 *  
//	 */
//	@Override
//	@SuppressWarnings("unchecked")
//	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
//
//	public ActualizarPrecioCantidadDTO actualizarPrecioCantidad(EstadoEnum estado) {
//		String consultaPrecioCantidad = "UPDATE Comic c SET c.precio = :precio WHERE c.estado = :estadoComic"
//				+ "FROM Comic c";
//		
//		
//		 ActualizarPrecioCantidadDTO actualizarPrecioCantidad = new ActualizarPrecioCantidadDTO();
//		
//		 Query queryConsultaPrecioCantidad = em.createQuery(consultaPrecioCantidad);
//		 
//		 List<BigDecimal> listaPrecios  = queryConsultaPrecioCantidad.getResultList();
//		 
//		 for (BigDecimal precio:listaPrecios) {
//			 
//		 }
//		 
//		 
//			
//		 
//		 
//		
//		return null;
//	}

	
	



	




	

	
}
