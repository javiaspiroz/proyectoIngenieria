package proyectoIngenieria;

import java.util.Date;
import java.util.Vector;

public class Hospital extends PowerUser {

	public Hospital(String nombre, Date fecha_nacimiento, String dni, int telefono, String email, String direccion,
			String contrasenia) {
		super(nombre, fecha_nacimiento, dni, telefono, email, direccion, contrasenia);
	}

	//Atributos
	private Vector<Pacientes> pacientes ;
	private Vector<Doctores> doctores ;
	private Vector<PowerUser> powerUser ;
	
	//Getters y setters
	public Vector<Pacientes> getPacientes() {
		return pacientes;
	}
	public void setPacientes(Vector<Pacientes> pacientes) {
		this.pacientes = pacientes;
	}
	public Vector<Doctores> getDoctores() {
		return doctores;
	}
	public void setDoctores(Vector<Doctores> doctores) {
		this.doctores = doctores;
	}
	public Vector<PowerUser> getPowerUser() {
		return powerUser;
	}
	public void setPowerUser(Vector<PowerUser> powerUser) {
		this.powerUser = powerUser;
	}
	
	
	//Metodos
	public  Pacientes buscar_pac(Object busqueda, String filtro) {
		return null;
		
	}
	
	public Doctores buscar_doc(Object busqueda , String filtro) {
		return null ;
	}
	
	//He puesto metodo void a importar y a exportar porque no sabia que ponerle
	public void importar_csv(String ruta) {
		
	}
	
	public void exportar_csv(String ruta) {
		
	}
	
	public void mostrar_doc() {
		
	}
	
	public void mostrar_pac() {
		
	}
	
}

	

