/**
 * 
 */
package uvg.edu.main;

import uvg.edu.common.AlgoritmoFloyd;

/**
 * @author Brian Carrillo
 *
 */
public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long matrizA[][]= {{0,3,4,999999999,8,999999999},{999999999,0,999999999,999999999,5,999999999},{999999999,999999999,0,999999999,3,999999999},{999999999,999999999,999999999,0,999999999,999999999},{999999999,999999999,999999999,7,0,3},{999999999,999999999,999999999,2,999999999,0}};
		AlgoritmoFloyd floyd = new AlgoritmoFloyd();
		System.out.println(floyd.algoritmoFloyd(matrizA));
	}

}
