/**
 * 
 */
package uvg.edu.main;

import java.util.ArrayList;
import java.util.Scanner;

import uvg.edu.common.AlgoritmoFloyd;
import uvg.edu.common.Graph;
import uvg.edu.io.Conexion;
import uvg.edu.io.Reader;

/**
 * @author Brian Carrillo
 *
 */
public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AlgoritmoFloyd algoritmo = new AlgoritmoFloyd();
		//Instancia del scanner
		Scanner scanner = new Scanner(System.in);
		//Solicitud de la ruta del archivo.
		System.out.println("Ingrese la ruta en la que se encuentra el archivo .txt a escanear.");
		String ruta = scanner.nextLine();
		
		//Instancia de la clase que escaneara ListadoProducto.txt
		Reader reader = new Reader();
		ArrayList<String> ciudades = reader.obtenerCiudades(ruta);
		Graph matriz = reader.leerTxt(ruta);

		ArrayList<String> respuestas = algoritmo.algoritmoFloyd(ciudades, matriz);
		System.out.println(respuestas.get(1));
	}

}