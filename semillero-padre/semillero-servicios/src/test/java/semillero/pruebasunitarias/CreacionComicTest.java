package semillero.pruebasunitarias;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.hibernate.annotations.common.util.impl.Log;
import org.junit.Test;

import com.hbt.semillero.entidad.Comic;
import com.hbt.semillero.enums.EstadoEnum;
import com.hbt.semillero.enums.TematicaEnum;

public class CreacionComicTest {

	private final static Logger log = Logger.getLogger(OperacionesAritmeticasTest.class);
	
	Comic comic1 = new Comic(1L,"superman","DC COMIC",TematicaEnum.AVENTURA,"primer",20,new BigDecimal(1000000),"malcom",true,LocalDate.parse("2021-10-25"),EstadoEnum.ACTIVO,100);
	Comic comic2 = new Comic(2L,"batman","DC COMIC",TematicaEnum.AVENTURA,"primer",20,new BigDecimal(450000),"malcom",true,LocalDate.parse("2021-10-25"),EstadoEnum.INACTIVO,100);
	Comic comic3 = new Comic(2L,"antman","marvel",TematicaEnum.AVENTURA,"primer",20,new BigDecimal(20000),"stan",true,LocalDate.parse("2021-10-25"),EstadoEnum.ACTIVO,100);
	Comic comic4 = new Comic(2L,"flash","DC COMIC",TematicaEnum.AVENTURA,"primer",20,new BigDecimal(27000),"malcom",true,LocalDate.parse("2021-10-25"),EstadoEnum.INACTIVO,100);
	Comic comic5 = new Comic(2L,"acuaman","DC COMIC",TematicaEnum.AVENTURA,"primer",20,new BigDecimal(21000),"malcom",true,LocalDate.parse("2021-10-25"),EstadoEnum.INACTIVO,100);
	Comic comic6 = new Comic(2L,"ironman","marvel",TematicaEnum.AVENTURA,"primer",20,new BigDecimal(28000),"stan",true,LocalDate.parse("2021-10-25"),EstadoEnum.ACTIVO,100);
	Comic comic7 = new Comic(2L,"wonderwoman","DC COMIC",TematicaEnum.AVENTURA,"primer",20,new BigDecimal(25000),"malcom",true,LocalDate.parse("2021-10-25"),EstadoEnum.ACTIVO,100);
	Comic comic8 = new Comic(2L,"strange","marvel",TematicaEnum.AVENTURA,"primer",20,new BigDecimal(30000),"stan",true,LocalDate.parse("2021-10-25"),EstadoEnum.ACTIVO,100);
	Comic comic9 = new Comic(2L,"deadshot","DC COMIC",TematicaEnum.AVENTURA,"primer",20,new BigDecimal(50000),"malcom",true,LocalDate.parse("2021-10-25"),EstadoEnum.ACTIVO,100);
	Comic comic10 = new Comic(2L,"loki","marvel",TematicaEnum.AVENTURA,"primer",20,new BigDecimal(30000),"stan",true,LocalDate.parse("2021-10-25"),EstadoEnum.ACTIVO,100);
	
	//System.out.println(comic1.toString());
	
	
	/**
	 * declaracion de array list
	 */
	ArrayList<Comic> listaComic = new ArrayList<Comic>();
	ArrayList<Comic> listaComicActivos = new ArrayList<Comic>();
	ArrayList<Comic> listaComicInactivos = new ArrayList<Comic>();
	
	
	/**
	 * 
	 * Metodo encargado de verificar los comics activos 
	 * <b>Caso de Uso</b>
	 * @author MiguelAngel
	 *
	 */
	
	private void ComicActivos() {
		for (int i=0;i<listaComic.size();i++) {
		if(listaComic.get(i).getEstadoEnum().equals(EstadoEnum.ACTIVO)) {
			listaComicActivos.add(listaComic.get(i));
			} 
		}
				
		}
					
		
	/**
	 * 
	 * Metodo encargado de verificar los comics inactivos 
	 * <b>Caso de Uso</b>
	 * @author MiguelAngel
	 *
	 */
	
	private void ComicInactivos() {
		for (int i=0;i<listaComic.size();i++) {
			if(listaComic.get(i).getEstadoEnum().equals(EstadoEnum.INACTIVO)) {
				listaComicInactivos.add(listaComic.get(i));
				} 
			}
		
	}

	
	
	
	@Test
	public void validarComicsActivos () {
		log.info("Inicia Metodo validar Comics Activos");
		
		
		
	}
	
	@Test
	public void validarComicsInactivos () {
		log.info("Inicia Metodo validar Comics Inactivos");
		
		try {
			
		} catch (Exception e) {
			
		}
		
	}
	
	
	
	
	
	
	
	
}
