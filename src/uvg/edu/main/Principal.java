/**
 * 
 */
package uvg.edu.main;

import java.util.ArrayList;
import java.util.Scanner;

import uvg.edu.common.AlgoritmoFloyd;
import uvg.edu.common.Controller;
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
		
		//Instancia del scanner
		Scanner scanner = new Scanner(System.in);
		//Solicitud de la ruta del archivo.
		System.out.println("Ingrese la ruta en la que se encuentra el archivo .txt a escanear.");
		String ruta = scanner.nextLine();
		
		//Instancia de la clase que escaneara ListadoProducto.txt
		Reader reader = new Reader();
		ArrayList<String> ciudades = reader.obtenerCiudades(ruta);
		Graph matriz = reader.leerTxt(ruta);
		
		Controller controller = new Controller(ciudades, matriz);
		
		//
		System.out.println("Ingrese el nombre de la ciudad origen.");
		String ciudadOrigen = scanner.nextLine();
		
		System.out.println("Ingrese el nombre de la ciudad destino.");
		String ciudadDestino = scanner.nextLine();
		
		System.out.println(controller.obtenerRuta(ciudadOrigen,ciudadDestino));
	}

}