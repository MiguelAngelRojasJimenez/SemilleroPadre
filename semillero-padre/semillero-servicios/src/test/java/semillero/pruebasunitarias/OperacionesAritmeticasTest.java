package semillero.pruebasunitarias;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;



/**
 * 
 * @author Miguel Angel
 * Descripcion Clase que determina las pruebas unitarias gestinar operaciones aritmeticas
 *
 */



public class OperacionesAritmeticasTest { 
	
	private final static Logger log = Logger.getLogger(OperacionesAritmeticasTest.class);
	
	//prueba unitaria exitosa
	//mvn test  -Dmaven.test.skip=false para correrlo en consola
//	@BeforeTest
	//los log son para saber donde falla el código 
	public void inicializar() {
		BasicConfigurator.configure(); //inicializa el loger con una configuracion básica
		log.info("::::::::::::::::::Inicio Prueba unitaria::::::::::::::::");
	}
	/** 
	 * 
	 * Metodo encargado de probar le resltado de la suma 
	 * <b>Caso de Uso</b> gestionar operaciones
	 * @author MiguelAngel
	 *
	 */
	//@Test
	public void validarResultadoSumaExitosa () {
		log.info("Inicia Ejecución del metodo validarResultadoSumaExitosa()");
		
		int numero1=400;
		int numero2=100;
		int resultado=500;
		
		Assert.assertEquals(resultado, numero1+numero2);
		
		log.info("Finaliza la Ejecucion del metodo validarResultadoSumaExitosa()");
	}
	//@Test(enable =true) prueba inactiva
//	@Test
	public void validarResultadoSumaFallida() {
		log.info("Iniicia ejecucion metdo validar sumafalida");
		int numero1=400;
		int numero2=100;
		int resultado=540;
		
		try {
			if (resultado != (numero1+numero2)) {
				log.info("Se ha generado un error funcional probando el validarsumafallida");
				throw new Exception("La suma ha fallado en el calculo");
			}
			
		} catch (Exception e) {
			Assert.assertEquals(e.getMessage(), "La suma ha fallado en el calculo");
		}
		
		log.info("Finaliza la ejecucion del resltado suma fallida");
	}
//	@AfterTest
	public void finalizaPruebasUnitarias() {
		log.info("finaliza las pruebas");
	}
	
}
