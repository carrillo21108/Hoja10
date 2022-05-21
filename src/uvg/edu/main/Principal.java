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
		
		AlgoritmoFloyd algoritmo = new AlgoritmoFloyd();
		ArrayList<String> ciudades;
		Graph matriz;
		Controller controller;
		
		//Instancia del scanner
		Scanner scanner = new Scanner(System.in);
		//Solicitud de la ruta del archivo.
		System.out.println("Ingrese la ruta en la que se encuentra el archivo .txt a escanear.");
		String ruta = scanner.nextLine();
		
		//Instancia de la clase que escaneara ListadoProducto.txt
		Reader reader = new Reader();
		ciudades = reader.obtenerCiudades(ruta);
		matriz = reader.leerTxt(ruta);
		controller = new Controller(ciudades, matriz);
		
		if(!controller.validacionGrafo(matriz)) {
			
			System.out.println("El grafo ingresado no es conexo.");
			
		}else {
			System.out.println("El grafo ingresado es conexo.");
			
			/**
			 * mensaje inicial
			 */
			System.out.println("--Bienvenido a GraphTrafic");
	        
			/**
	         * se lee el archivo txt para saber el espacio de la matriz
	         */
			//Banderas para el manejo de menu y errores
			boolean menu = true;
			boolean error = false;
			int opcion;
					
			//ciclo del menu
			do {
				do {
					opcion = 0;
					//verificar opciones
					try {
						//Solicitud de opcion de menu
	                    System.out.println("\n---MENU---");
	                    System.out.println("[1] Ver ruta mas corta entre dos ciudades.");
	                    System.out.println("[2] Ciudad en el centro.");
	                    System.out.println("[3] Agregar conexion entre dos ciudades.");
	                    System.out.println("[4] Interrumpir trafico entre dos ciudades.");
	                    System.out.println("[5] Salir.");
	                    opcion = scanner.nextInt();
	                    error = false;
						
					}catch (Exception e) {
						System.out.println("Error de ingreso, intente de nuevo");
						error = true;
						
					}finally {
						scanner.nextLine();
					}
					
				}while(error);
				
			
				switch(opcion) {
				case 1:
					if(!controller.validacionGrafo(matriz)) {
						
						System.out.println("El grafo ingresado no es conexo.");
						
					}else {
						System.out.println("Ingrese el nombre de la ciudad origen.");
						String ciudadOrigen = scanner.nextLine();
						
						System.out.println("Ingrese el nombre de la ciudad destino.");
						String ciudadDestino = scanner.nextLine();
						
						System.out.println(controller.obtenerRuta(ciudadOrigen,ciudadDestino));
					}
					break;

				case 2:
					if(!controller.validacionGrafo(matriz)) {
						
						System.out.println("El grafo ingresado no es conexo.");
						
					}else {
						System.out.println("La ciudad que se encuentra en el centro del grafo es: " + controller.centerGraph());
					}
	        		break;

					
				case 3:
					System.out.println("Ingrese el nombre de la ciudad origen.");
					String origen = scanner.nextLine();
					
					System.out.println("Ingrese el nombre de la ciudad destino.");
					String destino = scanner.nextLine();
					
					System.out.println("Ingrese la distancia entre ciudades.");
					String distancia = scanner.nextLine();
					
					reader.update(ruta,origen,destino,distancia);
					ciudades = reader.obtenerCiudades(ruta);
					matriz = reader.leerTxt(ruta);
					controller = new Controller(ciudades, matriz);
					
					System.out.println("Conexion agregada con exito.");
					
	        		break;
					
				case 4:
					System.out.println("Ingrese el nombre de la ciudad origen.");
					String origenEliminar = scanner.nextLine();
					
					System.out.println("Ingrese el nombre de la ciudad destino.");
					String destinoEliminar = scanner.nextLine();
					
					System.out.println("Ingrese la distancia entre ciudades.");
					String distanciaEliminar = scanner.nextLine();
					
					reader.delete(ruta,origenEliminar,destinoEliminar,distanciaEliminar);
					ciudades = reader.obtenerCiudades(ruta);
					matriz = reader.leerTxt(ruta);
					controller = new Controller(ciudades, matriz);
					
					System.out.println("Conexion eliminada con exito.");
	        		break;
	        	
				case 5:
	        		System.out.println("Saliendo...");
	        		menu = false;
	        		break;
	        	default:
	        		System.out.println("Opcion incorrecta. Intentelo de nuevo.");
	        		break;
				}
			
			}while(menu);
		}
	}

}