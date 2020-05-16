package proyectoIngenieria;


import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

import proyectoIngenieria.Doctores.Area;

public class Principal {
	// Tenia esta funcion hecha para validar usuario y contraseña del examen del
	// semestre pasado de programacion
	public static Object validar_usuario(Hospital hospital, String tipo, int N) {
		Scanner teclado = new Scanner(System.in);
		String usuario = "";
		String contrasena = "";
		boolean acceso = false;
		Object actual=null;
		
		System.out.println("LOGIN");
		// While para que se repita mientras alguno esté mal
		int i = 0;
		while (!acceso && i < N) {
			// Si cualquiera de los dos es falso, entra porque uno esta mal y los dos 
			// deben estar bien.

			i++;
			System.out.println("Introduzca su usuario por favor");

			if (teclado.hasNextLine()) {
				usuario = teclado.nextLine();

				System.out.println("Introduzca su contraseña por favor");

				if (teclado.hasNextLine()) {
					contrasena = teclado.nextLine();
				}

				if (tipo.contentEquals("admin")) {
					Iterator<PowerUser> itr = hospital.getPowerUser().iterator();
					while (itr.hasNext() && !acceso) {
						actual = (PowerUser) actual;
						actual = itr.next();
						if (((PowerUser) actual).getDni().equals(usuario) && ((PowerUser) actual).getContrasenia().equals(contrasena)) {
							acceso = true;
						}
					}
				} else if (tipo.contentEquals("doc")) {
					Iterator<Doctores> itr = hospital.getDoctores().iterator();
					while (itr.hasNext() && !acceso) {
						actual = (Doctores) actual;
						actual = itr.next();
						if (((Doctores) actual).getDni().equals(usuario) && ((Doctores) actual).getContrasena().equals(contrasena)) {
							acceso = true;
						}
					}
				}

			}

			if (!acceso) {
				System.out.println("La contraseña o el usuario son incorrectos. \nIntentelo de nuevo"
						+ "\nIntentos restantes: " + (N - i));

			}

		} // Fin While

		// Decirle si accedió o no
		if (acceso) {
			System.out.println("La contraseña y el usuario son correctos. \nAcesso concedido");
		} else {
			System.out.println("La contraseña o el usuario son incorrectos. \nAcesso denegado");
		}
		
		return actual;

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
				fichero.write("Apellido;Nombre;fecha de nacimiento;DNI;telefono;email;direccion;contraseñas;\n");
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
		//declaramos la entrada de teclado
		Scanner sc= new Scanner (System.in);
		
		//System.out.println("\nPrueba de datos");
		Hospital hospital = new Hospital ("pacientes.csv");

		//Prueba de metodos que impresion de info
		//hospital.mostrar_pac();
		//hospital.mostrar_doc();

		//Prueba de exportacion de archivos luego de modificarlos
		//Creo una cita
		/*Citas citas = new Citas (new Date(), "Corona", "medicina", "mucha", "todos los dias");
		//Agrego cita a un paciente
		hospital.getPowerUser().get(0).add_cita(citas, hospital.getPacientes().get(4));
		//Agrego el paciente a un doctor
		hospital.getPowerUser().get(0).add_pac(hospital.getPacientes().get(2), hospital.getDoctores().get(3));
		//Exporto el .csv de todos los doctores, que a su vez exporta el .csv de sus pacientes y de sus citas
		hospital.exportar_csv("docs.csv", 'D');
		//Exportar el .csv de todos los pacientes
		hospital.exportar_csv("pc.csv", 'P');
		System.out.println();*/
		
		//Prueba Exportar doc de 'D' (Doctores) (Cada uno con su respectivo archivo de pacientes
		/*hospital.exportar_csv("docs.csv", 'D');*/
		
		//Prueba Exportar el archivo login de doctores (usuarios)
		/*exportar_contrasenas(hospital.getDoctores());*/
		
		//Prueba de la busqueda filtrada
		/*hospital.filtrar_doctores("area", Area.PEDIATRIA);
		hospital.filtrar_pacientes("fecha de nacimiento", "07/02/97");*/
		
		//Prueba de enviar correo
		//hospital.getDoctores().get(0).enviarMail(hospital.getPacientes().get(0));
		hospital.exportar_csv("pacientes.csv", 'P');
		
		
		//Empezamos a desarrollar el menu
		int decision=0;
		do{
			System.out.println("¿Qué tipo de usuario es?\n 1. Administrador\n 2. Doctor\n 3. Salir del programa");
			
		//peta si no meto un numero en la opcion, no me acaba de salir la solucion (en el de analisis estaba bien)
		while (!sc.hasNextInt()) {
			System.out.print("ERROR. \nIntroduzca un numero (entero) por favor:");
			sc.next();	
		}
		decision=sc.nextInt();
			
			
			switch(decision){
				case 1:
					//admin
					System.out.println("admin");
					//hacer login antes. 3 intentos maximo
					PowerUser poweruser=(PowerUser)validar_usuario(hospital, "admin", 3);
					while(decision!=19 && poweruser!=null) {
						System.out.println("Bienvenido " + poweruser.getNombre() + " " + poweruser.getApellido());
						System.out.println("�Qu� desea hacer?\n 1. Buscar pacientes\n 2. Buscar doctores\n 3. Importar CSV\n "
								+ "4. Exportar CSV\n 5. Mostrar doctores\n 6. Mostrar pacientes\n 7. Dar de alta a un doctor\n "
								+ "8. Dar de alta a un paciente\n 9. Dar de baja a un doctor\n 10. Dar de baja a un paciente\n "
								+ "11. Asignar paciente a un doctor\n 12. Eliminar un paciente de un doctor\n 12. Cambiar "
								+ "contrase�a\n 13. Cambiar contrase�a a un doctor\n 14. Total de pacientes\n 15. Pacientes por �rea\n"
								+ " 16. Pacientes por doctor\n 17. A�adir cita\n 18. Editar cita\n 19. Volver\n");
						
						if(sc.hasNextInt())
							decision=sc.nextInt();
						
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
							poweruser.mostrar_doc();
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
							System.out.println("Por favor, introduzca un valor v�lido.");
							break;
						}
						
						
					}
				
					break;				
				case 2:
					//doc
					System.out.println("doc");
					//hacer login antes. 3 intentos maximo
					Doctores user=(Doctores) validar_usuario(hospital, "doc", 3);
					while(decision!=10 && user!=null) {
						System.out.println("Bienvenido " + user.getNombre() + " " + user.getApellido());
						System.out.println("�Qu� desea hacer?\n 1. Mostrar pacientes\n 2. Buscar pacientes\n 3. Mostrar citas\n"
								+ " 4. Eliminar cita\n 5. �ltima modificaci�n del historial de citas\n 6. Enviar mail\n 7. "
								+ "Pacientes totales\n 8. Pacientes por Hospital\n 9. Pacientes por �rea\n 10. Volver\n");
						
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
							System.out.println("Por favor, introduzca un valor v�lido.");
							break;
						}
						if(sc.hasNextInt())
							decision=sc.nextInt();
					}
					
					break;
				case 3:
					exportar_contrasenas(hospital.getDoctores());
					exportar_contrasenas(hospital.getPowerUser());
					System.out.println("Fin del programa, gracias por confiar en Clinic Admin.");
					break;
				default:
					System.out.println("Por favor, introduzca un valor v�lido.");
					break;
			}		
			System.out.println();
		}
		while(decision!=3);
		
		
		sc.close();
	}

}
