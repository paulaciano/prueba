package ejercicios;

import java.time.LocalDate;
import java.time.Month;

import ejercicios.Persona.TipoDocumento;

/**
 * A. Crear una clase Persona con los siguientes campos
 * (con sus respectivos getters, setters y constructor)
 * 
 * TipoDocumento - enum (dni/libretacivica) 
 * NroDocumento - Integer
 * Nombre - String
 * Apellido - String
 * FechaNacimiento - Date
 * 
 * B. En el método main de la clase "Ejercicio2" crear una nueva instancia
 * de la clase persona y settearle valores reales con tus datos
 * 
 * 
 * C. En el método main de la clase "Ejercicio 2" imprimir los valores en 
 * consola 
 * (crear método main e imprimir valores) 
 *  
 * @author examen
 *
 */
public class Ejercicio2 {

	/**
	 * 
	 */
	public Ejercicio2() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Persona persona  = new Persona();
		persona.setNombre("Paula");
		persona.setApellido("Ciano");
		persona.setFechaNacimiento(LocalDate.of(1981, Month.JANUARY, 06));
		persona.setTipoDocumento(TipoDocumento.DNI);
		persona.setNumeroDocumento(28557372);
		
		imprimirValores(persona);
	}
	
	static void imprimirValores(Persona persona) {
		System.out.println("Persona:");
		System.out.println("Nombre: " + persona.getNombre());
		System.out.println("Apellido: " + persona.getApellido());
		System.out.println("Nacimiento: " + persona.getFechaNacimiento());
		System.out.println(persona.getTipoDocumento() + ": " + persona.getNumeroDocumento());
	}

}
