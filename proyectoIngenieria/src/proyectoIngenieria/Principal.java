package proyectoIngenieria;


import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Principal {
	//Tenia esta funcion hecha para validar usuario y contraseña del examen del semestre pasado de programacion
	public static boolean validar_usuario (String user, String password, int N) {
		Scanner teclado= new Scanner (System.in);
		String usuario="";
		String contrasena="";
		
		int i=0;
			//While para que se repita mientras alguno esté mal
			while ((!usuario.contentEquals(user) || !contrasena.contentEquals(password)) && i<N) { //Si cualquiera de los es falso, entra porque uno esta mal y los dos deben estar bien.
				
				i++;
				System.out.println("Introduzca su usuario por favor");
				
				if (teclado.hasNextLine()) {
					usuario=teclado.nextLine();
				
					System.out.println("Introduzca su contraseña por favor");
					
					if (teclado.hasNextLine()) {
						contrasena=teclado.nextLine();
					}
					
				}
				else {
					System.out.println("El usuario introducido es inválido"); /*Solo le avisa con el usuario que está mal porque con las contraseñas no
																			se suele decir nada.*/
				}
				
				
				if (!usuario.contentEquals(user) || !contrasena.contentEquals(password)) {
					System.out.println("La contraseña o el usuario son incorrectos. \nIntentelo de nuevo");
				}
				
				
			} //Fin While
		
		//Decirle si accedió o no
		if (usuario.contentEquals(user) && contrasena.contentEquals(password)) {
			System.out.println("La contraseña y el usuario son correctos. \nAcesso concedido");
			return true;
		}
		else {
			System.out.println("La contraseña o el usuario son incorrectos. \nAcesso denegado");
			return false;
		}
		
	}
	 
	 /*Para exportar un archivo de usuarios y contrasenas (tener uno para users y
	 * otro para powerusers) al finalizar el programa (y solo por el, el poweruser no debe poder)*/
	public static void exportar_contrasenas(ArrayList usuarios) {
		FileWriter fichero = null;

		try {
			// Escribimos linea a linea en el fichero
			// Para exportar un archivo de doctores
			if (usuarios.get(0) instanceof Doctores) {
				fichero = new FileWriter("login_usuarios.csv");
				ArrayList<Doctores> exp_docs= (ArrayList<Doctores>) usuarios;
				Iterator<Doctores> itr = exp_docs.iterator();
				fichero.write("Apellido;Nombre;fecha de nacimiento ;Area;DNI;telefono;email;direccion;archivo de pacientes;contraseñas;\n");
				while (itr.hasNext()) {
					Doctores actual = itr.next();
					fichero.write(actual.getApellido()+ ";" + actual.getNombre()+ ";" + actual.getFecha_nacimiento_str()
					+ ";" +actual.getArea()+ ";" +actual.getDni()+ ";" +actual.getTelefono()+ ";" +actual.getEmail()
					+ ";" +actual.getDireccion()+ ";" +"pac_" +actual.getDni() +".csv"+";" + actual.getContrasena());
					fichero.write("\n");
				}
			}
			// Para exportar un archivo de powerusers
			else if (usuarios.get(0) instanceof PowerUser) {
				fichero = new FileWriter("login_powerusers.csv");
				ArrayList<PowerUser> exp_pu = (ArrayList<PowerUser>) usuarios;
				Iterator<PowerUser> itr = exp_pu.iterator();
				fichero.write("Apellido;Nombre;fecha de nacimiento;DNI;telefono;email;direccion;contrasenia;\n");
				while (itr.hasNext()) {
					PowerUser actual = itr.next();
					fichero.write(actual.getApellido()+";"+actual.getNombre()+";"+actual.getFecha_nacimiento_str()+";"+
							actual.getDni()+";"+actual.getTelefono()+";"+actual.getEmail()+";"+actual.getDireccion()+";"
							+actual.getContrasenia());
					fichero.write("\n");
				}
			}

			fichero.close();

			System.out.println("Los datos se han guardado en el fichero de login" );

		} catch (Exception ex) {
			System.out.println("Mensaje de la excepción: " + ex.getMessage());
		}
	}
	

	public static void main(String[] args) {
		System.out.println("Prueba de acceso");
		String user="user";
		String password="clave";
		int N=2;

		boolean acceso=validar_usuario(user, password, N);

		//Un print para comprobar si estaba bien
		System.out.println(acceso);

		System.out.println("Prueba de datos");
		Hospital hospital = new Hospital ("pacientes.csv");

		hospital.mostrar_pac();

		//hospital.exportar_csv("pacientes2.csv", 'P');
		System.out.println();
		hospital.mostrar_doc();
		//hospital.exportar_csv("docs.csv", 'D');
		//exportar_contrasenas(hospital.getDoctores());

	}

}
