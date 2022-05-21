/**
 * 
 */
package uvg.edu.common;

import java.util.ArrayList;

/**
 * @author Brian Carrillo
 *
 */
public class AlgoritmoFloyd {
	//Metodo que determina los caminos minimos
	
		/**
		 * Este metodo se utiliza para los vertices, caminoRecorrido, cadena, caminitos
		 * @param ciudades
		 * @param matriz
		 * @return respuestas
		 */
		
		public ArrayList<String> algoritmoFloyd(ArrayList<String>ciudades, Graph matriz) {
			
			ArrayList<String> respuestas = new ArrayList<String>();
			
			int vertices = matriz.tamaño();
			Graph matrizAdyacencia = matriz;
			String caminos[][] = new String[vertices][vertices];
			String caminosAux[][] = new String[vertices][vertices];
			String caminoRecorrido = "";
			String cadena = "";
			String caminitos = "";
			
			
		
			int i,j,k;
			float temp1,temp2,temp3,temp4,min;
			
			for(i=0;i<vertices;i++) {
				for(j=0;j<vertices;j++) {
					caminos[i][j]="";
					caminosAux[i][j]="";
				}
			}
			
			for(k=0;k<vertices;k++) {
				for(i=0;i<vertices;i++) {
					for(j=0;j<vertices;j++) {
						temp1 = matrizAdyacencia.devolver(i, j);
						temp2 = matrizAdyacencia.devolver(i, k);
						temp3 = matrizAdyacencia.devolver(k, j);
						temp4 = temp2+temp3;
						
						//Camino minimo
						min = Math.min(temp1, temp4);
						if(temp1 != temp4) {
							if(min == temp4) {
								caminoRecorrido = "";
								caminosAux[i][j] = k + "";
								caminos[i][j] = caminosR(i,k,caminosAux,caminoRecorrido) + (k);
							}
						}
						
						matrizAdyacencia.modify(i,j,(long) min);
					}
				}
			}
			
			/**
			 * Agregando el camino minimo a cadena
			 */
			
			for(i=0;i<vertices;i++) {
				for(j=0;j<vertices;j++) {
					cadena = cadena + "["+matrizAdyacencia.devolver(i, j)+"]";
				}
				
				cadena = cadena + "\n";
			}
			/*
			 * 
			 */
			
			for(i=0;i<vertices;i++) {
				for(j=0;j<vertices;j++) {
					if(matrizAdyacencia.devolver(i, j) != 1000000000) {
						if(i != j) {
							if(caminos[i][j].equals("")) {
								caminitos += i+", "+j+", "+i+", "+j+"\n";
							}else {
								caminitos += i+", "+j+", "+i+", "+caminos[i][j]+", "+j+"\n";
							}
						}
					}
				}
			}
			/**
			 * agregar cadena y caminitus
			 */
			respuestas.add(cadena);
			respuestas.add(caminitos);
			return respuestas;
		}
		
		/**
		 * Este metodo se utiliza para caminosR, camunosAuxi, caminoRecorrido
		 * @param i
		 * @param k
		 * @param caminosAux
		 * @param caminoRecorrido
		 * @return caminoRecorrido
		 */
		public String caminosR(int i, int k, String[][]caminosAux, String caminoRecorrido) {
			if(caminosAux[i][k].equals("")) {
				return "";
			}else {
				//Recursividad
				caminoRecorrido += caminosR(i,Integer.parseInt(caminosAux[i][k].toString()),caminosAux,caminoRecorrido)+(Integer.parseInt(caminosAux[i][k].toString()))+", ";
				return caminoRecorrido;
			}
		}
}
