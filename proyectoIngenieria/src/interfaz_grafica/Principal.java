package interfaz_grafica;

import proyectoIngenieria.Hospital;

public class Principal {

	public static void main(String[] args) {
		Hospital hospital = new Hospital ("pacientes.csv");
		Usuario vista = new Usuario();
		
		Controlador controlador = new Controlador(vista, hospital);
		vista.addController(controlador);
		vista.crearVista();	
		
		
		//VistaHomeadmin vista2 = new VistaHomeadmin(hospital.getPowerUser().get(0));
		//vista2.setVisible(true);
		
		}
	}

