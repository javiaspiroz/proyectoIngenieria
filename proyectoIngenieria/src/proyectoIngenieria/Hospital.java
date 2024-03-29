package proyectoIngenieria;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

import proyectoIngenieria.Doctores.Area;

public class Hospital {

	// Atributos
	private ArrayList<Pacientes> pacientes;
	private ArrayList<Doctores> doctores;
	private ArrayList<PowerUser> powerUser;
	String rutaraiz;

	// Constructor
	public Hospital(ArrayList<Pacientes> pacientes, ArrayList<Doctores> doctores, ArrayList<PowerUser> powerUser) {
		this.pacientes = pacientes;
		this.doctores = doctores;
		this.powerUser = powerUser;
	}

	//Constructir2
	public Hospital(String rutaraiz, String ruta_pacientes) {
		this.rutaraiz=rutaraiz;
		this.pacientes = importar_csv_pacientes(rutaraiz+ruta_pacientes);
		this.doctores = importar_csv_doctores();
		this.powerUser = importar_csv_poweruser(); 
		//cambiar por importar_csv_poweruser() cuando este el doc
	}

	// Getters y setters
	public ArrayList<Pacientes> getPacientes() {
		return pacientes;
	}

	public void setPacientes(ArrayList<Pacientes> pacientes) {
		this.pacientes = pacientes;
	}

	public ArrayList<Doctores> getDoctores() {
		return doctores;
	}

	public void setDoctores(ArrayList<Doctores> doctores) {
		this.doctores = doctores;
	}

	public ArrayList<PowerUser> getPowerUser() {
		return powerUser;
	}

	public void setPowerUser(ArrayList<PowerUser> powerUser) {
		this.powerUser = powerUser;
	}

	// Metodos
	
