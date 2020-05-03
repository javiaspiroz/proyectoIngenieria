package proyectoIngenieria;

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
	
	public static void main(String[] args) {
		System.out.println("Prueba de acceso");
		String user="user";
		String password="clave";
		int N=2;
		
		boolean acceso=validar_usuario(user, password, N);
		
		//Un print para comprobar si estaba bien
		System.out.println(acceso);
		
		
	}

}
