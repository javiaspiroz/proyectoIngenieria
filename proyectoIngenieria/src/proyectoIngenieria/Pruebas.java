package proyectoIngenieria;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

public class Pruebas {
	
	Hospital hospital;
	
	@Before
	public void inicializar() {
		hospital = new Hospital ("pacientes.csv");
	}
	
	@Test
	public void pruebaExportarcsv() {
		
		hospital.exportar_csv("pacientes_pruebas.csv", 'P');
		//File fichero = new File("pacientes_pruebas.csv");
		assertTrue(new File("pacientes_pruebas.csv").exists());
		System.out.println("Prueba Radu");
	}
}
