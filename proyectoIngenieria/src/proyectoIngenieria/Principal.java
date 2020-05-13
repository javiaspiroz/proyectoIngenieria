package proyectoIngenieria;


import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Principal {
	//Tenia esta funcion hecha para validar usuario y contraseÃ±a del examen del semestre pasado de programacion
	public static boolean validar_usuario (String user, String password, int N) {
		Scanner teclado= new Scanner (System.in);
		String usuario="";
		String contrasena="";
		
		int i=0;
			//While para que se repita mientras alguno estÃ© mal
			while ((!usuario.contentEquals(user) || !contrasena.contentEquals(password)) && i<N) { 
				//Si cualquiera de los es falso, entra porque uno esta mal y los dos deben estar bien.
				
				i++;
				System.out.println("Introduzca su usuario por favor");
				
				if (teclado.hasNextLine()) {
					usuario=teclado.nextLine();
				
					System.out.println("Introduzca su contraseÃ±a por favor");
					
					if (teclado.hasNextLine()) {
						contrasena=teclado.nextLine();
					}
					
				}
				else {
					System.out.println("El usuario introducido es invÃ¡lido"); 
					//Solo le avisa con el usuario que estÃ¡ mal porque con las contraseÃ±as no se suele decir nada
				}
				
				
				if (!usuario.contentEquals(user) || !contrasena.contentEquals(password)) {
					System.out.println("La contraseÃ±a o el usuario son incorrectos. \nIntentelo de nuevo");
				}
				
				
			} //Fin While
		
		//Decirle si accediÃ³ o no
		if (usuario.contentEquals(user) && contrasena.contentEquals(password)) {
			System.out.println("La contraseÃ±a y el usuario son correctos. \nAcesso concedido");
			return true;
		}
		else {
			System.out.println("La contraseÃ±a o el usuario son incorrectos. \nAcesso denegado");
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
				fichero.write("Apellido;Nombre;fecha de nacimientoÂ ;Area;DNI;telefono;email;direccion;archivo de pacientes;contraseÃ±as;\n");
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
			System.out.println("Mensaje de la excepciÃ³n: " + ex.getMessage());
		}
	}
	

	public static void main(String[] args) {
		//declaramos la entrada de teclado
		Scanner sc= new Scanner (System.in);
		System.out.println("Prueba de acceso");
		String user="user";
		String password="clave";
		int N=2;

		boolean acceso=validar_usuario(user, password, N);

		//Un print para comprobar si estaba bien
		System.out.println(acceso);

		System.out.println("\nPrueba de datos");
		Hospital hospital = new Hospital ("pacientes.csv");

		hospital.mostrar_pac();

		//Exportar doc de 'P' (Pacientes) (Cada uno con su respectivo archivo de citas)
		//hospital.exportar_csv("pacientes2.csv", 'P');
		System.out.println();
		
		hospital.mostrar_doc();
		
		//Exportar doc de 'D' (Doctores) (Cada uno con su respectivo archivo de pacientes)
		/*Ahora esta comentado lo que hace que cree los .csv de pacientes si no lo encuentra
		porque si no se hacen muchos .csv, al final se activa*/
		//hospital.exportar_csv("docs.csv", 'D');
		exportar_contrasenas(hospital.getDoctores());
		
		
		
		
		//Empezamos a desarrollar el menu
		int decision=0;
		do{
			System.out.println("¿Qué tipo de usuario es?\n 1. Administrador\n 2. Doctor\n 3. Salir del programa");
			
			//peta si no meto un numero en la opcion, no me acaba de salir la solucion (en el de analisis estaba bien)
			if(sc.hasNextInt())
				decision=sc.nextInt();
			
			
			
			switch(decision){
				case 1:
					//admin
					System.out.println("admin");
					//hacer login antes
					do{
						System.out.println("¿Qué desea hacer?\n 1. Buscar pacientes\n 2. Buscar doctores\n 3. Importar CSV\n "
								+ "4. Exportar CSV\n 5. Mostrar doctores\n 6. Mostrar pacientes\n 7. Dar de alta a un doctor\n "
								+ "8. Dar de alta a un paciente\n 9. Dar de baja a un doctor\n 10. Dar de baja a un paciente\n "
								+ "11. Asignar paciente a un doctor\n 12. Eliminar un paciente de un doctor\n 12. Cambiar "
								+ "contraseña\n 13. Cambiar contraseña a un doctor\n 14. Total de pacientes\n 15. Pacientes por área\n"
								+ " 16. Pacientes por doctor\n 17. Añadir cita\n 18. Editar cita\n 19. Volver\n");
						switch(decision){
						case 1:
							
							break;
						case 2:
							
							break;
						case 3:
								
								break;
						case 4:
							
							break;
						case 5:
	
							break;
						case 6:
							
							break;
						case 7:
							
							break;	
						case 8:
							
							break;	
						case 9:
							
							break;
						case 10:
							
							break;
						case 11:
							
							break;
						case 12:
							
							break;
						case 13:
							
							break;
						case 14:
							
							break;
						case 15:
							
							break;
						case 16:
							
							break;
						case 17:
							
							break;
						case 18:
							
							break;	
						case 19:
							System.out.println("Volver a elegir tipo de usuario");
							break;	
						default:
							System.out.println("Por favor, introduzca un valor válido.");
							break;
						}
						if(sc.hasNextInt())
							decision=sc.nextInt();
					}
					while(decision!=19);
					break;				
				case 2:
					//doc
					System.out.println("doc");
					do{
						System.out.println("¿Qué desea hacer?\n 1. Mostrar pacientes\n 2. Buscar pacientes\n 3. Mostrar citas\n"
								+ " 4. Eliminar cita\n 5. Última modificación del historial de citas\n 6. Enviar mail\n 7. "
								+ "Pacientes totales\n 8. Pacientes por Hospital\n 9. Pacientes por área\n 10. Volver\n");
						
						switch(decision){
						case 1:
							
							break;
						case 2:
							
							break;
						case 3:
								
								break;
						case 4:
							
							break;
						case 5:
	
							break;
						case 6:
							
							break;
						case 7:
							
							break;	
						case 8:
							
							break;	
						case 9:
							
							break;
						case 10:
							System.out.println("Volver a elegir tipo de usuario");
							break;	
						default:
							System.out.println("Por favor, introduzca un valor válido.");
							break;
						}
						if(sc.hasNextInt())
							decision=sc.nextInt();
					}
					while(decision!=10);
					
					break;
				case 3:
					System.out.println("Fin del programa, gracias por confiar en Clinic Admin.");
					break;
				default:
					System.out.println("Por favor, introduzca un valor válido.");
					break;
			}		
			System.out.println();
		}
		while(decision!=3);
		
		
		sc.close();
	}

}
