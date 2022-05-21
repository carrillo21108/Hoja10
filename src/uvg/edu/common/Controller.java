/**
 * 
 */
package uvg.edu.common;

import java.util.ArrayList;

/**
 * @author Brian Carrillo
 *
 */
public class Controller {
	
	AlgoritmoFloyd algoritmo = new AlgoritmoFloyd();
	ArrayList<String> ciudades = new ArrayList<String>();
	Graph matriz;
	
	public Controller(ArrayList<String> ciudades, Graph matriz) {
		this.ciudades = ciudades;
		this.matriz = matriz;
	}
	
	public String obtenerRuta(String ciudadOrigen, String ciudadDestino) {
		String result = "Sin resultados";
		
		ArrayList<String> respuestas = algoritmo.algoritmoFloyd(ciudades, matriz);
		
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
}
