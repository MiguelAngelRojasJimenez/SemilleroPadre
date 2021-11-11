package com.hbtsemillero.rest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.hibernate.NonUniqueResultException;

import com.hbt.semillero.entidad.Comic;
import com.hbt.semillero.enums.EstadoEnum;


@Path("/SemilleroJPQLRest")
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)

public class SemilleroJPQLRest {
	private final static Logger log = Logger.getLogger(SemilleroJPQLRest.class);
	@PersistenceContext  //permite tenenr una gestion de una conexion 
	private EntityManager em; //como abre y como cierra una conexion 
	
	@GET
	@Path("/test")
	@Produces(MediaType.APPLICATION_JSON)
	@SuppressWarnings("unchecked")
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	
	public String obtenerUnComic() {
		BasicConfigurator.configure();
		Comic comic = null;
		
		try {

			//( obtencion de un registro de la tabla comic haciendo uso del metodo fin de la clase 
			//entytimanager, esto es analogo a realizar la cnsulta SELECT * FROM COMIC WHERE ID = 24;
			comic = em.find(Comic.class, 9L);// simpre se debe usar la llave primaria 
			
			
			//consult de JPQL para obtener un comic con el id 24 pero quemado haciendo uso del meto getsingle
			String consultaUnComic = " SELECT c FROM Comic c WHERE c.id = 24 ";// c es un alias se puede usar cualquier nombre cualquier letra
			Query queryUnComic = em.createQuery(consultaUnComic);
			comic = (Comic) queryUnComic.getSingleResult(); //se castea solamente con el single result
			
			
			//consulta de JPQL para obtener un comic con el id 24 pero quemado haciendo uso del meto getsingleresult y setParameter
			String consultaUnComicConParametro = " SELECT c FROM Comic c WHERE c.id = :idComic "
					+ " AND c.estadoEnum = :estadoComic "
					+ "ORDER BY c.nombre DESC ";// c es un alias se puede usar cualquier nombre cualquier letra
			Query queryUnComicConParametro = em.createQuery(consultaUnComicConParametro);
			queryUnComicConParametro.setParameter("idComic", 24L);
			queryUnComicConParametro.setParameter("estadoComic", EstadoEnum.ACTIVO);
			comic = (Comic) queryUnComicConParametro.getSingleResult(); //se castea solamente con el single result
			
			// consulta todos los registros 
			String findAllComic = "SELECT cm FROM Comic cm ";
			Query queryFindAllComic = em.createQuery(findAllComic);
			List<Comic> listaComics = queryFindAllComic.getResultList();
			
			
			//Bloque para generacion de excepciones
			
			//String consultaUnComicConException = " SELECT c FROM Comic c WHERE c.id = :idComic "
//					+ " AND c.estadoEnum = :estadoComic "
//					+ "ORDER BY c.nombre DESC ";// c es un alias se puede usar cualquier nombre cualquier letra
//			Query queryUnComicConException = em.createQuery(consultaUnComicConException);
//			queryUnComicConException.setParameter("idComic", 99L);
//			queryUnComicConException.setParameter("estadoComic", EstadoEnum.ACTIVO);
//			comic = (Comic) queryUnComicConParametro.getSingleResult(); //se castea solamente con el single result
//			
//			String consultaUnComicConException2 = " SELECT c FROM Comic c WHERE c.id = :idComic "
//					+ " AND c.estadoEnum = :estadoComic "
//					+ "ORDER BY c.nombre DESC ";// c es un alias se puede usar cualquier nombre cualquier letra
//			Query queryUnComicConException2 = em.createQuery(consultaUnComicConException);
//			queryUnComicConException2.setParameter("estadoComic", EstadoEnum.ACTIVO);
//			comic = (Comic) queryUnComicConParametro.getSingleResult(); //se castea solamente con el single result
		
			
			Comic comicSuperman = new Comic();
			comicSuperman.setNombre("Superman");
			comicSuperman.setEditorial("DC");
			comicSuperman.setColeccion("DCCOMIC");
			comicSuperman.setNumeroPaginas(100);
			comicSuperman.setPrecio(new BigDecimal(300));
			comicSuperman.setCantidad(3);
			
			em.persist(comicSuperman);
			
			comicSuperman = this.consultarComicPorNombre(comicSuperman);
			
			comicSuperman.setPrecio(new BigDecimal(600));
			comicSuperman.setCantidad(9);
			em.merge(comicSuperman);
			
			
			//Actualizar y eliminar mediante un identificador 
			String actualizarComic = "UPDATE Comic c SET c.estadoEnum = :estado WHERE c.id = :idComic";
			Query queryActualizar = em.createQuery(actualizarComic);
			queryActualizar.setParameter("estado", EstadoEnum.ACTIVO);
			queryActualizar.setParameter("idComic", 32L);
			queryActualizar.executeUpdate();
			
			String deleteComic = "DELETE FROM Comic WHERE id = :idComic";
			Query queryDelete = em.createQuery(deleteComic);
			queryDelete.setParameter("idComic", 32L);
			queryDelete.executeUpdate();
			
			List<Long> idsComics = new ArrayList<>();
			idsComics.add(32L);
			idsComics.add(26L);
			idsComics.add(25L);
			idsComics.add(99L);	
			String actualizarVarios = "UPDATE Comic c SET c.estadoEnum = :estado WHERE c.id IN (:listaComic)";
			Query queryActualizarVarios = em.createQuery(actualizarVarios);
			queryActualizar.setParameter("estado", EstadoEnum.ACTIVO);
			queryActualizarVarios.setParameter("listaComic", idsComics);
			queryActualizarVarios.executeUpdate();
			
			String deleteComicVarios = "DELETE FROM Comic WHERE id = :idComic";
			Query queryDeleteVarios = em.createQuery(deleteComicVarios);
			queryDeleteVarios.setParameter("idComic", 32L);
			queryDeleteVarios.executeUpdate();
			
			//comicSuperman = this.consultarComicPorNombre(comicSuperman);
			
			//em.remove(comicSuperman);
			
		}catch(NonUniqueResultException nur) {
			log.info("existe mas de un registro"+ nur.getMessage());
			
		}catch(NoResultException nre) {
			log.info("no se han encontrado registros con el ID"+99L + nre.getMessage());
			
		}catch(Exception e) {
			log.info("SE HA PRESENTADO UN ERROR TECNICO "+ e.getMessage());
			return e.getMessage();
		}
	
		return comic.toString();
				
	}
	
	private Comic consultarComicPorNombre(Comic comicSuperman) {
		String consultaUnComicSuperman = " SELECT c FROM Comic c WHERE c.nombre = :nombreComic ";
		Query querySuperman = em.createQuery(consultaUnComicSuperman);
		querySuperman.setParameter("idComic", 24L);
		comicSuperman = (Comic) querySuperman.getSingleResult();
		return comicSuperman;
	
	}
}
