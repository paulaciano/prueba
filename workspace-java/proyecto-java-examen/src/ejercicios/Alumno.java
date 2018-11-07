package ejercicios;

import java.time.LocalDate;

public class Alumno extends Persona{

	private Integer legajo;
	
	public Alumno() {}
	
	Alumno(String nombre, String apellido, LocalDate fechaNacimiento , TipoDocumento tipoDocumento, Integer numeroDocumento, Integer legajo){
		super(nombre, apellido, fechaNacimiento, tipoDocumento, numeroDocumento);
		this.legajo = legajo;
	}

	public Integer getLegajo() {
		return legajo;
	}
	public void setLegajo(Integer legajo) {
		this.legajo = legajo;
	}
}