	public ArrayList<Pacientes> importar_csv_pacientes(String ruta) {
		File fichero = new File(ruta);
		String[][] datos = new String[contar_filas(ruta)][contar_columnas(ruta)];
		String linea = "";
		ArrayList<Pacientes> new_pacientes = new ArrayList<Pacientes>(contar_filas(ruta));

		DateFormat sourceFormat = new SimpleDateFormat("dd/MM/yyyy");
		DateFormat sourceFormat1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		try {
			Scanner leer = new Scanner(fichero);

			int i = 0;
			while (leer.hasNextLine()) {
				linea = leer.nextLine();
				datos[i] = linea.split(";");
				if (i > 0) {
					Pacientes new_paciente = new Pacientes(datos[i][0], datos[i][1], sourceFormat.parse(datos[i][2]),
							datos[i][3], Integer.parseInt(datos[i][4]), datos[i][5], datos[i][6],
							Long.parseLong(datos[i][7]), importar_Citas(datos[i][8]), sourceFormat1.parse(datos[i][9]));
					new_pacientes.add(new_paciente);
				}
				i++;
			}
		} catch (FileNotFoundException e) {
			//System.out.println("Fichero 'dg" + ruta + "' no encontrado!");
		} catch (NumberFormatException e) {
			System.out.println("Mal formato de numero");
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return new_pacientes;

	}

	public ArrayList<Doctores> importar_csv_doctores() {
		String ruta=rutaraiz+"/login_usuarios.csv";
		File fichero = new File(ruta);
		String[][] datos = new String[contar_filas(ruta)][contar_columnas(ruta)];
		String linea = "";
		ArrayList<Doctores> new_docs = new ArrayList<Doctores>(contar_filas(ruta));
		DateFormat sourceFormat = new SimpleDateFormat("dd/MM/yyyy");

		try {
			Scanner leer = new Scanner(fichero);

			int i = 0;
			while (leer.hasNextLine()) {
				linea = leer.nextLine();
				datos[i] = linea.split(";");
				if (i > 0) {
					Doctores new_doc = new Doctores(datos[i][0], datos[i][1], sourceFormat.parse(datos[i][2]),
							Enum.valueOf(Doctores.Area.class, datos[i][3].toUpperCase()), datos[i][4],
							Integer.parseInt(datos[i][5]), datos[i][6], datos[i][7], importar_csv_pacientes(datos[i][8]),
							datos[i][9]);
					new_docs.add(new_doc);
				}
				i++;
			}
		} catch (FileNotFoundException e) {
			System.out.println("Fichero '" + ruta + "' no encontrado!");
		} catch (NumberFormatException e) {
			System.out.println("Mal formato de numero");
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return new_docs;

	}

	public ArrayList<PowerUser> importar_csv_poweruser() {
		String ruta = rutaraiz+"/login_powerusers.csv";
		File fichero = new File(ruta);
		String[][] datos = new String[contar_filas(ruta)][contar_columnas(ruta)];
		String linea = "";
		ArrayList<PowerUser> new_docs = new ArrayList<PowerUser>(contar_filas(ruta));
		DateFormat sourceFormat = new SimpleDateFormat("dd/MM/yyyy");

		try {
			Scanner leer = new Scanner(fichero);

			int i = 0;
			while (leer.hasNextLine()) {
				linea = leer.nextLine();
				datos[i] = linea.split(";");
				if (i > 0) {
					PowerUser new_doc = new PowerUser(datos[i][0], datos[i][1], sourceFormat.parse(datos[i][2]),
							datos[i][3], Integer.parseInt(datos[i][4]), datos[i][5], datos[i][6], datos[i][7], this);
					new_docs.add(new_doc);
				}
				i++;
			}
		} catch (FileNotFoundException e) {
			System.out.println("Fichero '" + ruta + "' no encontrado!");
		} catch (NumberFormatException e) {
			System.out.println("Mal formato de numero");
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return new_docs;

	}

	public void exportar_csv(String ruta, char tipo) {
		FileWriter fichero = null;

		try {
			fichero = new FileWriter(rutaraiz+"/"+ruta);
			// Escribimos linea a linea en el fichero
			
			// Para exportar un archivo de pacientes
			if (tipo == 'P') {
				
				Iterator<Pacientes> itr = pacientes.iterator();
				fichero.write("Apellido;Nombre;fecha de nacimiento ;DNI;telefono;email;"
						+ "direccion;N Seguridad social;archivo de citas;Ultima modificacion de citas;\n");
				while (itr.hasNext()) {
					Pacientes actual = itr.next();
					fichero.write(actual.getApellido() + ";" + actual.getNombre() + ";"
							+ actual.getFecha_nacimiento_str() + ";" + actual.getDni() + ";" + actual.getTelefono()
							+ ";" + actual.getEmail() + ";" + actual.getDireccion() + ";" + actual.getSeguridad_social()
							+ ";" + "citas_" + actual.getDni() + ".csv" + ";" + actual.getModificacion_registro_str());
					fichero.write("\n");
					exportar_csv_citas(actual);
				}
			}
			// Para exportar un archivo de doctores
			else if (tipo == 'D') {
				Iterator<Doctores> itr = doctores.iterator();
				fichero.write(
						"Apellido;Nombre;fecha de nacimiento ;Area;DNI;telefono;email;direccion;archivo de pacientes;\n");
				while (itr.hasNext()) {
					Doctores actual = itr.next();
					fichero.write(actual.getApellido() + ";" + actual.getNombre() + ";"
							+ actual.getFecha_nacimiento_str() + ";" + actual.getArea() + ";" + actual.getDni() + ";"
							+ actual.getTelefono() + ";" + actual.getEmail() + ";" + actual.getDireccion() + ";"
							+ "pac_" + actual.getDni() + ".csv");
					fichero.write("\n");
					exportar_csv_pac(actual);
					
				}
			}
			// Para exportar un archivo de powerusers
			else if (tipo == 'W') {
				Iterator<PowerUser> itr = powerUser.iterator();
				fichero.write("Apellido;Nombre;fecha de nacimiento;DNI;telefono;email;direccion;\n");
				while (itr.hasNext()) {
					PowerUser actual = itr.next();
					fichero.write(actual.getApellido() + ";" + actual.getNombre() + ";"
							+ actual.getFecha_nacimiento_str() + ";" + actual.getDni() + ";" + actual.getTelefono()
							+ ";" + actual.getEmail() + ";" + actual.getDireccion() + ";");
					fichero.write("\n");
				}
			}

			fichero.close();

			System.out.println("Los datos se han guardado en el fichero " + ruta);

		} catch (Exception ex) {
			System.out.println("Mensaje de la excepción: " + ex.getMessage());
		}
	}

	public void mostrar_doc() {
		Iterator<Doctores> itr = doctores.iterator();
		while (itr.hasNext()) {
			Doctores actual = itr.next();
			System.out.println(actual);
			System.out.println("-------------------------------");
		}
	}

	public void mostrar_pac() {
		Iterator<Pacientes> itr = pacientes.iterator();
			
		while (itr.hasNext()) {
			Pacientes actual = itr.next();
			System.out.println(actual);
			System.out.println("-------------------------------");
		}

	}
	
	/*ESTE Y EL DE ABAJO SE PUEDEN ELIMINAR CREO*/
	// Este es para buscar un paciente en especifico.
	//Devuelve null si no lo encuentra
	public Pacientes buscar_paciente(String dni) {
		boolean encontrado=false;
		Pacientes paciente = null;
		Iterator<Pacientes> itr = pacientes.iterator();
		while(itr.hasNext() && encontrado==false) {
			Pacientes actual = itr.next();
			if (actual.getDni().equals(dni)) {
				encontrado= true;
				paciente = actual;
			}
		}
		return paciente;
	}

	// Este es para buscar un doctor en especifico
	public Doctores buscar_doc(String dni) {
		boolean encontrado=false;
		Doctores doctor = null;
		Iterator<Doctores> itr = doctores.iterator();
		while(itr.hasNext()&& encontrado==false) {
			Doctores actual = itr.next();
			if (actual.getDni().equals(dni)) {
				encontrado= true;
				doctor = actual;
			}
		}
		return doctor;
	}

	// Este es para buscar doctores segun un filtro
	public void filtrar_doctores(String filtro, Object busqueda) {
		filtro = filtro.toLowerCase();
		Doctores actual;

		Iterator<Doctores> itr = doctores.iterator();

		if (busqueda instanceof String) {
			String search = (String) busqueda;
			if (filtro.equals("nombre")) {
				while (itr.hasNext()) {
					actual = itr.next();
					if (actual.getNombre().contains(search)) {
						System.out.println(actual);
					}
				}
			} else if (filtro.contains("apellido")) {
				while (itr.hasNext()) {
					actual = itr.next();
					if (actual.getApellido().toLowerCase().contains(search.toLowerCase())) {
						System.out.println(actual);
					}
				}

			} else if (filtro.equals("dni")) {
				while (itr.hasNext()) {
					actual = itr.next();
					if (actual.getDni().equals(search)) {
						System.out.println(actual);
					}
				}

			} else if (filtro.equals("email")) {
				while (itr.hasNext()) {
					actual = itr.next();
					if (actual.getEmail().equals(search)) {
						System.out.println(actual);
					}
				}

			} else if (filtro.equals("direccion")) {
				while (itr.hasNext()) {
					actual = itr.next();
					if (actual.getDireccion().contains(search)) {
						System.out.println(actual);
					}
				}
			} else if (filtro.equals("fecha de nacimiento")) {
				//Poner la fecha de nacimiento en formato dd/mm/yy
				while (itr.hasNext()) {
					actual = itr.next();
					if (actual.getFecha_nacimiento_str().equals(search)) {
						System.out.println(actual);
					}
				}

			} else if (filtro.equals("area")) {
				while (itr.hasNext()) {
					actual = itr.next();
					if (actual.getArea().name().equalsIgnoreCase(search)) {
						System.out.println(actual);
					}
				}
			}else {
				System.out.println("No hubo resultados");
			}

		} else if (busqueda instanceof Integer) {
			int search = (Integer) busqueda;
			if (filtro.equals("telefono")) {
				while (itr.hasNext()) {
					actual = itr.next();
					if (actual.getTelefono() == search) {
						System.out.println(actual);
					}
				}
			} else {
				System.out.println("No hubo resultados");
			}

		} 
	}

	// Este es para buscar pacientes segun un filtro
	public void filtrar_pacientes(String filtro, Object busqueda) {
		filtro = filtro.toLowerCase();
		Pacientes actual;
		
		Iterator<Pacientes> itr = pacientes.iterator();

			if (busqueda instanceof String) {
				String search = (String) busqueda;
				if (filtro.equals("nombre")) {
					while (itr.hasNext()) {
						actual = itr.next();
						if (actual.getNombre().contains(search)) {
							System.out.println(actual);
						}
					}
				} else if (filtro.equals("apellido")) {
					while (itr.hasNext()) {
						actual = itr.next();
						if (actual.getApellido().toLowerCase().contains(search.toLowerCase())) {
							System.out.println(actual);
						}
					}
				} else if (filtro.equals("dni")) {
					while (itr.hasNext()) {
						actual = itr.next();
						if (actual.getDni().equals(search)) {
							System.out.println(actual);
						}
					}

				} else if (filtro.equals("email")) {
					while (itr.hasNext()) {
						actual = itr.next();
						if (actual.getEmail().equals(search)) {
							System.out.println(actual);
						}
					}

				} else if (filtro.equals("direccion")) {
					while (itr.hasNext()) {
						actual = itr.next();
						if (actual.getDireccion().contains(search)) {
							System.out.println(actual);
						}
					}
				} else if (filtro.equals("fecha de nacimiento")) {
					//Poner la fecha de nacimiento en formato dd/mm/yy
					while (itr.hasNext()) {
						actual = itr.next();
						if (actual.getFecha_nacimiento_str().equals(search)) {
							System.out.println(actual);
						}
					}

				} else {
					System.out.println("No hubo resultados");
				}

				
			} else if (busqueda instanceof Integer) {
				int search = (Integer) busqueda;
				if (filtro.equals("telefono")) {
					while (itr.hasNext()) {
						actual = itr.next();
						if (actual.getTelefono() == search) {
							System.out.println(actual);
						}
					}
				} else {
					System.out.println("No hubo resultados");
				}

			} else if (busqueda instanceof Long) {
				long search = (Long) busqueda;
				if (filtro.equals("seguridad social")) {
					while (itr.hasNext()) {
						actual = itr.next();
						if (actual.getSeguridad_social() == search) {
							System.out.println(actual);
						}
					}
				} else {
					System.out.println("No hubo resultados");
				}

		}
	}

	// Metodos auxiliares
	// Funcion AUX: para contar columnas del csv para luego usar al crear la matriz
	protected static int contar_columnas(String ruta) {
		File fichero = new File(ruta);
		int columnas = 0;
		String linea = "";

		try {
			Scanner leer = new Scanner(fichero);
			if (leer.hasNextLine()) { // solo mira si hay algo escrito en la primera linea y toma esa como referencia
				linea = leer.nextLine();
				String[] columna = linea.split(","); // Guardar los datos de la linea separados por ; como elementos
				// individuales en un array
				columnas = columna.length; // El numero de columnas será la cantidad de elementos del array
			}
		} catch (FileNotFoundException e) {
			// System.out.println("Fichero '"+ ruta +"' no encontrado!");
		}

		return columnas;
	}

	// Funcion AUX: para contar filas del csv para luego usar al crear la matriz
	protected static int contar_filas(String ruta) {
		File fichero = new File(ruta);
		int filas = 0;

		try {
			Scanner leer = new Scanner(fichero);
			while (leer.hasNextLine()) {
				leer.nextLine();
				filas++;
			}
			leer.close();
		} catch (FileNotFoundException e) {
			// System.out.println("Fichero '"+ ruta +"' no encontrado!");
		}

		return filas;
	}

	//Para importar los historiales de citas junto con los pacientes
	private ArrayList<Citas> importar_Citas(String ruta) {

		File fichero = new File(ruta);
		String[][] datos = new String[contar_filas(ruta)][contar_columnas(ruta)];
		String linea = "";
		ArrayList<Citas> new_citas = new ArrayList<Citas>(contar_filas(ruta));
		DateFormat sourceFormat = new SimpleDateFormat("dd/MM/yyyy");

		try {
			

			Scanner leer = new Scanner(fichero);

			int i = 0;
			while (leer.hasNextLine()) {
				linea = leer.nextLine();
				datos[i] = linea.split(";");
				if (i > 0) {
					Citas new_cita = new Citas(sourceFormat.parse(datos[i][0]), datos[i][1], datos[i][2]);
					new_citas.add(new_cita);
				}
				i++;
			}
		} catch (FileNotFoundException e) {
			// e.printStackTrace();
			//System.out.println("Fichero '" + ruta + "' no encontrado!");

		} catch (NumberFormatException e) {
			System.out.println("Mal formato de numero");
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return new_citas;

	}

	//Para exportar los historiales de citas junto con los de pacientes
	public void exportar_csv_citas(Pacientes paciente) {
		FileWriter fichero = null;
		DateFormat sourceFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			
			
			// Escribimos linea a linea en el fichero
			Iterator<Citas> itr = paciente.getRegistro_citas().iterator();
			
			while (itr.hasNext()) {
				Citas actual = itr.next();
				if (actual!=null) {
					fichero = new FileWriter("citas_" + paciente.getDni() + ".csv");
					fichero.write("Fecha;Diagnostico;medicamentos;\n");
				fichero.write(sourceFormat.format(actual.getFecha()) + ";" + actual.getDiagnostico() + ";"
						+ actual.getMedicamiento() + ";");
				fichero.write("\n");
				}

			}
			fichero.close();

			System.out.println("Los datos se han guardado en el fichero citas_" + paciente.getDni() + ".csv");

		} catch (Exception ex) {
			if (fichero==null) {
			System.out.println("El paciente " + paciente.getDni() + " no tiene citas");
			}
		}
	}

	// Para exportar los pacientes de cada doctor individual
	public void exportar_csv_pac(Doctores doctor) {
		FileWriter fichero = null;
		DateFormat sourceFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {

			// Escribimos linea a linea en el fichero
			Iterator<Pacientes> itr = doctor.getPacientes().iterator();

			while (itr.hasNext()) {
				Pacientes actual = itr.next();
				if (actual != null) {
					fichero = new FileWriter("pac_" + doctor.getDni() + ".csv");
					fichero.write("Apellido;Nombre;fecha de nacimiento ;DNI;telefono;email;"
							+ "direccion;N Seguridad social;archivo de citas;Ultima modificacion de citas;\n");
					fichero.write(actual.getApellido() + ";" + actual.getNombre() + ";"
							+ actual.getFecha_nacimiento_str() + ";" + actual.getDni() + ";" + actual.getTelefono()
							+ ";" + actual.getEmail() + ";" + actual.getDireccion() + ";" + actual.getSeguridad_social()
							+ ";" + "citas_" + actual.getDni() + ".csv" + ";" + actual.getModificacion_registro_str());
					fichero.write("\n");
					exportar_csv_citas(actual);
				}

			}
			fichero.close();

			System.out.println("Los datos se han guardado en el fichero pac_" + doctor.getDni() + ".csv");

		} catch (Exception ex) {
			if (fichero==null) {
			System.out.println("El doctor " + doctor.getDni() + " no tiene pacientes asignados");
			}
		}
	}

}
