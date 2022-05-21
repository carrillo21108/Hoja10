/**
 * 
 */
package uvg.edu.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

/**
 * @author Brian Carrillo
 *
 */
public class Controller {
	
	AlgoritmoFloyd algoritmo = new AlgoritmoFloyd();
	ArrayList<String> ciudades = new ArrayList<String>();
	Graph matriz;
	ArrayList<String> respuestas;
	
	public Controller(ArrayList<String> ciudades, Graph matriz) {
		respuestas = algoritmo.algoritmoFloyd(ciudades, matriz);
		this.ciudades = ciudades;
		this.matriz = matriz;
	}
	
	public void modificarCiudades(ArrayList<String> ciudades) {
		this.ciudades = ciudades;
	}
	
	public void modificarMatriz(Graph matriz) {
		this.matriz = matriz;
	}
	
	public boolean validacionGrafo(Graph matriz) {
		boolean result = true;
		for(int i=0;i<matriz.tamaño();i++) {
			for(int j=0;j<matriz.tamaño();j++) {
				long valor = matriz.devolver(i, j);
				if(valor==999999999) {
					result = false;
					break;
				}
			}
		}
		return result;
	}
	
	public String obtenerRuta(String ciudadOrigen, String ciudadDestino) {
		String result = "Sin resultados";
		
		if(ciudades.contains(ciudadOrigen) && ciudades.contains(ciudadDestino)) {
			String caminitos = respuestas.get(1);
			String[]lineas = caminitos.split("\n");
			
			for(String linea:lineas) {
				String[]valores = linea.split(", ");
				if(ciudades.get(Integer.parseInt(valores[0])).equals(ciudadOrigen) && ciudades.get(Integer.parseInt(valores[1])).equals(ciudadDestino)) {
					result = "Para ir de "+ciudadOrigen+" hasta "+ciudadDestino+", debe recorrer "+matriz.devolver(Integer.parseInt(valores[0]), Integer.parseInt(valores[1]))+" KM\n";
					result += "La ruta a seguir sera:";
					
					for(int i=2;i<valores.length;i++) {
						result += "  "+ciudades.get(Integer.parseInt(valores[i]));
					}
				}
			}
		}else {
			
			result = "Ingresos invalidos, intente de nuevo.";
		}
		
		return result;
	}
	
	public String centerGraph() {
		
		ArrayList<String> respuestas = algoritmo.algoritmoFloyd(ciudades, matriz);
		System.out.println(respuestas.get(0));
		HashMap<Integer, Long> association = new HashMap<Integer, Long>();
		

		for( int i=0; i<ciudades.size(); i++) {
			ArrayList<Long> numeros = new ArrayList<Long>();
			for( int j=0; j<ciudades.size(); j++) {
				numeros.add(matriz.devolver(j, i));		
			}
			association.put(i, Collections.max(numeros));
		}
		
		Long menor = Collections.min(association.values());
		Integer columna = null;
		
		// iterate each entry of hashmap
	    for(Entry<Integer, Long> entry: association.entrySet()) {

	      // if give value is equal to value from entry
	      // print the corresponding key
	      if(entry.getValue() == menor) {
	        columna = entry.getKey();
	        break;
	      }
	    }
		
		return ciudades.get(columna);
	}

	
	
}
