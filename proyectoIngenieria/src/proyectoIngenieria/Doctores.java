package proyectoIngenieria;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
	
	//Metodos aux
	@Override
	public String toString() {

		return apellido + "\t\t" + nombre + "\t\t" + getFecha_nacimiento_str() + "\t\t" + area + "\t" + dni + "\t" + telefono + "\t\t"
				+ email + "\t" + direccion + "\t\t" + "pac_" + dni + ".csv" + "\t";

	}
	
}
