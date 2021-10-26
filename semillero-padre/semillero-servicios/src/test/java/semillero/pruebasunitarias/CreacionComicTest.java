package semillero.pruebasunitarias;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
//import org.hibernate.annotations.common.util.impl.Log;
import org.junit.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.hbt.semillero.entidad.Comic;
import com.hbt.semillero.enums.EstadoEnum;
import com.hbt.semillero.enums.TematicaEnum;

import junit.framework.Assert;

public class CreacionComicTest {

	private final static Logger log = Logger.getLogger(CreacionComicTest.class);
	@BeforeTest
	public void inicializar() {
		BasicConfigurator.configure(); //inicializa el loger con una configuracion básica
		log.info("::::::::::::::::::Inicio Prueba unitaria::::::::::::::::");
	}

	Comic comic1 = new Comic(1L, "superman", "DC COMIC", TematicaEnum.AVENTURA, "primer", 20, new BigDecimal(1000000),
			"malcom", true, LocalDate.parse("2021-10-25"), EstadoEnum.ACTIVO, 100);
	Comic comic2 = new Comic(2L, "batman", "DC COMIC", TematicaEnum.AVENTURA, "primer", 20, new BigDecimal(450000),
			"malcom", true, LocalDate.parse("2021-10-25"), EstadoEnum.INACTIVO, 100);
	Comic comic3 = new Comic(2L, "antman", "marvel", TematicaEnum.AVENTURA, "primer", 20, new BigDecimal(20000), "stan",
			true, LocalDate.parse("2021-10-25"), EstadoEnum.ACTIVO, 100);
	Comic comic4 = new Comic(2L, "flash", "DC COMIC", TematicaEnum.AVENTURA, "primer", 20, new BigDecimal(27000),
			"malcom", true, LocalDate.parse("2021-10-25"), EstadoEnum.INACTIVO, 100);
	Comic comic5 = new Comic(2L, "acuaman", "DC COMIC", TematicaEnum.AVENTURA, "primer", 20, new BigDecimal(21000),
			"malcom", true, LocalDate.parse("2021-10-25"), EstadoEnum.INACTIVO, 100);
	Comic comic6 = new Comic(2L, "ironman", "marvel", TematicaEnum.AVENTURA, "primer", 20, new BigDecimal(28000),
			"stan", true, LocalDate.parse("2021-10-25"), EstadoEnum.ACTIVO, 100);
	Comic comic7 = new Comic(2L, "wonderwoman", "DC COMIC", TematicaEnum.AVENTURA, "primer", 20, new BigDecimal(25000),
			"malcom", true, LocalDate.parse("2021-10-25"), EstadoEnum.ACTIVO, 100);
	Comic comic8 = new Comic(2L, "strange", "marvel", TematicaEnum.AVENTURA, "primer", 20, new BigDecimal(30000),
			"stan", true, LocalDate.parse("2021-10-25"), EstadoEnum.ACTIVO, 100);
	Comic comic9 = new Comic(2L, "deadshot", "DC COMIC", TematicaEnum.AVENTURA, "primer", 20, new BigDecimal(50000),
			"malcom", true, LocalDate.parse("2021-10-25"), EstadoEnum.ACTIVO, 100);
	Comic comic10 = new Comic(2L, "loki", "marvel", TematicaEnum.AVENTURA, "primer", 20, new BigDecimal(30000), "stan",
			true, LocalDate.parse("2021-10-25"), EstadoEnum.ACTIVO, 100);

	// System.out.println(comic1.toString());

	ArrayList<Comic> listaComic = new ArrayList<Comic>();
	ArrayList<Comic> listaComicActivos = new ArrayList<Comic>();
	ArrayList<Comic> listaComicInactivos = new ArrayList<Comic>();
	ArrayList<EstadoEnum> listaEnumsActivos = new ArrayList<EstadoEnum>();
	ArrayList<EstadoEnum> listaEnumsInactivos = new ArrayList<EstadoEnum>();

	// private EstadoEnum activo;
	EstadoEnum inactivo = EstadoEnum.INACTIVO;
	EstadoEnum activo = EstadoEnum.ACTIVO;

