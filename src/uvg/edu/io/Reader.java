/**
 * 
 */
package uvg.edu.io;

/**
 * @author Brian Carrillo
 *
 */
import uvg.edu.common.Graph;
import uvg.edu.io.Conexion;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;


public class Reader {
	
public Reader(){}
	
	public Graph leerTxt(String ruta){
		
		ArrayList<String> guategrafo = new ArrayList<String>();
        FileReader fr = null;
        BufferedReader br = null;
        Conexion conectando  =  new Conexion();
        
        try{
        	//Nombre del archivo que se lee para obtener los datos de las ciudades
            fr = new FileReader(ruta);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea ="";

            while(linea != null){
            	linea = br.readLine();
                if(linea == null){
                    break;
                }
                String[] data = linea.split(" ");
                conectando  =  new Conexion(data[0],data[1],data[2]);
                if (!guategrafo.contains(conectando.ciudad1)){
                	guategrafo.add(conectando.ciudad1);
                }
                if (!guategrafo.contains(conectando.ciudad2)){
                	guategrafo.add(conectando.ciudad2);
                }

            }
        }catch(Exception e){
            System.out.println("archivo no encontrado");
        }

        Graph matriz = new Graph(guategrafo.size());

        try{
        	//Nombre del archivo que se lee para obtener los datos de las ciudades
            fr = new FileReader(ruta);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea ="";

            while(linea != null){
                linea = br.readLine();
                if(linea == null){
                    break;
                }
                String[] data = linea.split(" ");

                matriz.add(guategrafo.indexOf(conectando.ciudad1), guategrafo.indexOf(conectando.ciudad2), data[2]);
                matriz.add(guategrafo.indexOf(conectando.ciudad2), guategrafo.indexOf(conectando.ciudad1), data[2]);

            }
        }catch(Exception e){
            System.out.println("archivo no encontrado");
        }
		
 
        return matriz;
		
	}


}
