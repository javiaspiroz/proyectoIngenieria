package proyectoIngenieria;


import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

import proyectoIngenieria.Doctores.Area;

public class Principal {
	// Tenia esta funcion hecha para validar usuario y contraseña del examen del
	// semestre pasado de programacion
	public static Object validar_usuario(Hospital hospital, String tipo, int N) {
		@SuppressWarnings("resource")
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
	@SuppressWarnings("unchecked")
	public static void exportar_contrasenas(@SuppressWarnings("rawtypes") ArrayList usuarios, String rutaraiz) {
		FileWriter fichero = null;

		try {
			// Escribimos linea a linea en el fichero
			// Para exportar un archivo de doctores
			if (usuarios.get(0) instanceof Doctores) {
				fichero = new FileWriter(rutaraiz+"/login_usuarios.csv");
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
				fichero = new FileWriter(rutaraiz+"/login_powerusers.csv");
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
			System.out.println("Mensaje de la excepcion: " + ex.getMessage());
		}
	}
	
	public static Pacientes findPacInArr (Hospital hospital, String dniAux){
		Pacientes p = null;
		for (int i=0; i<hospital.getPacientes().size(); i++){
			if (hospital.getPacientes().get(i).getDni().equals(dniAux)){
				p = hospital.getPacientes().get(i);
			}
		}
		return p;
	}
	
	public static Doctores findDocInArr (Hospital hospital, String dniAux){
		Doctores d = null;
		for (int i=0; i<hospital.getDoctores().size(); i++){
			if (hospital.getDoctores().get(i).getDni().equals(dniAux)){
				d = hospital.getDoctores().get(i);
			}
		}
		return d;
	}
	
	public static int posDocArr (Hospital hospital, String dniAux){
		int position=-1;
		for (int i=0; i<hospital.getDoctores().size(); i++){
			if (hospital.getDoctores().get(i).getDni().equals(dniAux)){
				position=i;//guardamos la posicion del poweruser
			}
		}
		return position;
	}
	
	public static int posPacArr (Hospital hospital, String dniAux){
		int position=-1;
		for (int i=0; i<hospital.getPacientes().size(); i++){
			if (hospital.getPacientes().get(i).getDni().equals(dniAux)){
				position=i;//guardamos la posicion del poweruser
			}
		}
		return position;
	}
	
	public static int buscarPosCita (ArrayList<Citas> cs, Date d){
		int posicion = -1; // -1 si no encuentro. X si aparece
		int indice_arraylist = 0; // lo necesitamos para recorrer el array

		while (posicion == -1 && indice_arraylist < cs.size()) {
			if (cs.get(indice_arraylist).getFecha().compareTo(d)==0) {
				//encontrado
				posicion = indice_arraylist;
			}
			indice_arraylist++;
		}

		return posicion;
	}

	public static void main(String[] args) {
		//declaramos la entrada de teclado
		Scanner sc= new Scanner (System.in);
		
		System.out.println("Escriba la ruta de la caroeta donde estan los archivos: \nEJ:\nmacOS: /Users/sol/Downloads/ClinicAdmin/Files\nWindows: C:/Documents/ClinicAdmin/Files");
		String ruta = sc.next();
		
		Hospital hospital = new Hospital (ruta, "/pacientes.csv");
		
		//Empezamos a desarrollar el menu
		int decision=0;
		do{
			System.out.println("�Que tipo de usuario es?\n 1. Administrador\n 2. Doctor\n 3. Salir del programa");
		
		while (!sc.hasNextInt()) {
			System.out.print("ERROR. \nIntroduzca un numero (entero) por favor:");
			sc.next();	
		}
		decision=sc.nextInt();
			
			
			switch(decision){
				case 1:
					//admin: login con 3 intentos maximo
					PowerUser poweruser=(PowerUser)validar_usuario(hospital, "admin", 3);
					System.out.println("Bienvenido " + poweruser.getNombre() + " " + poweruser.getApellido());					
							
					while(decision!=20 && poweruser!=null) {
						System.out.println("\n�Que desea hacer?\n 1. Buscar pacientes\n 2. Buscar doctores\n 3. Importar CSV\n "
								+ "4. Exportar CSV\n 5. Mostrar doctores\n 6. Mostrar pacientes\n 7. Dar de alta a un doctor\n "
								+ "8. Dar de alta a un paciente\n 9. Dar de baja a un doctor\n 10. Dar de baja a un paciente\n "
								+ "11. Asignar paciente a un doctor\n 12. Eliminar un paciente de un doctor\n 13. Cambiar "
								+ "contrase�a\n 14. Cambiar contrase�a a un doctor\n 15. Total de pacientes\n 16. Pacientes por area\n"
								+ " 17. Pacientes por doctor\n 18. Anadir cita\n 19. Editar cita\n 20. Volver\n");
						
						while (!sc.hasNextInt()) {
							System.out.print("ERROR!. \n-Introduzca un numero (entero) por favor:");
							sc.next();	
						}
						decision=sc.nextInt();
						
						switch(decision){
						case 1://buscar pacientes
							System.out.println("Porque criterio desea buscar?");
							System.out.println(
									"1. Nombre\n 2. Apellido\n 3. DNI\n 4. Email\n 5. Direccion\n 6. Fecha de nacimiento(dd/mm/aa)\n"
										+ " 7. Telefono\n 8. Seguridad social\n");
							int filtro=0;
							while (!sc.hasNextInt()) {
								System.out.print("ERROR. \nIntroduzca un numero (entero) por favor:");
								sc.next();	
							}
							filtro=sc.nextInt();
							String filtroP = "";
							switch(filtro) {
							case 1:
								filtroP = "nombre";
								break;
							case 2:
								filtroP ="apellido";
								break;
							case 3:
								filtroP="dni";
								break;
							case 4:
								filtroP ="email";
								break;
							case 5:
								filtroP ="direccion";
								break;
							case 6:
								filtroP="fecha de nacimiento";
								break;
							case 7:
								filtroP ="telefono";
								break;
							case 8:
								filtroP ="seguridad social";
								break;
							}
							System.out.println("Introduzca el termino a buscar");
							
							if(filtroP.equals("telefono")) {
								int searchP = 0;
								while (!sc.hasNextInt()) {
									System.out.print("ERROR. \nIntroduzca un numero (entero) por favor:");
									sc.next();	
								}
								searchP = sc.nextInt();
								hospital.filtrar_pacientes(filtroP, searchP);
							} else if (filtroP.equals("seguridad social")) {
								long searchP = 0;
								while (!sc.hasNextLong()) {
									System.out.print("ERROR. \nIntroduzca un numero (entero) por favor:");
									sc.next();	
								}
								searchP = sc.nextLong();
								hospital.filtrar_pacientes(filtroP, searchP);
							} else {
								String searchP = sc.next();
								hospital.filtrar_pacientes(filtroP, searchP);
							}
							
							break;
						case 2://buscar doctores
							System.out.println("Porque criterio desea buscar?");
							System.out.println(
									"1. Nombre\n 2. Apellido\n 3. DNI\n 4. Email\n 5. Direccion\n 6. Fecha de nacimiento\n"
										+ " 7. Telefono\n 8. Area\n");
							filtro=0;
							while (!sc.hasNextInt()) {
								System.out.print("ERROR. \nIntroduzca un numero (entero) por favor:");
								sc.next();	
							}
							filtro=sc.nextInt();
							String filtroD = "";
							switch(filtro) {
							case 1:
								filtroD = "nombre";
								break;
							case 2:
								filtroD ="apellido";
								break;
							case 3:
								filtroD="dni";
								break;
							case 4:
								filtroD ="email";
								break;
							case 5:
								filtroD ="direccion";
								break;
							case 6:
								filtroD="fecha de nacimiento";
								break;
							case 7:
								filtroD ="telefono";
								break;
							case 8:
								filtroD ="area";
								break;
							}
							System.out.println("Introduzca el termino a buscar");
							
							if(filtroD.equals("telefono")) {
								int searchD = 0;
								while (!sc.hasNextInt()) {
									System.out.print("ERROR. \nIntroduzca un numero (entero) por favor:");
									sc.next();	
								}
								searchD = sc.nextInt();
								hospital.filtrar_doctores(filtroD, searchD);
							} else {
								String searchD = sc.next();
								hospital.filtrar_doctores(filtroD, searchD);
							}
							
	
							break;
						case 3://importar csv
							hospital.importar_csv_doctores();
							hospital.importar_csv_poweruser();
							System.out.println("Indique el nombre del archivo CSV de pacientes");
							String rutaI = sc.next();
							hospital.importar_csv_pacientes(rutaI);
							System.out.println("El proceso de importacion ha finalizado");
							break;
						case 4://exportar csv
							System.out.println("Indique el nombre del archivo para guardar la exportarcion");
							String rutaE = sc.next();
							System.out.println("�Que tipo de contenido quiere exportar?\n Introduzca P (pacientes), "
									+ "D (doctores) o W (administradores)");
							char tipo = 'A';
							while (!sc.hasNext() && (sc.next().charAt(0)!='D' || sc.next().charAt(0)!='W' || sc.next().charAt(0)!='P')) {
								System.out.print("ERROR. \nIntroduzca D, P o W por favor:");
								sc.next();	
							}
							tipo=sc.next().charAt(0);
							hospital.exportar_csv(rutaE, tipo);
							System.out.println("El proceso de exportacion ha finalizado");
							break;
						case 5://mostrar doctores
							hospital.mostrar_doc();
							break;
						case 6://mostrar pacientes
							hospital.mostrar_pac();
							break;
						case 7://dar alta a doctor
							System.out.println("Introduzca el nombre");
							String nombre = sc.next();
							System.out.println("Introduzca el apellido");
							String apellido = sc.next();
							System.out.println("Introduzca la fecha de nacimiento");
							String fechastr = sc.next();
							Date fecha = null;
							try {
								DateFormat sourceFormat = new SimpleDateFormat("dd/MM/yyyy");
								fecha = sourceFormat.parse(fechastr);
							} catch (java.text.ParseException e) {
								System.out.print("Mal formato de fecha.");
							}
							System.out.println("Introduzca el area");							
							String areastr = sc.next().toUpperCase();
							Area area=Enum.valueOf(Doctores.Area.class, areastr);
							System.out.println("Introduzca el DNI");
							String dni = sc.next();
							System.out.println("Introduzca el telefono");
							while (!sc.hasNextInt()) {
								System.out.print("ERROR. \nIntroduzca un numero (entero) por favor:");
								sc.nextInt();	
							}
							int tel=sc.nextInt();
							System.out.println("Introduzca el e-mail");
							String mail = sc.next();
							System.out.println("Introduzca la direccion");
							sc.next();
							String dir = sc.nextLine();
							System.out.println("Introduzca el contasena");
							String pass = sc.next();
							
							Doctores auxD = new Doctores (nombre,apellido,fecha,area,dni,tel,mail,dir,pass);
							poweruser.alta_doc(auxD);
							break;	
						case 8://dar alta paciente
							System.out.println("Introduzca el nombre");
							String nombre2 = sc.next();
							System.out.println("Introduzca el apellido");
							String apellido2 = sc.next();
							System.out.println("Introduzca la fecha de nacimiento");
							String fechastr2 = sc.next();
							Date fecha2 = null;
							
							try {
								DateFormat sourceFormat = new SimpleDateFormat("dd/MM/yyyy");
								fecha2 = sourceFormat.parse(fechastr2);
							} catch (java.text.ParseException e) {
								System.out.print("Mal formato de fecha.");
							}
							System.out.println("Introduzca el DNI");
							String dni2 = sc.next();
							System.out.println("Introduzca el telefono");
							while (!sc.hasNextInt()) {
								System.out.print("ERROR. \nIntroduzca un numero (entero) por favor:");
								sc.next();
							}
							int tel2=sc.nextInt();
							System.out.println("Introduzca el e-mail");
							String mail2 = sc.next();
							System.out.println("Introduzca la direccion");
							sc.next();
							String dir2 = sc.nextLine();
							System.out.println("Introduzca el numero de seguridad social");
							while (!sc.hasNextLong()) {
								System.out.print("ERROR! \nIntroduzca un numero (entero) por favor:");
								sc.next();	
							}
							long nss = sc.nextLong();	
							Pacientes auxP = new Pacientes (apellido2,nombre2,fecha2,dni2,tel2,mail2,dir2,nss);
							poweruser.alta_pac(auxP);
							break;	
						case 9://dar baja doctor
							System.out.println("Introduzca el DNI del doctor");
							String dniAuxD = sc.next();
							Doctores dborr = findDocInArr(hospital, dniAuxD);
							if (dborr!=null)
								poweruser.baja_doc(dborr);
							else
								System.out.println("No existe ningun doctor con ese DNI");
							break;
						case 10://dar baja paciente
							System.out.println("Introduzca el DNI del paciente");
							String dniAuxP = sc.next();							
							Pacientes pborr = findPacInArr(hospital, dniAuxP);
							if (pborr!=null)
								poweruser.baja_pac(pborr);
							else
								System.out.println("No existe ningun paciente con ese DNI");
							break;
						case 11://asignar paciente a doctor
							System.out.println("Introduzca el DNI del paciente");
							String dniAuxP1 = sc.next();							
							Pacientes p1 = findPacInArr(hospital, dniAuxP1);
							System.out.println("Introduzca el DNI del doctor");
							String dniAuxD1 = sc.next();
							Doctores d1 = findDocInArr(hospital, dniAuxD1);
							if (p1!=null && d1!=null)
								poweruser.add_pac(p1, d1);
							else
								System.out.println("No se pudo completar la operaci�n, revise los DNIs");
							break;
						case 12://quitar paciente de doctor
							System.out.println("Introduzca el DNI del paciente");
							String dniAuxP2 = sc.next();							
							Pacientes p2 = findPacInArr(hospital, dniAuxP2);
							System.out.println("Introduzca el DNI del doctor");
							String dniAuxD2 = sc.next();
							Doctores d2 = findDocInArr(hospital, dniAuxD2);
							if (p2!=null && d2!=null)
								poweruser.delete_pac(p2, d2);
							else
								System.out.println("No se pudo completar la operaci�n, revise los DNIs");
							break;
						case 13://cambiar contrasena
							System.out.println("Introduzca su nueva contrasena");
							String pwPU = sc.next();
							poweruser.setContrasenia(pwPU);
							break;
						case 14://cambiar contrasena a doctor
							System.out.println("Introduzca el DNI del doctor");
							String dni1 = sc.next();
							Doctores d3 = findDocInArr(hospital, dni1);
							if (d3!=null){
								System.out.println("Introduzca la nueva contrase�a del doctor");
								String newPassDoc = sc.next();
								int posDoc = posDocArr(hospital, dni1);
								hospital.getDoctores().get(posDoc).setContrasena(newPassDoc);		
							}
							else{
								System.out.println("No existe ningun doctor con ese DNI");
							}
							break;
						case 15://total pacientes
							System.out.println("El numero total de pacientes del hospital es "+poweruser.stats_TotalPac());
							break;
						case 16://pacientes por area
							poweruser.stats_PacxArea();
							break;
						case 17://pacientes por doctor
							poweruser.stats_PacxDoc();
							break;
						case 18://anadir cita
							System.out.println("Introduzca el DNI del paciente");
							String dnic1 = sc.next();
							Pacientes p3 = findPacInArr(hospital, dnic1);
							if (p3!=null){
								int posPac = posPacArr(hospital, dnic1);
								System.out.println("Introduzca el tratamiento del paciente");
								String medc1 = sc.next();
								System.out.println("Introduzca el diagnostico del paciente");
								String diagc1 = sc.next();
								System.out.println("Introduzca la fecha de la cita");
								String dsc1 = sc.next();
								Date dc1 = null;
								try {
									DateFormat sourceFormat = new SimpleDateFormat("dd/MM/yyyy");
									dc1 = sourceFormat.parse(dsc1);
								} catch (java.text.ParseException e) {
									System.out.print("Mal formato de fecha.");
								}
								Citas c1 = new Citas (dc1, diagc1, medc1);
								poweruser.add_cita(c1, hospital.getPacientes().get(posPac));
							}
							else{
								System.out.println("No existe ningun paciente con ese DNI");
							}							
							break;
						case 19://editar cita
							System.out.println("Introduzca el DNI del paciente");
							String dnic2 = sc.next();
							Pacientes p4 = findPacInArr(hospital, dnic2);
							if (p4!=null){
								System.out.println("Introduzca la fecha de la cita");
								String dsc2 = sc.next();
								Date dc2 = null;
								try {
									DateFormat sourceFormat = new SimpleDateFormat("dd/MM/yyyy");
									dc2 = sourceFormat.parse(dsc2);
								} catch (java.text.ParseException e) {
									System.out.print("Mal formato de fecha.");
								}
								System.out.println("introduzca el campo a editar medicamento o diagnostico");
								String fieldChange = sc.next();
								System.out.println("Introduzca los nuevos datos");
								String newData = sc.next();
								int posc2 = posPacArr(hospital, dnic2);
								poweruser.editar_cita(dc2, hospital.getPacientes().get(posc2), fieldChange, newData);
							}
							else{
								System.out.println("No existe ningun paciente con ese DNI");
							}	
							break;
						case 20:
							System.out.println("Volver a elegir tipo de usuario");
							break;	
						default:
							System.out.println("Por favor, introduzca un valor valido.");
							break;
						}
						
						
					}
				
					break;	
				case 2:
					//doc: login con 3 intentos maximo
					Doctores user=(Doctores) validar_usuario(hospital, "doc", 3);
					System.out.println("Bienvenido " + user.getNombre() + " " + user.getApellido());
					
					//ahora localizamos la posicion del poweruser dentro del arraylist
					int position=-1;
					for (int i=0; i<hospital.getDoctores().size(); i++){
						if (hospital.getDoctores().get(i).getDni()==user.getDni()){
							position=i;//guardamos la posicion del poweruser
						}
					}

					while(decision!=11 && user!=null) {
						
						System.out.println("\n�Que desea hacer?\n 1. Mostrar pacientes\n 2. Buscar pacientes\n 3. Mostrar citas\n"
								+ " 4. Eliminar cita\n 5. Editar cita\n 6. Ultima modificacion del historial de citas\n 7. Enviar e-mail\n 8. "
								+ "Pacientes totales\n 9. Pacientes por Hospital\n 10. Pacientes por area\n 11. Volver\n");
						
						while (!sc.hasNextInt()) {
							System.out.print("ERROR!. \nIntroduzca un numero (entero) por favor:");
							sc.next();	
						}
						decision=sc.nextInt();
						
						switch(decision){
						case 1://mostrar pacientes
							user.mostrar_pac();
							break;
						case 2://buscar pacientes
							System.out.println("�Porque criterio desea buscar?");
							String filtroD = sc.next();
							System.out.println("Introduzca el termino a buscar");
							Object busquedaD = sc.next();
							hospital.getDoctores().get(position).buscar_paciente(busquedaD, filtroD);
							break;
						case 3://mostrar citas
							//obtenemos posicion del paciente
							System.out.println("Introduzca el DNI del paciente");
							String dnip1 = sc.next();
							Pacientes pd1 = findPacInArr(hospital, dnip1);
							if (pd1!=null){
								int posp1 = posPacArr(hospital, dnip1);
								hospital.getDoctores().get(position).mostrar_citas(
										hospital.getPacientes().get(posp1));
							}
							else
								System.out.println("No existe ningun paciente con ese DNI");
							break;
						case 4://eliminar cita
							System.out.println("Introduzca el DNI del paciente");
							String dnic1 = sc.next();
							Pacientes pc1 = findPacInArr(hospital, dnic1);
							if (pc1!=null){
								int posdc1 = posPacArr(hospital, dnic1);
								
								System.out.println("Introduzca la fecha de la cita con el formato (dd/MM/yyyy)");
								String dsce = sc.next();
								Date dce = null;
								try {
									DateFormat sourceFormat = new SimpleDateFormat("dd/MM/yyyy");
									dce = sourceFormat.parse(dsce);
								} catch (java.text.ParseException e) {
									System.out.print("Mal formato de fecha.");
								}
								
								int posc = buscarPosCita(hospital.getPacientes().get(posdc1).getRegistro_citas(), dce);
								Citas doctorCitaDelete = hospital.getPacientes().get(posdc1).getRegistro_citas().get(posc);
								hospital.getDoctores().get(position).delete_cita(doctorCitaDelete, hospital.getPacientes().get(posdc1));
							}
							else
								System.out.println("No existe ningun paciente con ese DNI");
							break;
						case 5://editar cita
							System.out.println("Introduzca el DNI del paciente");
							String dniece = sc.next();
							Pacientes pedit = findPacInArr(hospital, dniece);
							if (pedit!=null){
								System.out.println("Introduzca la fecha de la cita");
								String dscedit = sc.next();
								Date dcedit = null;
								try {
									DateFormat sourceFormat = new SimpleDateFormat("dd/MM/yyyy");
									dcedit = sourceFormat.parse(dscedit);
								} catch (java.text.ParseException e) {
									System.out.print("Mal formato de fecha.");
								}
								System.out.println("introduzca el campo a editar medicamento o diagnostico");
								String fieldChange2 = sc.next();
								System.out.println("Introduzca los nuevos datos");
								String newData2 = sc.next();
								int posc2 = posPacArr(hospital, dniece);
								user.editar_cita(dcedit, hospital.getPacientes().get(posc2), newData2, fieldChange2);
							}
							else{
								System.out.println("No existe ningun paciente con ese DNI");
							}
							break;
						case 6://ultima mod historial citas
							System.out.println("Introduzca el DNI del paciente");
							String dnip2 = sc.next();
							Pacientes pd2 = findPacInArr(hospital, dnip2);
							if (pd2!=null){
								int posp2 = posPacArr(hospital, dnip2);
								String s = hospital.getDoctores().get(position).mostrar_ult_modif(hospital.getPacientes().get(posp2));
								System.out.println("La ultima modificacion del historial de citas fue "+s);
							}
							else
								System.out.println("No existe ningun paciente con ese DNI");
							break;
						case 7://enviar mail
							System.out.println("Introduzca el DNI del paciente");
							String dnip3 = sc.next();
							Pacientes pd3 = findPacInArr(hospital, dnip3);
							if (pd3!=null){
								int posp3 = posPacArr(hospital, dnip3);
								user.enviarMail(hospital.getPacientes().get(posp3));
							}
							else
								System.out.println("No existe ningun paciente con ese DNI");
							break;	
						case 8://pacientes totales
							System.out.println("El numero de pacientes totales del doctor es "+
									hospital.getDoctores().get(position).stats_pacientes_total());
							break;	
						case 9://pacientes por hospital
							hospital.getDoctores().get(position).stats_PacxHospital(hospital);
							break;
						case 10://pacientes por area
							hospital.getDoctores().get(position).PacxArea(hospital);
							break;
						case 11:
							System.out.println("Volver a elegir tipo de usuario");
							break;	
						default:
							System.out.println("Por favor, introduzca un valor valido.");
							break;
						}
						
					}
					
					break;
				case 3:
					exportar_contrasenas(hospital.getDoctores(), ruta);
					exportar_contrasenas(hospital.getPowerUser(),ruta);
					System.out.println("Fin del programa, gracias por confiar en Clinic Admin.");
					break;
				default:
					System.out.println("Por favor, introduzca un valor valido.");
					break;
			}		
			System.out.println();
		}
		while(decision!=3);
		
		
		sc.close();
	}

}
