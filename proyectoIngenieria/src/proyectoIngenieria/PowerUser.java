package proyectoIngenieria;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import proyectoIngenieria.Doctores.Area;

public class PowerUser {

	//Atributos 
	private String nombre ;
	private String apellido;
	private Date fecha_nacimiento ;
	private String dni ;
	private int telefono ;
	private String email ;
	private String direccion ;
	private String contrasenia ;
	private Hospital hospital;
	
	public PowerUser(String apellido,String nombre, Date fecha_nacimiento, String dni, int telefono,
			  String email, String direccion,  String contrasenia, Hospital hospital) {
		this.nombre=nombre;
		this.setApellido(apellido);
		this.fecha_nacimiento=fecha_nacimiento;
		this.dni=dni;
		this.telefono=telefono;
		this.email=email;
		this.direccion=direccion;
		this.contrasenia=contrasenia;
		this.hospital=hospital;
	}
	
	//Getters y Setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public String getFecha_nacimiento_str() {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy");
		return format.format(fecha_nacimiento);
	}
	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	//Este método se va ausar para que el pueda modificar su propia contraseña
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
	//Para la interfaz
		public Hospital getHospital() {
			return hospital;
		}
		public void setHospital(Hospital hospital) {
			this.hospital = hospital;
		}

	
	//Metodos de poweruser
	public void alta_doc(Doctores doctor) {

		// revisar si no existe ya
		int posicion = buscarPosicion(doctor.getDni(), hospital.getDoctores());

		if (posicion == -1) {
			hospital.getDoctores().add(doctor);
		} else {
			System.out.println("NO SE HA PODIDO DAR DE ALTA. El doctor (" + doctor.getApellido() + " "
					+ doctor.getNombre() + " DNI:" + doctor.getDni() + ") ya estaba dado de alta");
		}

	}
	
	public void alta_pac(Pacientes paciente) {

		// revisar si no existe ya
		int posicion = buscarPosicion(paciente.getDni(), hospital.getDoctores());

		if (posicion == -1) {
			hospital.getPacientes().add(paciente);
		} else {
			System.out.println("NO SE HA PODIDO DAR DE ALTA. El paciente (" + paciente.getApellido() + " "
					+ paciente.getNombre() + " DNI:" + paciente.getDni() + ") ya estaba dado de alta");
		}

	}
	
	public boolean baja_doc(Doctores doctor) {
		boolean borrado = false;

		int posicion = buscarPosicion(doctor.getDni(), hospital.getDoctores());

		if (posicion == -1) {
			System.out.println("NO SE HA PODIDO DAR DE BAJA. El doctor (" + doctor.getApellido() + " "
					+ doctor.getNombre() + " DNI:" + doctor.getDni() + ") NO estaba dado de alta");
		} else {
			hospital.getDoctores().remove(posicion);
			borrado = true;
		}
		return borrado;
	}

	public boolean baja_pac(Pacientes pacientes) {
		boolean borrado = false;

		int posicion = buscarPosicion(pacientes.getDni(), hospital.getPacientes());

		if (posicion == -1) {
			System.out.println("NO SE HA PODIDO DAR DE BAJA. El paciente (" + pacientes.getApellido() + " "
					+ pacientes.getNombre() + " DNI:" + pacientes.getDni() + ") NO estaba dado de alta");
		} else {
			hospital.getPacientes().remove(posicion);
			borrado = true;
		}
		return borrado;
	}
	
	public void add_pac(Pacientes paciente, Doctores doctores) {
		// revisar si no existe ya
		int posicion = buscarPosicion(paciente.getDni(), doctores.getPacientes());

		if (posicion == -1) {
			doctores.getPacientes().add(paciente);
		} else {
			System.out.println("NO SE HA PODIDO DAR DE ALTA. El paciente (" + paciente.getApellido() + " "
					+ paciente.getNombre() + " DNI:" + paciente.getDni() + ") ya estaba dado de alta");
		}

	}

	public boolean delete_pac(Pacientes pacientes, Doctores doctores) {
		boolean borrado = false;

		int posicion = buscarPosicion(pacientes.getDni(), doctores.getPacientes());

		if (posicion == -1) {
			System.out.println("NO SE HA PODIDO DAR DE BAJA. El paciente (" + pacientes.getApellido() + " "
					+ pacientes.getNombre() + " DNI:" + pacientes.getDni() + ") NO estaba dado de alta");
		} else {
			hospital.getPacientes().remove(posicion);
			borrado = true;
		}
		return borrado;
	}
	
	public boolean modificar_contrasenia_doc(Doctores doctor, String contrasenia_nueva) {
		boolean exito = false;
		// revisar si no existe ya
		int posicion = buscarPosicion(doctor.getDni(), hospital.getDoctores());
		
		if (posicion == -1) {
			System.out.println("ERROR AL MODIFICAR CONTRASEÑA.\n" + "El doctor (" + doctor.getApellido() + " "
					+ doctor.getNombre() + " DNI:" + doctor.getDni() + ") NO estaba dado de alta");
		} else {
			hospital.getDoctores().get(posicion).setContrasena(contrasenia_nueva);
			exito = true;
		}

		return exito;
	}

	//Es diferente al de hospital porque no enseña todo, solo nombre y espeacilizacion
	public void mostrar_doc() {
		Iterator<Doctores> itr = hospital.getDoctores().iterator();
		System.out.println("Apellido\t\t" + "Nombre\t\t" + "Area");
		while (itr.hasNext()) {
			Doctores actual = itr.next();
			System.out.println(actual.getApellido() +"\t\t"+ actual.getNombre() +"\t\t"+ actual.getArea());
		}
	}
	
	public int stats_TotalPac() {
		return hospital.getPacientes().size();
	}

	public void stats_PacxArea() {
		int contador=0;
		Map<String, List<Pacientes>> mapPacientesPorArea = new HashMap<String, List<Pacientes>>();
		ArrayList<Doctores> doctores = hospital.getDoctores();
		for(Doctores doctor: doctores) {
			Area area = doctor.getArea();
			if(area != null) {
				String key = area.name();
				List<Pacientes> lstPacientes = mapPacientesPorArea.get(key);
				if(lstPacientes == null) {
					lstPacientes = new ArrayList<Pacientes>();
					mapPacientesPorArea.put(key, lstPacientes);
				}
				List<Pacientes> pacientesDoctor = doctor.getPacientes();
				lstPacientes.addAll(pacientesDoctor);
			}
		}
		
		Set<String>  keySet = mapPacientesPorArea.keySet();
		for(String nombreArea: keySet) {
			System.out.println("Area: "+nombreArea);
			List<Pacientes> pacientes = mapPacientesPorArea.get(nombreArea);
			for(Pacientes pac: pacientes) {
				System.out.println("\tPaciente " + pac.getNombre()+ " "+pac.getApellido() + " \n\tDNI: " + pac.getDni());
				contador++;
			}
			System.out.println("Total de pacientes en " + nombreArea +": "+ contador + "\n");
			contador=0;
		}
		/*
		 * Doctor1 (a1)
		 *   pac1
		 *   pac2
		 *   
		 *  Doctor2 (a2)
		 *    pac3
		 *    pac4
		 *    pac5
		 *
		 *  Doctor3 (a2)
		 *    pac6
		 *    pac7
		 *    
		 *    a1 
		 *    pac1, 
		 *    pac2
		 *    
		 *    a2
		 *    pac3
		 *    pac4
		 *    pac5
		 *    pac6
		 *    pac7
		 *   
		 * */
		
	}
	
	public void stats_PacxDoc() {
		int contador=0;
		ArrayList<Doctores> doctores = hospital.getDoctores();
		for(Doctores doctor: doctores) {
			System.out.println("Doctor: "+doctor.getNombre()+" "+doctor.getApellido()+"\n");
			ArrayList<Pacientes> pacientes = doctor.getPacientes();
			for (Pacientes pac : pacientes) {
				System.out.println("\tPaciente "+ pac.getNombre()+ " "+pac.getApellido() + " \n\tDNI: " + pac.getDni());
				contador++;
			}
			System.out.println("Total de pacientes: " + contador + "\n");
			contador=0;
		}
		/*
		 * Doctor1 (a1)
		 *   pac1
		 *   pac2
		 *   
		 *  Doctor2 (a2)
		 *    pac3
		 *    pac4
		 *    pac5
		 *
		 *  Doctor3 (a2)
		 *    pac6
		 *    pac7
		 *   
		 * */
	}
	
	public boolean editar_cita(Date fecha, Pacientes pacientes, String campo, String new_dato) {
		boolean exito = false;
		String campo_lc = campo.toLowerCase();

		int posicionpaciente = buscarPosicion(pacientes.getDni(), hospital.getPacientes());


		if (posicionpaciente == -1) {
			System.out.println("NO SE HA PODIDO ENCONTRAR PACIENTE. El paciente (" + pacientes.getApellido() + " "
					+ pacientes.getNombre() + " DNI:" + pacientes.getDni() + ") NO existe.");
			
			
		} else {
			int posicion = buscarPosicion_cita(fecha, pacientes.getRegistro_citas());
			if (posicion==-1) {
				System.out.println("ERROR AL EDITAR LA CITA.\n La cita del paciente " + pacientes.getApellido()
				+ " " + pacientes.getNombre() + " DNI:" + pacientes.getDni() + " con fecha " + fecha + " "
						+ ") NO fue encontrada");
			}else {
				if (campo_lc.equals("diagnostico")) {
					pacientes.getRegistro_citas().get(posicion).setDiagnostico(new_dato);
					exito = true;
				}
				else if (campo_lc.equals("medicamento")) {
					pacientes.getRegistro_citas().get(posicion).setMedicamiento(new_dato);
					exito = true;
				}
				else {
					System.out.println("ERROR AL EDITAR LA CITA.\n El campo " + campo + "no es válido");
				}
			}
			

			if (exito) {
				pacientes.setModificacion_registro(new Date());
			}
			
		}
		return exito;
		
	}

	public boolean add_cita(Citas citas, Pacientes pacientes) {
		boolean exito = false;

		int posicion = buscarPosicion_cita(citas.getFecha(), pacientes.getRegistro_citas());

		if (posicion == -1) {
			pacientes.getRegistro_citas().add(citas);
			//Esto actualiza la ultima modificación a la fevha actual
			pacientes.setModificacion_registro(new Date());
			exito=true;
		} else {
			System.out.println("NO SE HA PODIDO AGREGAR CITA.\n La cita del paciente " + pacientes.getApellido() + " "
					+ pacientes.getNombre() + " DNI:" + pacientes.getDni() + " con fecha " + citas.getFecha() + " "
					+ "ya existe");
		}

		return exito;
	}
	
	// metodos extras
	//metodo para buscar la existencia de un paciente o doctor y su posición en el array
	private int buscarPosicion(String dni, ArrayList datos) {
		int posicion = -1; // -1 si no encuentro. X si aparece
		int indice_arraylist = 0; // lo necesitamos para recorrer el array

		if (0 < datos.size() && datos.get(0) instanceof Pacientes) {
			while (posicion == -1 && indice_arraylist < datos.size()) {
				if (((ArrayList<Pacientes>) datos).get(indice_arraylist).getDni().equals(dni)) {
					// Lo encontró!
					posicion = indice_arraylist;
				}
				indice_arraylist++;
			}
		} else if (0 < datos.size() && datos.get(0) instanceof Doctores) {
			while (posicion == -1 && indice_arraylist < datos.size()) {
				if (((ArrayList<Doctores>) datos).get(indice_arraylist).getDni().equals(dni)) {
					// Lo encontró!
					posicion = indice_arraylist;
				}
				indice_arraylist++;
			}
		}

		return posicion;
	}
	
	//metodo para buscar la existencia de una cita y su posición en el array
	//metodo para buscar la existencia de un paciente o doctor y su posición en el array
	private int buscarPosicion_cita(Date fecha, ArrayList<Citas> datos) {
		int posicion = -1; // -1 si no encuentro. X si aparece
		int indice_arraylist = 0; // lo necesitamos para recorrer el array

		while (posicion == -1 && indice_arraylist < datos.size()) {
			if (datos.get(indice_arraylist).getFecha().compareTo(fecha)==0) {
				// Lo encontró!
				posicion = indice_arraylist;
			}
			indice_arraylist++;
		}

		return posicion;
	}
	
	//Para la interfaz
		public String[][] getDatostabla(char c) {
			if (c=='d'){
				String[][] datos = new String[hospital.getDoctores().size()+1][9];
				Iterator<Doctores> itr = hospital.getDoctores().iterator();
				String[] array = {"Apellido" , "Nombre" ,"Fecha de nacimiento" , "AREA","DNI" , "telefono" , "email"
						, "direccion" , "archivo de pacientes"};
				datos[0] =array;
				int i=0;
				while (itr.hasNext()) {
					Doctores actual = itr.next();
					String [] array1= {actual.getApellido(), actual.getNombre(), actual.getFecha_nacimiento_str(), ""+actual.getArea(), actual.getDni(), ""+actual.getTelefono(), 
							actual.getEmail(),actual.getDireccion(), "citas_"+actual.getDni()+".csv"};
					datos[i+1]=array1;
					i++;
				}
				return datos;
			} else if (c == 'p') {
				String[][] datos = new String[hospital.getPacientes().size()+1][10];
				Iterator<Pacientes> itr = hospital.getPacientes().iterator();
				String[] array = {"Apellido" , "Nombre" ,"Fecha de nacimiento" , "DNI" , "telefono" , "email"
						, "direccion" , "Seguridad social" , "archivo de citas" ,"Ultima modificacion"};
				datos[0] =array;
				int i=0;
				while (itr.hasNext()) {
					Pacientes actual = itr.next();
					String [] array1= {actual.getApellido(), actual.getNombre(), actual.getFecha_nacimiento_str(), actual.getDni(), ""+actual.getTelefono(), actual.getEmail(),
							actual.getDireccion(), ""+actual.getSeguridad_social(), "citas_"+actual.getDni()+".csv", ""+actual.getModificacion_registro()};
					datos[i+1]=array1;
					i++;
				}
				
				return  datos;
			}
			
			return null;
		}
		
		
		/*public String toString(char c) {
				String resultado ="";
				
			if (c == 'd') {
				resultado = "Apellido\t\t" + "Nombre\t" + "Pacientes\t  "+ "Area\t" +"\n";
				Iterator<Doctores> itr = hospital.getDoctores().iterator();
				while (itr.hasNext()) {
					Doctores actual = itr.next();
					resultado += actual.getApellido() + "\t\t" + actual.getNombre() +"\t       " + (actual.getPacientes().size())
							+ "\t  " + actual.getArea()  +"\n";
				}
			}
			else if (c == 'p') {
				resultado = "Apellido\t\t" + "Nombre\t\t" + "N seguridad social" + "\n";
				Iterator<Pacientes> itr = hospital.getPacientes().iterator();
				while (itr.hasNext()) {
					Pacientes actual = itr.next();
					resultado += actual.getApellido() + "\t" + actual.getNombre() + "\t\t" + actual.getSeguridad_social() + "\n";
				}
			}
				
				return resultado;
			}*/

}