package ejercicios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ejercicio4 {

	// listas de ejemplo, pueden variarse su contenido, 
	static Integer[] valoresLista1 = {1, 2, 5, 8, 10, 30, 20, 8, 9, 10};
	static Integer[] valoresLista2 = {1, 2, 4, 20, 5, 10, 7, 8, 10, 9};

	/**	 
	 * Para ejecutar el método main se debe hacer boton derecho sobre la clase
	 * "Run As --> Java Application" 
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("**** inicializando datos ****");
		
		List<Integer> lista1 = new ArrayList<Integer>(Arrays.asList(valoresLista1));
		List<Integer> lista2 = new ArrayList<Integer>(Arrays.asList(valoresLista2));
	
		System.out.println("**** inicializacion exitosa ****");
		
		System.out.println("Lista 1 : " + lista1.toString());
		System.out.println("Lista 2 : " + lista2.toString());
		System.out.println();

		// EJERCICIO 4.1: explicar salidas y sugerir mejoras
		informacion(lista1, 10);
		
		// EJERCICIO 4.2: corregir el metodo
		List<Integer> union = unionListas(lista1, lista2);
		System.out.println("Union: " + union.toString());
		
		// EJERCICIO 4.3: implementar
		List<Integer> interseccion = interseccionListas(lista1, lista2);
		System.out.println("Interseccion: " + interseccion.toString());
		
		// EJERCICIO 4.4: implementar
		List<Integer> orden1 = ordenaListaAscendente(lista1);
		System.out.println("Orden asc: " + orden1);
		
		// EJERCICIO 4.5: implementar
		List<Integer> orden2 = ordenaListaDescendente(lista2);
		System.out.println("Orden desc: " + orden2);

		// EJERCICIO 4.6: implementar
		boolean b = tienenMismoContenido(lista1, lista2);
		System.out.println("Mismo contenido: " + b);
		
	}

	private static void informacion(List<Integer> lista1, Integer numero) {
		// TODO: explicar salidas de los system out y sugerir alguna mejora a la implementacion
		
		int pares = 0;
		List<Integer> impares = new ArrayList<Integer>();
		int c = 0;
		for (Integer n: lista1) {
			if (n % 2 == 0) {
				pares = pares + 1;				
			} else {
				impares.add(n);
			}			
			if (n > numero) {
				c = c + 1;
			}
		}
		
		System.out.println("Cantidad de n�meros pares en la lista: " + pares);
		
		System.out.println("N�meros impares de la lista: " + impares.toString());
		
		int p = lista1.size() / 2;
		
		System.out.println("N�mero del medio de la primer lista: " + lista1.indexOf(p));
		
		if (c > lista1.size() / 2) {
			System.out.println("M�s de la mitad de los n�meros de la primer lista son mayores que " + numero + ".");
		} else if (c > 0) {
			System.out.println("Menos de la mitad de los n�meros de la primer lista son mayores que " + numero + ".");
		} else {
			System.out.println("No hay n�meros mayores que " + numero + "en la primer lista.");
		}
	}

	/***
	 * @param lista1
	 * @param lista2
	 * 
	 * retornar una lista que contenga los elementos de ambas listas, sin elementos repetidos 
	 * 
	 */
	private static List<Integer> unionListas(List<Integer> lista1, List<Integer> lista2) {
		// TODO: corregir el metodo para que funcione correctamente 
		
		List<Integer> union = new ArrayList<Integer>();
		
		union.addAll(lista1);
		
		for (Integer m: lista2) {
			if (!union.contains(m)) {
				union.add(m);
			}
		}
		
		return union;
	}

	/***
	 * @param lista1
	 * @param lista2
	 * 
	 * retornar una lista que contenga los elementos que estan presentes en ambas listas, sin elementos repetidos 
	 * 
	 */
	private static List<Integer> interseccionListas(List<Integer> lista1, List<Integer> lista2) {
		// TODO:
		
		List<Integer> interseccion = new ArrayList<Integer>();
		
		for (Integer m: lista1) {
			if (lista2.contains(m)) {
				interseccion.add(m);
			}
		}
				
		return interseccion;
	}

	/***
	 * @param lista1
	 * 
	 * retornar la lista recibida, ordenada en forma ascendente
	 * 
	 */
	private static List<Integer> ordenaListaAscendente(List<Integer> lista1) {
		// TODO:

		Collections.sort(lista1, new IntegerComparatorAsc());
		
		return lista1;
	}
	



	/***
	 * @param lista2
	 * 
	 * retornar la lista recibida, ordenada en forma descendente
	 * 
	 */
	private static List<Integer> ordenaListaDescendente(List<Integer> lista2) {
		// TODO:
		Collections.sort(lista2, new IntegerComparatorDesc());
		
		return lista2;
	}

	/***
	 * @param lista1
	 * @param lista2
	 * 
	 * devuelve true si contienen los mismos elementos
	 * NO se considera valido que esten en diferente orden
	 * NO se considera valido que la cantidad de repeticiones de los elementos sea diferente
	 * 
	 */
	private static boolean tienenMismoContenido(List<Integer> lista1, List<Integer> lista2) {
		if (lista1.size()!= lista2.size()) return false;
		for (Integer n : lista1) {
			if (!lista2.contains(n)) return false;
		}
		return true;
	}
		
}

class IntegerComparatorDesc implements Comparator<Integer> {
    @Override
    public int compare(Integer n, Integer m) {
        return n < m ? 1 : n == m ? 0 : -1;
    }
}

class IntegerComparatorAsc implements Comparator<Integer> {
    @Override
    public int compare(Integer n, Integer m) {
        return n < m ? -1 : n == m ? 0 : 1;
    }
}