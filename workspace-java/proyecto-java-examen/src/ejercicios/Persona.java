package ejercicios;

import java.time.LocalDate;

/*
 * 
 * TipoDocumento - enum (dni/libretacivica) 
 * NroDocumento - Integer
 * Nombre - String
 * Apellido - String
 * FechaNacimiento - Date
 * 
 */

public class Persona {

	private String nombre;
	private String apellido;
	private LocalDate fechaNacimiento;
	private TipoDocumento tipoDocumento; 
	private Integer numeroDocumento;

	public enum TipoDocumento {
	    DNI("DNI"), LIBRETA_CIVICA("Libreta Cívica");

	    public final String texto;

	    private TipoDocumento(String tipoDoc) {
	    	this.texto = tipoDoc;
	    }
	}
	
	Persona() {
		
	}
	
	Persona (String nombre, String apellido, LocalDate fechaNacimiento, TipoDocumento tipoDocumento, Integer numeroDocumento) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
	}

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

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public Integer getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(Integer numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
}




 