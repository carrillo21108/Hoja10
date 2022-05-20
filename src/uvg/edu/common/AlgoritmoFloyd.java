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
	
	public String algoritmoFloyd(long[][] matriz) {
		int vertices = matriz.length;
		long[][] matrizAdyacencia = matriz;
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
					temp1 = matrizAdyacencia[i][j];
					temp2 = matrizAdyacencia[i][k];
					temp3 = matrizAdyacencia[k][j];
					temp4 = temp2+temp3;
					
					//Camino minimo
					min = Math.min(temp1, temp4);
					if(temp1 != temp4) {
						if(min == temp4) {
							caminoRecorrido = "";
							caminosAux[i][j] = k + "";
							caminos[i][j] = caminosR(i,k,caminosAux,caminoRecorrido) + (k + 1);
						}
					}
					
					matrizAdyacencia[i][j] = (long) min;
				}
			}
		}
		
		//Agregando el camino minimo a cadena
		for(i=0;i<vertices;i++) {
			for(j=0;j<vertices;j++) {
				cadena = cadena + "["+matrizAdyacencia[i][j]+"]";
			}
			
			cadena = cadena + "\n";
		}
		
		for(i=0;i<vertices;i++) {
			for(j=0;j<vertices;j++) {
				if(matrizAdyacencia[i][j] != 1000000000) {
					if(i != j) {
						if(caminos[i][j].equals("")) {
							caminitos += "De ("+(i+1)+"--->"+(j+1)+") Irse por... ("+(i+1)+", "+(j+1)+")\n";
						}else {
							caminitos += "De ("+(i+1)+"--->"+(j+1)+") Irse por... ("+(i+1)+", "+caminos[i][j]+", "+(j+1)+")\n";
						}
					}
				}
			}
		}
		
		return "La matriz de caminos mas cortos entre los diferentes vertices es:\n"+cadena+
				"\nLos diferentes caminos mas cortos entre vertices son:\n"+caminitos;
	}
	
	public String caminosR(int i, int k, String[][]caminosAux, String caminoRecorrido) {
		if(caminosAux[i][k].equals("")) {
			return "";
		}else {
			//Recursividad
			caminoRecorrido += caminosR(i,Integer.parseInt(caminosAux[i][k].toString()),caminosAux,caminoRecorrido)+(Integer.parseInt(caminosAux[i][k].toString())+1)+", ";
			return caminoRecorrido;
		}
	}
}
