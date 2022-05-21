/**
 * 
 */
package uvg.edu.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import uvg.edu.common.AlgoritmoFloyd;
import uvg.edu.common.Graph;
import uvg.edu.io.Reader;

/**
 * @author Brian Carrillo
 *
 */
class GraphOperationTest {

	@Test
	void agregarConexion() {
		String valorEsperado 
			= "[0][30][55][70][15][1000000000][1000000000]\n"
					+ "[30][0][25][40][40][1000000000][1000000000]\n"
					+ "[55][25][0][15][65][1000000000][1000000000]\n"
					+ "[70][40][15][0][80][1000000000][1000000000]\n"
					+ "[15][40][65][80][0][1000000000][1000000000]\n"
					+ "[1000000000][1000000000][1000000000][1000000000][1000000000][0][30]\n"
					+ "[1000000000][1000000000][1000000000][1000000000][1000000000][30][0]\n";
		Reader reader = new Reader();
		AlgoritmoFloyd algoritmo = new AlgoritmoFloyd();
		Scanner scanner = new Scanner(System.in);
		//Solicitud de la ruta del archivo.
		System.out.println("Ingrese la ruta en la que se encuentra el archivo .txt a escanear.");
		String ruta = scanner.nextLine();
		
		String origen = "Petapa";
		String destino = "Amatitlan";
		String distancia = "30";
		
		ArrayList<String> ciudades = new ArrayList<String>();
		
		reader.update(ruta,origen,destino,distancia);
		ciudades = reader.obtenerCiudades(ruta);
		Graph matriz2 = reader.leerTxt(ruta);
		
		ArrayList<String>respuestas = algoritmo.algoritmoFloyd(ciudades, matriz2);
		String valorRecibido = respuestas.get(0);
		assertEquals(valorEsperado, valorRecibido);	
	}
	
	
	@Test
	void eliminarConexion() {
		String valorEsperado 
		= "[0][30][55][70][15]\n"
				+ "[30][0][25][40][40]\n"
				+ "[55][25][0][15][65]\n"
				+ "[70][40][15][0][80]\n"
				+ "[15][40][65][80][0]\n";
		Reader reader = new Reader();
		AlgoritmoFloyd algoritmo = new AlgoritmoFloyd();
		Scanner scanner = new Scanner(System.in);
		//Solicitud de la ruta del archivo.
		System.out.println("Ingrese la ruta en la que se encuentra el archivo .txt a escanear.");
		String ruta = scanner.nextLine();
		
		String origen = "Petapa";
		String destino = "Amatitlan";
		String distancia = "30";
		
		ArrayList<String> ciudades = new ArrayList<String>();
		
		reader.delete(ruta,origen,destino,distancia);
		ciudades = reader.obtenerCiudades(ruta);
		Graph matriz2 = reader.leerTxt(ruta);
		
		ArrayList<String>respuestas = algoritmo.algoritmoFloyd(ciudades, matriz2);
		String valorRecibido = respuestas.get(0);
		assertEquals(valorEsperado, valorRecibido);	
	}

}