	public void cargarLista() {
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
	}

	/**
	 * 
	 * Metodo encargado de verificar los comics activos <b>Caso de Uso</b>
	 * 
	 * @author MiguelAngel
	 *
	 */


	private ArrayList<Comic> comicActivos() {
		cargarLista();
		for (int i = 0; i < listaComic.size(); i++) {
			if (listaComic.get(i).getEstadoEnum().equals(EstadoEnum.ACTIVO)) {
				listaComicActivos.add(listaComic.get(i));
			}
		}
		return listaComicActivos;
	}

	/**
	 * 
	 * Metodo encargado de verificar los comics inactivos <b>Caso de Uso</b>
	 * 
	 * @author MiguelAngel
	 *
	 */

	private ArrayList<Comic> comicInactivos() {
		cargarLista();
		for (int i = 0; i < listaComic.size(); i++) {
			if (listaComic.get(i).getEstadoEnum().equals(EstadoEnum.INACTIVO)) {
				listaComicInactivos.add(listaComic.get(i));
			}
		}
		return listaComicInactivos;
	}

	/**
	 * 
	 * Metodo encargado de hacer un array con los enums de activo  
	 * <b>Caso de Uso</b>
	 * @author MiguelAngel
	 * 
	 * @return
	 */
	
	private ArrayList<EstadoEnum> listaEnums() {
		for (int i = 0; i < listaComicInactivos.size(); i++) {
			listaEnumsActivos.add(listaComicInactivos.get(i).getEstadoEnum());
		}
		//
		return listaEnumsActivos;
	}

	/**
	 * 
	 * Metodo encargado de validar el estado Activo 
	 * <b>Caso de Uso</b>
	 * @author MiguelAngel
	 *
	 */
	
	@Test
	public void validarComicsActivos () {
		log.info("Inicia Metodo validar Comics Activos");
		
		comicActivos();
		activo = EstadoEnum.ACTIVO;
		Assert.assertTrue(listaEnumsActivos.contains(activo)); 
		
		log.info("Finaliza la Ejecucion del metodo validarComicsActivos ()");
	}

	/**
	 * 
	 * Metodo encargado de validar estado Inactivo <b>Caso de Uso</b>
	 * 
	 * @author MiguelAngel
	 *
	 */
	@Test
	public void validarComicsInactivos() {
		log.info("Inicia Metodo validar Comics Inactivos");

		try {

			throw new Exception("Se ha detectado que de " + listaComic.size() + " comic se encontraron que "
					+ getListaComicActivos().size() + " son activos y " + getListaComicInactivos().size()
					+ " son inactivos");
		} catch (Exception e) {
			comicInactivos();
			inactivo = EstadoEnum.INACTIVO;
			Assert.assertTrue(listaEnumsInactivos.contains(inactivo)); 
			
		}

		log.info("Finaliza la Ejecucion del metodo validarComicsInactivos ()");
		
	}

	@AfterTest
	public void finalizaPruebasUnitarias() {
		log.info("finaliza las pruebas");
	}

	/**
	 * Metodo encargado de retornar el valor del atributo listaComicActivos
	 * 
	 * @return El listaComicActivos asociado a la clase
	 */
	public ArrayList<Comic> getListaComicActivos() {
		return listaComicActivos;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo listaComicActivos
	 * 
	 * @param listaComicActivos El nuevo listaComicActivos a modificar.
	 */
	public void setListaComicActivos(ArrayList<Comic> listaComicActivos) {
		this.listaComicActivos = listaComicActivos;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo listaComicInactivos
	 * 
	 * @return El listaComicInactivos asociado a la clase
	 */
	public ArrayList<Comic> getListaComicInactivos() {
		return listaComicInactivos;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo listaComicInactivos
	 * 
	 * @param listaComicInactivos El nuevo listaComicInactivos a modificar.
	 */
	public void setListaComicInactivos(ArrayList<Comic> listaComicInactivos) {
		this.listaComicInactivos = listaComicInactivos;
	}

}
