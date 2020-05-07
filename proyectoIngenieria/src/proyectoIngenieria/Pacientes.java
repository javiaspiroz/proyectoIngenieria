package proyectoIngenieria;

import java.util.Date;
import java.util.Vector;

public class Pacientes {

	//Atributos
	private String nombre ;
	private String apellido ;
	private Date fecha_nacimiento ;
	private String dni ;
	private int telefono ;
	private String email ;
	private String direccion ;
	private long seguridad_social ;
	private Vector<Citas> registro_citas ;
	private Date modificacion_registro ;
	
	//Getters y setters 
	public String getNombre() {
		return nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
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
	public long getSeguridad_social() {
		return seguridad_social;
	}
	public void setSeguridad_social(long seguridad_social) {
		this.seguridad_social = seguridad_social;
	}
	public Vector<Citas> getRegistro_citas() {
		return registro_citas;
	}
	public void setRegistro_citas(Vector<Citas> registro_citas) {
		this.registro_citas = registro_citas;
	}
	public Date getModificacion_registro() {
		return modificacion_registro;
	}
	public void setModificacion_registro(Date modificacion_registro) {
		this.modificacion_registro = modificacion_registro;
	}
	
	
}
