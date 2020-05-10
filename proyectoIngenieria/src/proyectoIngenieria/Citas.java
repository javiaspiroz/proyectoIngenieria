package proyectoIngenieria;

import java.util.Date;

public class Citas {

	//Atributos
	private Date fecha ;
	private String diagnostico ;
	private String medicamientos ;
	private String cantidad ; 
	private String frecuencia ;
	
	//Constructor
	public Citas(Date fecha, String diagnostico, String medicamientos, String cantidad, String frecuencia) {
		this.fecha = fecha;
		this.diagnostico = diagnostico;
		this.medicamientos = medicamientos;
		this.cantidad = cantidad;
		this.frecuencia = frecuencia;
	}
	
	//Getters y Setters
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getDiagnostico() {
		return diagnostico;
	}
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}
	public String getMedicamiento() {
		return medicamientos;
	}
	public void setMedicamiento(String medicamiento) {
		this.medicamientos = medicamiento;
	}
	public String getCantidad() {
		return cantidad;
	}
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	public String getFrecuencia() {
		return frecuencia;
	}
	public void setFrecuencia(String frecuencia) {
		this.frecuencia = frecuencia;
	}
	
	
}

