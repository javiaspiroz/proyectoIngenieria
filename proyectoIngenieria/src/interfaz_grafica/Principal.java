package interfaz_grafica;

import java.util.Scanner;

import proyectoIngenieria.Hospital;

public class Principal {

	public static void main(String[] args) {
		Scanner sc= new Scanner (System.in);
		System.out.println("Escriba la ruta de la caroeta donde estan los archivos: \nEJ:\nmacOS: /Users/sol/Downloads/ClinicAdmin/Files\nWindows: C:/Documents/ClinicAdmin/Files");
		String ruta = sc.next();
		
		Hospital hospital = new Hospital (ruta, "/pacientes.csv");
		
		Usuario vista = new Usuario();
		
		Controlador controlador = new Controlador(vista, hospital);
		vista.addController(controlador);
		vista.crearVista();	
		
		
		//VistaHomeadmin vista2 = new VistaHomeadmin(hospital.getPowerUser().get(0));
		//vista2.setVisible(true);
		
		}
	}

