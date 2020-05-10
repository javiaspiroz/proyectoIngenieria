package proyectoIngenieria;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

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
	private ArrayList<Citas> registro_citas ;
	private Date modificacion_registro ;
	
	//Constructor
	public Pacientes(String apellido,String nombre,  Date fecha_nacimiento, String dni, int telefono, String email,
			String direccion, long seguridad_social, ArrayList<Citas> citas, Date modificacion) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.fecha_nacimiento = fecha_nacimiento;
		this.dni = dni;
		this.telefono = telefono;
		this.email = email;
		this.direccion = direccion;
		this.seguridad_social = seguridad_social;
		//this.ruta_citas=ruta;
		this.registro_citas = citas;
		this.modificacion_registro = modificacion;
	}
	
	public Pacientes(String apellido,String nombre, Date fecha_nacimiento, String dni, int telefono, String email,
			String direccion, long seguridad_social) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.fecha_nacimiento = fecha_nacimiento;
		this.dni = dni;
		this.telefono = telefono;
		this.email = email;
		this.direccion = direccion;
		this.seguridad_social = seguridad_social;
		//this.ruta_citas=ruta;
		this.registro_citas = new ArrayList<Citas>();
		this.modificacion_registro = new Date();
	}
	
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
	public long getSeguridad_social() {
		return seguridad_social;
	}
	public void setSeguridad_social(long seguridad_social) {
		this.seguridad_social = seguridad_social;
	}
	public ArrayList<Citas> getRegistro_citas() {
		return registro_citas;
	}
	public void setRegistro_citas(ArrayList<Citas> registro_citas) {
		this.registro_citas = registro_citas;
	}
	public Date getModificacion_registro() {
		return modificacion_registro;
	}
	public String getModificacion_registro_str() {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy HH:mm");
		return format.format(modificacion_registro);
	}
	public void setModificacion_registro(Date modificacion_registro) {
		this.modificacion_registro = modificacion_registro;
	}

	//Metodos extras
	@Override
	public String toString () {
		
		return apellido + "\t\t" + nombre + "\t\t" + getFecha_nacimiento_str() + "\t\t"+ dni + "\t" + telefono + "\t\t" + email + 
				"\t" + direccion + "\t\t" + seguridad_social + "\t\t" + "citas_"+dni+".csv" + "\t" + getModificacion_registro_str();
				
	}
	
	
	
}
