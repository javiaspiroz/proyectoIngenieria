package proyectoIngenieria;

import java.util.Scanner;

public class Principal {
	//Tenia esta funcion hecha para validar usuario y contraseña del examen del semestre pasado de programacion
	public static boolean validar_usuario (String user, String password, int N) {
		Scanner teclado= new Scanner (System.in);
		String usuario="";
		String contrasena="";
		
		//Para comprobar si lo que se puso y lo que debe de ser coincide
		boolean bUsuario=false; //b de boolean
		boolean bContrasena=false; //b de boolean
		
		//Para decir si accede
		boolean acceso=false;
		
		//For para que se ripita solo el numero máximo de veces del parámetro
		//for (int i=0;i<N;i++) {
		
		int i=0;
			//While para que se repita mientras alguno esté mal
			while ((!bUsuario || !bContrasena) && i<N) { //Si cualquiera de los es falso, entra porque uno esta mal y los dos deben estar bien.
				
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
				
				//Comprobar si lo introducido coincide con lo que debe ser 
				if (usuario.contentEquals(user)) {
					bUsuario=true;
				}
				if (contrasena.contentEquals(password)) {
					bContrasena=true;
				}
				
				if (!bUsuario || !bContrasena) {
					System.out.println("La contraseña o el usuario son incorrectos. \nIntentelo de nuevo");
				}
				
				
			} //Fin While
			
		//} //Fin For
		
		//Decirle si accedió o no
		if (bUsuario && bContrasena) {
			acceso=true;
			System.out.println("La contraseña y el usuario son correctos. \nAcesso concedido");
		}
		else {
			System.out.println("La contraseña o el usuario son incorrectos. \nAcesso denegado");
		}
		
		
		return acceso;
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
