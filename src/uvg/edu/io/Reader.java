/**
 * 
 */
package uvg.edu.io;

import uvg.edu.common.Graph;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;


public class Reader {
	
	public Reader(){}
	
	public Graph leerTxt(String ruta){
		
		File archivo = null;
		FileReader fr = null;
        BufferedReader br = null;
        
        ArrayList<String> guategrafo = obtenerCiudades(ruta);
        
        Graph matriz = new Graph(guategrafo.size());

        try{
        	//Nombre del archivo que se lee para obtener los datos de las ciudades
        	archivo = new File (ruta);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;

            while((linea=br.readLine()) != null){
                String[] data = linea.split(" ");

                matriz.add(guategrafo.indexOf(data[0]), guategrafo.indexOf(data[1]), data[2]);
                matriz.add(guategrafo.indexOf(data[1]), guategrafo.indexOf(data[0]), data[2]);
            }
            
            return matriz;
            
        }catch(Exception e){
        	
        	//En caso no se pueda escanear el archivo
        	System.out.println("Error al escanear el archivo.");
            e.printStackTrace();
            
        }finally{
        	
            // En el finally cerramos el archivo, tanto si se leyo correctamente como si
        	// se encontro alguna excepcion.
            try{
            	//Cierre del archivo
                if( fr != null ){   
                    fr.close();     
                }                  
            }catch (Exception f){
            	//En caso el archivo no pueda ser cerrado
            	System.out.println("Error al cerrar el archivo.");
               f.printStackTrace();
            }
        }
		
        return null;
		
	}
	
	public ArrayList<String> obtenerCiudades(String ruta){
		ArrayList<String> guategrafo = new ArrayList<String>();
        
		File archivo = null;
		FileReader fr = null;
        BufferedReader br = null;
        Conexion conectando  =  new Conexion();
        
        try{
        	//Nombre del archivo que se lee para obtener los datos de las ciudades
            archivo = new File (ruta);
        	fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;

            while((linea=br.readLine())!=null){
                String[] data = linea.split(" ");
                conectando  =  new Conexion(data[0],data[1],data[2]);
                
                if (!guategrafo.contains(conectando.ciudad1)){
                	guategrafo.add(conectando.ciudad1);
                }
                if (!guategrafo.contains(conectando.ciudad2)){
                	guategrafo.add(conectando.ciudad2);
                }

            }
            
            return guategrafo;
            
        }catch(Exception e){
        	
        	//En caso no se pueda escanear el archivo
        	System.out.println("Error al escanear el archivo.");
            e.printStackTrace();
            
        }finally{
        	
            // En el finally cerramos el archivo, tanto si se leyo correctamente como si
        	// se encontro alguna excepcion.
            try{
                if( fr != null ){   
                    fr.close();     
                }                  
            }catch (Exception f){
            	//En caso el archivo no pueda ser cerrado
            	System.out.println("Error al cerrar el archivo.");
               f.printStackTrace();
            }
        }
        
        return null;
	}
	
	public void update(String ruta, String origen, String destino, String distancia) {
		try {
			//Creacion de objeto de archivo
			File archivo = new File(ruta);
			
			FileWriter fw = new FileWriter(archivo);
			BufferedWriter bw = new BufferedWriter(fw);
			
			FileReader fr = new FileReader(archivo);
			BufferedReader br = new BufferedReader(fr);
			
			ArrayList<String> data = new ArrayList<String>();
			
			try{
	        	//Nombre del archivo que se lee para obtener los datos de las ciudades
				archivo = new File (ruta);
	            fr = new FileReader(archivo);
	            br = new BufferedReader(fr);

	            // Lectura del fichero
	            String linea;

	            while((linea=br.readLine()) != null){
	                data.add(linea);
	            }
	            
	            
	        }catch(Exception e){
	        	
	        	//En caso no se pueda escanear el archivo
	        	System.out.println("Error al escanear el archivo.");
	            e.printStackTrace();
	            
	        }finally{
	        	
	            // En el finally cerramos el archivo, tanto si se leyo correctamente como si
	        	// se encontro alguna excepcion.
	            try{
	            	//Cierre del archivo
	                if( fr != null ){   
	                    fr.close();     
	                }                  
	            }catch (Exception f){
	            	//En caso el archivo no pueda ser cerrado
	            	System.out.println("Error al cerrar el archivo.");
	               f.printStackTrace();
	            }
	        }
			
			data.add(origen+" "+destino+" "+distancia);
			
			//Creacion del contenido del archivo
			String contenido="";
			for(String fila:data) {
				contenido += fila+"\n";
			}
			
			//Modificacion de todo el contenido
			bw.write(contenido);
			bw.close();
			
		}catch(Exception e) {
			System.out.println("Error al actualizar el archivo.");
			e.printStackTrace();
		}
	}

}