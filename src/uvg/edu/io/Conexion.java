/**
 * 
 */
package uvg.edu.io;


public class Conexion {
	
	public String ciudad1 = "";
    public String ciudad2 = "";
    public int km = 0;
    
    /**
	 * Constructor sin parámetros
	 * 
	 */
    public Conexion() {
    }

    /**
     * Constructor parametrizado
     * Precondicion:
     * @param ciudad1: Nombre de la primera ciudad
     * @param ciudad2: Nombre de la segunda ciudad
     * @param km: Cntidad de kilometros entre una ciudad y otra
     * 
     * @see Integer#parseInt(String)
     */
    public Conexion(String ciudad1, String ciudad2, String km){
    	this.ciudad1 = ciudad1;
    	this.ciudad2 = ciudad2;
    	this.km = Integer.parseInt(km);
    }

    /**
	 * Este método se utiliza para imprimir todos los atributos de una conexion
	 * Postcondicion:
	 * @return String: nombre y valor de todos los atributos de la clase
	 * 
	 */
    @Override
    public String toString() {
        return "ciudad1 = " + ciudad1 + ' ' + ", ciudad2 = " + ciudad2 + ' ' + ", km = " + km ;
    }

}