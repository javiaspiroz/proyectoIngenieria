package proyectoIngenieria;

import java.util.Date;
import java.util.Vector;

public class Doctores {

	//Atributos 
	private String nombre ;
	private String apellido ;
	private Date fecha_nacimiento ;
	private Area area ;
	private String dni ;
	private int telefono ;
	private String email ;
	private String direccion ;
	private String contrasenia ;
	private Vector<Pacientes> pacientes ;
	
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
	public Vector<Pacientes> getPacientes() {
		return pacientes;
	}
	public void setPacientes(Vector<Pacientes> pacientes) {
		this.pacientes = pacientes;
	}
	
	//Metodos
	public void mostrar_pac(){	
	}
	public Pacientes buscar_paciente(Object busqueda, String filtro) {
		return null;
	}
	public void mostrar_citas(Pacientes pacientes) {	
	}
	public void add_cita(Citas citas, Pacientes pacientes) {
		
	}
	public void delete_cita(Citas citas, Pacientes pacientes) {
		
	}
	public void editar_cita(Citas citas,Pacientes pacientes,Object busqueda,String filtro) {
		
	}
	public Date mostrar_ult_modif() {
		return null;
		
	}
	public void enviar_email(Pacientes pacientes) {
		
	}
	public int stats_pacientes_total() {
		return 0;
		
	}
	public void stats_PacxHospital(int numeroH) {
		
	}
	public void PacxArea(int numeroA) {
		
	}
	
}
