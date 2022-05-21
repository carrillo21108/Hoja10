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
class GraphTest {

	@Test
	void algoritmoFloydTest() {
		String valorEsperado = 
				"[0][30][55][70][15]\r\n"
				+ "[30][0][25][40][40]\r\n"
				+ "[55][25][0][15][65]\r\n"
				+ "[70][40][15][0][80]\r\n"
				+ "[15][40][65][80][0]\r\n";
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

}
