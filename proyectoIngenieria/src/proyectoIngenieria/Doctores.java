package proyectoIngenieria;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Doctores {

	//Atributos 
	public enum Area {ONCOLOGIA, OFTALMOLOGIA, TRAUMATOLOGIA, GINECOLOGIA, PEDIATRIA, CARDIOLOGIA, DERMATOLOGIA, GERIATRIA}
	private String nombre ;
	private String apellido ;
	private Date fecha_nacimiento ;
	private Area area ;
	private String dni ;
	private int telefono ;
	private String email ;
	private String direccion ;
	private String contrasenia ;
	private ArrayList<Pacientes> pacientes;
	
	//Constructor1
	public Doctores(String apellido,String nombre, Date fecha_nacimiento, Area area, String dni, int telefono,
			String email, String direccion, ArrayList<Pacientes> pacientes, String contrasenia) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.fecha_nacimiento = fecha_nacimiento;
		this.area = area;
		this.dni = dni;
		this.telefono = telefono;
		this.email = email;
		this.direccion = direccion;
		this.contrasenia = contrasenia;
		this.pacientes = pacientes;
	}
	
	//Constructor2
	public Doctores(String nombre, String apellido, Date fecha_nacimiento, Area area, String dni, int telefono,
			String email, String direccion, String contrasenia) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.fecha_nacimiento = fecha_nacimiento;
		this.area = area;
		this.dni = dni;
		this.telefono = telefono;
		this.email = email;
		this.direccion = direccion;
		this.contrasenia = contrasenia;
		this.pacientes = new ArrayList<Pacientes>();
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
	public Area getArea() {
		return area;
	}
	public void setArea(Area area) {
		this.area = area;
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
	public String getContrasena() {
		return contrasenia;
	}
	public void setContrasena(String contrasena) {
		this.contrasenia = contrasena;
	}
	public ArrayList<Pacientes> getPacientes() {
		return pacientes;
	}
	public void setPacientes(ArrayList<Pacientes> pacientes) {
		this.pacientes = pacientes;
	}
	
	//Metodos
	public void mostrar_pac(){	
		Iterator<Pacientes> itr = pacientes.iterator();
		System.out.println(
				"Apellido\t\t" + "Nombre\t\t" + "Fecha de nacimiento\t" + "DNI\t\t" + "telefono\t" + "email\t\t\t"
						+ "direccion\t\t\t\t\t" + "Seguridad social\t" + "archivo de citas\t" + "Ultima modificacion");
		while (itr.hasNext()) {
			Pacientes actual = itr.next();
			System.out.println(actual);
		}

		
	}
	public Pacientes buscar_paciente(Object busqueda, String filtro) {
		filtro = filtro.toLowerCase();
		Pacientes actual = null;
		
		Iterator<Pacientes> itr = pacientes.iterator();
		System.out.println(
				"Apellido\t\t" + "Nombre\t\t" + "Fecha de nacimiento\t" + "DNI\t\t" + "telefono\t" + "email\t\t\t"
						+ "direccion\t\t\t\t\t" + "Seguridad social\t" + "archivo de citas\t" + "Ultima modificacion");
		// if (!itr.hasNext()) throw new NoSuchElementException();

		
			if (busqueda instanceof String) {
				String search = (String) busqueda;
				if (filtro.equals("nombre")) {
					while (itr.hasNext()) {
						actual = itr.next();
						if (actual.getNombre().equals(search)) {
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

		
		return actual;
	}
	
	public void mostrar_citas(Pacientes pacientes) {
		
		if (pacientes.getRegistro_citas().size()>0){
			Iterator<Citas> itr = pacientes.getRegistro_citas().iterator();
			System.out.println(
					"Fecha\tDiagnostico\t\t\tMedicamentos" );
			while (itr.hasNext()) {
				Citas actual = itr.next();
				System.out.println(actual);
			}
		}
		else
			System.out.println("El paciente no tiene citas programadas");
	}
	
	public boolean add_cita(Citas citas, Pacientes pacientes) {
		boolean exito = false;
		int posicion = buscarPosicion(pacientes.getDni(), this.pacientes);

		if (posicion == -1) {
			System.out.println("NO SE HA PODIDO ENCONTRAR PACIENTE. El paciente (" + pacientes.getApellido() + " "
					+ pacientes.getNombre() + " DNI:" + pacientes.getDni() + ") NO esta asigando al doctor" + nombre
					+ " " + apellido);

		} else {
			int posicioncita = buscarPosicion_cita(citas.getFecha(), pacientes.getRegistro_citas());
			if (posicioncita == -1) {
				pacientes.getRegistro_citas().add(citas);
				// Esto actualiza la ultima modificación a la fevha actual
				pacientes.setModificacion_registro(new Date());
				exito = true;
			} else {
				System.out.println("NO SE HA PODIDO AGREGAR CITA.\n La cita del paciente " + pacientes.getApellido()
						+ " " + pacientes.getNombre() + " DNI:" + pacientes.getDni() + " con fecha " + citas.getFecha()
						+ " " + "ya existe");
			}

		}
		return exito;
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
		
	public  boolean delete_cita(Citas citas, Pacientes pacientes) {
		boolean borrado = false;

		int posicion = buscarPosicion(pacientes.getDni(), this.pacientes);

		if (posicion == -1) {
			System.out.println("NO SE HA PODIDO ENCONTRAR PACIENTE. El paciente (" + pacientes.getApellido() + " "
					+ pacientes.getNombre() + " DNI:" + pacientes.getDni() + ") NO esta asigando al doctor"
							+ nombre + " " + apellido);
		} else {
			int posicioncita = buscarPosicion_cita(citas.getFecha(), pacientes.getRegistro_citas());
			if (posicioncita == -1) {
				System.out.println("NO SE HA PODIDO ENCONTRAR CITA. La cita del paciente " + pacientes.getApellido() + " "
				+ pacientes.getNombre() + " DNI:" + pacientes.getDni() + " con fecha " + citas.getFecha() + " "
				+ "no existe");

			} else {
				pacientes.getRegistro_citas().remove(posicioncita);
				borrado=true;
			}
		}
		return borrado;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
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
	
	
	public boolean editar_cita(Date fecha,Pacientes pacientes,String busqueda,String filtro) {
		//he cambiado el object por string y luego lo he cambiado donde lo necesitaba y en vez de campo he puesto filtro
		boolean exito = false;
		String campo_lc = filtro.toLowerCase();

		int poscionpaciente = buscarPosicion(pacientes.getDni(), this.pacientes);
		

		if (poscionpaciente == -1) {
			System.out.println("NO SE HA PODIDO ENCONTRAR PACIENTE. El paciente (" + pacientes.getApellido() + " "
					+ pacientes.getNombre() + " DNI:" + pacientes.getDni() + ") NO esta asigando al doctor"
							+ nombre + " " + apellido);
			
			
		} else {
			int posicion = buscarPosicion_cita(fecha, pacientes.getRegistro_citas());
			if (posicion==-1) {
				System.out.println("ERROR AL EDITAR LA CITA.\n La cita del paciente " + pacientes.getApellido()
				+ " " + pacientes.getNombre() + " DNI:" + pacientes.getDni() + " con fecha " + fecha + " "
						+ ") NO fue encontrada");
			}else {
				if (campo_lc.equals("diagnostico")) {
					pacientes.getRegistro_citas().get(posicion).setDiagnostico(busqueda);
					exito = true;
				}
				else if (campo_lc.equals("medicamento")) {
					pacientes.getRegistro_citas().get(posicion).setMedicamiento(busqueda);
					exito = true;
				}
				else {
					System.out.println("ERROR AL EDITAR LA CITA.\n El campo " + filtro + "no es válido");
				}
			}
			

			if (exito) {
				pacientes.setModificacion_registro(new Date());
			}
			
		}
		return exito;
		
	}

	public String mostrar_ult_modif(Pacientes paciente) {
		String ultima_mod = paciente.getModificacion_registro_str();
			return ultima_mod;
		
	}
	
	public void enviarMail(Pacientes paciente) {
		//Origen
		final String fromEmail = "merakiteamapps@gmail.com";
		final String password = "proyectos2020";
		
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		
		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail,password);
			}
		});

		Message mensaje = prepararMensaje(session, fromEmail, paciente);

		try {
			Transport.send(mensaje);
			System.out.println("Email enviado");
		} catch (MessagingException e) {
			System.out.println("Ocurrió un error: No se pudo enviar el correo. ");
		}
		

	}

	public static Message prepararMensaje(Session session, String origen, Pacientes paciente) {

		// Citas ult_cita = null;

		try {
			Citas ult_cita = paciente.getRegistro_citas().get(paciente.getRegistro_citas().size() - 1);

			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(origen));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(paciente.getEmail()));
			msg.setSubject("Diagnóstico de la cita del " + ult_cita.getFecha_str());
			msg.setText("Hola, " + paciente.getNombre() + " " + paciente.getApellido() + "\n"
					+ "\nGracias por confiar en nosotros.\nA continuación la información de su última cita médica.\n "
					+ "\nFecha: " + ult_cita.getFecha_str() + "\nPaciente: " + paciente.getNombre() + " "
					+ paciente.getApellido() + "\nDiágnostico: " + ult_cita.getDiagnostico()
					+ "\nTratamiento: " + ult_cita.getMedicamiento());
			return msg;

		} catch (AddressException e) {
			System.out.println("Ocurrio un error con la dirección de correo proporcionada");
		} catch (MessagingException e) {
			System.out.println("Ocurrió un error con el mensaje del correo");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("El paciente no tiene ninguna cita registrada");
		}

		return null;
	}

	public int stats_pacientes_total() {
		
		return this.pacientes.size();

	}

	public void stats_PacxHospital(Hospital hospital) {
		double porcentaje = (this.pacientes.size() * 100) / hospital.getPacientes().size();
		System.out.println("El Dr. " + nombre + " " + apellido + "tiene asignados " + this.pacientes.size() + " pacientes."
				+ "\nLo que corresponde al " + porcentaje + "% de pacientes del hospital");

	}

	public void PacxArea(Hospital hospital) {
		// Esto esta separando los pacientes por areas
		Map<String, List<Pacientes>> mapPacientesPorArea = new HashMap<String, List<Pacientes>>();
		ArrayList<Doctores> doctores = hospital.getDoctores();
		for (Doctores doctor : doctores) {
			Area area = doctor.getArea();
			if (area != null) {
				String key = area.name();
				List<Pacientes> lstPacientes = mapPacientesPorArea.get(key);
				if (lstPacientes == null) {
					lstPacientes = new ArrayList<Pacientes>();
					mapPacientesPorArea.put(key, lstPacientes);
				}
				List<Pacientes> pacientesDoctor = doctor.getPacientes();
				lstPacientes.addAll(pacientesDoctor);
			}
		}

		// Aqui saco cuantos pacientes hay en el area que me interesa
		List<Pacientes> lstPacientes = mapPacientesPorArea.get(area.name());

		// Saco el porcentaje basado en cuantos hay en el area del doctor y cuantos
		// tiene el doctor
		
		int porcentaje=0;
		if (lstPacientes.size()!=0)
			porcentaje = (this.pacientes.size() * 100) / lstPacientes.size();

		System.out.println("El Dr. " + nombre + " " + apellido + "tiene asignados " + this.pacientes.size()
				+ " pacientes del area de " + area.name() + ". " + "\nLo que corresponde al " + porcentaje
				+ "% de pacientes del area");

	}

	// Metodos aux
	@Override
	public String toString() {

		return apellido + "\t\t" + nombre + "\t\t" + getFecha_nacimiento_str() + "\t\t" + area + "\t" + dni + "\t"
				+ telefono + "\t\t" + email + "\t" + direccion + "\t\t" + "pac_" + dni + ".csv" + "\t";

	}

}
