package proyectoIngenieria;

import java.util.Date;
import java.util.Vector;

public class PowerUser  {

	//Atributos 
	private String nombre ;
	private Date fecha_nacimiento ;
	private String dni ;
	private int telefono ;
	private String email ;
	private String direccion ;
	private String contrasenia ;
	
	//Getters y Setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
	//Metodos
	public PowerUser(String nombre, Date fecha_nacimiento, String dni,
						  int telefono, String email, String direccion, 
						  String contrasenia) {
		
	}
	public Doctores alta_doc_sP(String nombre, String apellido, 
								Date fecha_nacimiento,Area area,
								String dni, int telefono, String email,
								String direccion, String contrasenia) {
		return null;
		
	}
	public Doctores alta_doc_cP(String nombre, String apellido, 
			Date fecha_nacimiento,Area area,
			String dni, int telefono, String email,
			String direccion, String contrasenia,
			Vector<Pacientes> pacientes) {
		return null;

	}
	public Pacientes alta_pac_cC(String nombre, String apellido, Date fecha_nacimiento,
								String dni, int telefono, String email,
								String direccion, long seguridad_social, 
								Vector<Citas> registro_citas, Date modificacion_registro) {
		return null;
		
	}
	public Pacientes alta_pac_sC(String nombre, String apellido, Date fecha_nacimiento,
								String dni, int telefono, String email,
								String direccion, long seguridad_social, 
								Vector<Citas> registro_citas, Date modificacion_registro) {
	   return null;

	}
	public boolean baja_doc(Doctores doctores) {
		return false;
	}
	
	public boolean baja_pac(Pacientes pacientes) {
		return false;
	}
	
	public boolean add_pac(Pacientes pacientes, Doctores doctores) {
		return false ;
	}
	
	public boolean delete_pac(Pacientes pacientes, Doctores doctores) {
		return false ;
	}
	
	public void set_contrasenia(String contrasenia) {
		
	}
	
	public boolean modificar_contrasenia_doc(Doctores doctores,
											String contrasenia_nueva) {
		return false ;
	}
		
	public int stats_TotalPac() {
		return 0;
		
	}
	
	public void stats_PacxArea() {
		
	}
	
	public void stats_PacxDoc() {
		
	}
	
	public void editar_cita(Date fecha, Pacientes pacientes) {
		
	}

	public boolean add_cita(Citas citas, Pacientes pacientes) {
		return false ;
	}
	
	
	
	
	
	
	
}
