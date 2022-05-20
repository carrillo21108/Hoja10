/**
 * 
 */
package uvg.edu.io;


public class Conexion {
	
	String ciudad1 = "";
    String ciudad2 = "";
    int km = 0;
    
    public Conexion() {
    }

    /**
     * Constructor
     * @param ciudad1
     * @param ciudad2
     * @param km
     */
    public Conexion(String ciudad1, String ciudad2, String km){
    	this.ciudad1 = ciudad1;
    	this.ciudad2 = ciudad1;
    	this.km = Integer.parseInt(km);
    }

    /**
     * metodo toString
     * @return string
     */
    @Override
    public String toString() {
        return "ciudad1 = " + ciudad1 + ' ' + ", ciudad2 = " + ciudad2 + ' ' + ", km = " + km ;
    }

}
