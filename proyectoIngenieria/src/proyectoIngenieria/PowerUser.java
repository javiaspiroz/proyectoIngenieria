package proyectoIngenieria;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

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
		return 0;
		
	}
	
	public void stats_PacxArea() {
		
	}
	
	public void stats_PacxDoc() {
		
	}
	
	public boolean editar_cita(Date fecha, Pacientes pacientes, String campo, String new_dato) {
		boolean exito = false;
		String campo_lc = campo.toLowerCase();

		int posicion = buscarPosicion_cita(fecha, pacientes.getRegistro_citas());

		if (posicion == -1) {
			System.out.println("ERROR AL EDITAR LA CITA.\n La cita del paciente " + pacientes.getApellido()
			+ " " + pacientes.getNombre() + " DNI:" + pacientes.getDni() + " con fecha " + fecha + " "
					+ ") NO fue encontrada");
		} else {
			if (campo_lc.equals("diagnostico")) {
				pacientes.getRegistro_citas().get(posicion).setDiagnostico(new_dato);
				exito = true;
			}
			else if (campo_lc.equals("medicamento")) {
				pacientes.getRegistro_citas().get(posicion).setMedicamiento(new_dato);
				exito = true;
			}
			else if (campo_lc.equals("cantidad")) {
				pacientes.getRegistro_citas().get(posicion).setCantidad(new_dato);
				exito = true;
			}
			else if (campo_lc.equals("frecuencia")) {
				pacientes.getRegistro_citas().get(posicion).setFrecuencia(new_dato);
				exito = true;
			}
			else {
				System.out.println("ERROR AL EDITAR LA CITA.\n El campo " + campo + "no es válido");
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

}
