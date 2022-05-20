/**
 * 
 */
package uvg.edu.main;
/**
 * @author Brian Carrillo
 * Clase principal
 * 
 * @version 19.05.2022
 */

import uvg.edu.common.AlgoritmoFloyd;
import uvg.edu.common.Graph;
import uvg.edu.io.Conexion;
import java.util.Scanner;
import uvg.edu.io.Reader;
import java.util.ArrayList;

public class Principal {

	/**
	 * @param args
	 * @param matriz 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		long matrizA[][]= {{0,3,4,999999999,8,999999999},{999999999,0,999999999,999999999,5,999999999},{999999999,999999999,0,999999999,3,999999999},{999999999,999999999,999999999,0,999999999,999999999},{999999999,999999999,999999999,7,0,3},{999999999,999999999,999999999,2,999999999,0}};
		AlgoritmoFloyd floyd = new AlgoritmoFloyd();
		System.out.println(floyd.algoritmoFloyd(matrizA));
		
		
		ArrayList<String> guategrafo = new ArrayList<String>();
		

		
		/**
		 * mensaje inicial
		 */
		
		System.out.println("Bienvenido a DRIVER");
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
                    System.out.println("1. Agregar");
                    System.out.println("2. Ver matriz de Floyd");
                    System.out.println("3. Ver rutas cortas");
                    System.out.println("4. Salir");
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
				 /**
                 * como la distancia no cambia, se toma como si la distancia fuera tanto de origen a destino como de destino a origen
                 */
                System.out.println("Este método se recomienda solo usar una vez, ya que");
                System.out.println("Otra segunda correccion borrar todos los nuevos cambios realizados");
                System.out.println("Ingrese la ciudadd destino");
                String origen = scanner.nextLine();

                System.out.println("Ingrese la ciudad origen");
                String destino = scanner.nextLine();

                System.out.println("Ingrese la cantidad de km");
                int km = Integer.parseInt(scanner.nextLine());

                if (!guategrafo.contains(origen)){
                    guategrafo.add(origen);
                }

                //corroborando el vertice de la ciudad 2
                if (!guategrafo.contains(destino)){
                    guategrafo.add(destino);
                }
               
                Graph matriz = new Graph(guategrafo.size());
                try{
                   // FileReader r = new FileReader("guategrafo.txt");
                   // BufferedReader buffer = new BufferedReader(r);

                    String temp ="";

                    while(temp!=null){
                       // temp = buffer.readLine();
                       // if(temp == null){
                            //break;
                      //  }
                        String[] data = temp.split(" ");
                        Conexion conectando  =  new Conexion(data[0],data[1],data[2]);
                        //corroborando el vertice de la ciudad 1
                        if (!guategrafo.contains(conectando.ciudad1)){
                            guategrafo.add(conectando.ciudad1);
                        }

                        //corroborando el vertice de la ciudad 2
                        if (!guategrafo.contains(conectando.ciudad2)){
                           guategrafo.add(conectando.ciudad2);
                        }

                        for (int i=0;i<conectando.km;i++){
                        	matriz.add(guategrafo.indexOf(conectando.ciudad1), guategrafo.indexOf(conectando.ciudad2), data[2]);
                            matriz.add(guategrafo.indexOf(conectando.ciudad2), guategrafo.indexOf(conectando.ciudad1), data[2]);
                        }

                    }
                }catch(Exception e){
                    System.out.println("archivo no encontrado");
                }

                for (int i=0;i<km;i++){
                	//matriz.add(guategrafo.indexOf(conectando.ciudad1), guategrafo.indexOf(conectando.ciudad2), data[2]);
                    //matriz.add(guategrafo.indexOf(conectando.ciudad2), guategrafo.indexOf(conectando.ciudad1), data[2]);
                }
                System.out.println("Se ha agregado a la matriz");

                System.out.println("\nMatriz de adyacencia para Floyd (0-->infinito)\n");

                matriz.printInf();

				
			case 2:
				AlgoritmoFloyd floyd2 = new AlgoritmoFloyd();
				System.out.println("Matriz de adyacencia para Floyd (0-->infinito)");
				
			//	matriz.printInf();
				//System.out.println(floyd2.algoritmoFloyd(matrizA))); pa cuando este el grafo

				
			case 3:
				AlgoritmoFloyd floyd3 = new AlgoritmoFloyd();
                System.out.println("\nMatriz de adyacencia para Floyd (0-->infinito)\n");

                //matriz.printInf();
                //System.out.println(floyd3.algoritmoFloyd(guategrafo,matriz.retornar()));

				
				
				
			case 4:
				//Almacenamiento del ordenamiento
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
