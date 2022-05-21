/**
 * 
 */
package uvg.edu.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import uvg.edu.common.AlgoritmoFloyd;
import uvg.edu.common.Controller;
import uvg.edu.common.Graph;
import uvg.edu.io.Reader;

/**
 * @author Brian Carrillo
 *
 */
class GraphTest {

	@Test
	void algoritmoFloydTest_MatrizAdyacencia() {
		String valorEsperado = 
				"[0][30][55][70][15]\n"
				+ "[30][0][25][40][40]\n"
				+ "[55][25][0][15][65]\n"
				+ "[70][40][15][0][80]\n"
				+ "[15][40][65][80][0]\n";
		AlgoritmoFloyd algoritmo = new AlgoritmoFloyd();
		Scanner scanner = new Scanner(System.in);
		//Solicitud de la ruta del archivo.
		System.out.println("Ingrese la ruta en la que se encuentra el archivo .txt a escanear.");
		String ruta = scanner.nextLine();
		
		//Instancia de la clase que escaneara ListadoProducto.txt
		Reader reader = new Reader();
		ArrayList<String> ciudades = reader.obtenerCiudades(ruta);
		Graph matriz = reader.leerTxt(ruta);
		ArrayList<String>respuestas = algoritmo.algoritmoFloyd(ciudades, matriz);
		String valorRecibido = respuestas.get(0);
		assertEquals(valorEsperado, valorRecibido);	
	}
	
	@Test
	void centerGraph() {
		String valorEsperado = "Antigua";
		AlgoritmoFloyd algoritmo = new AlgoritmoFloyd();
		Scanner scanner = new Scanner(System.in);
		//Solicitud de la ruta del archivo.
		System.out.println("Ingrese la ruta en la que se encuentra el archivo .txt a escanear.");
		String ruta = scanner.nextLine();
		
		//Instancia de la clase que escaneara ListadoProducto.txt
		Reader reader = new Reader();
		ArrayList<String> ciudades = reader.obtenerCiudades(ruta);
		Graph matriz = reader.leerTxt(ruta);

		Controller controlador = new Controller(ciudades, matriz);
		String valorRecibido = controlador.centerGraph();
		
		assertEquals(valorEsperado, valorRecibido);	
	}
	
	@Test
	void algoritmoFloydTest_Rutas() {
		String valorEsperado = 
				"0, 1, 0, 1\n"
				+ "0, 2, 0, 1, 2\n"
				+ "0, 3, 0, 1, 2, 3\n"
				+ "0, 4, 0, 4\n"
				+ "1, 0, 1, 0\n"
				+ "1, 2, 1, 2\n"
				+ "1, 3, 1, 2, 3\n"
				+ "1, 4, 1, 4\n"
				+ "2, 0, 2, 1, 0\n"
				+ "2, 1, 2, 1\n"
				+ "2, 3, 2, 3\n"
				+ "2, 4, 2, 1, 4\n"
				+ "3, 0, 3, 2, 0\n"
				+ "3, 1, 3, 2, 1\n"
				+ "3, 2, 3, 2\n"
				+ "3, 4, 3, 2, 4\n"
				+ "4, 0, 4, 0\n"
				+ "4, 1, 4, 1\n"
				+ "4, 2, 4, 1, 2\n"
				+ "4, 3, 4, 1, 2, 3\n";
		AlgoritmoFloyd algoritmo = new AlgoritmoFloyd();
		Scanner scanner = new Scanner(System.in);
		//Solicitud de la ruta del archivo.
		System.out.println("Ingrese la ruta en la que se encuentra el archivo .txt a escanear.");
		String ruta = scanner.nextLine();
		
		//Instancia de la clase que escaneara ListadoProducto.txt
		Reader reader = new Reader();
		ArrayList<String> ciudades = reader.obtenerCiudades(ruta);
		Graph matriz = reader.leerTxt(ruta);
		ArrayList<String>respuestas = algoritmo.algoritmoFloyd(ciudades, matriz);
		String valorRecibido = respuestas.get(1);
		assertEquals(valorEsperado, valorRecibido);	
	}

}
