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
		
		long[][] matrizA = {{0,30,999999999,999999999,15},{30,0,25,999999999,40},{999999999,25,0,15,70},{999999999,999999999,15,0,90},{15,40,70,90,0}};
		AlgoritmoFloyd algoritmo = new AlgoritmoFloyd();
		System.out.println(algoritmo.algoritmoFloyd(matrizA));
	}

}
