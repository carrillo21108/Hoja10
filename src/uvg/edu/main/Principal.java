/**
 * 
 */
package uvg.edu.main;

import java.util.Scanner;

import uvg.edu.common.AlgoritmoFloyd;
import uvg.edu.common.Graph;
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
				
		//Instancia de la clase que escaneara guategrafo.txt
		Reader reader = new Reader();
		Graph matriz = reader.leerTxt(ruta);
		matriz.print();
	}

}
